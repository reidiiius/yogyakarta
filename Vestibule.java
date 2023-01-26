package yogyakarta;

import java.util.ArrayList;
import java.util.regex.Pattern;
import yogyakarta.Metallophone;

class Vestibule {

    public static void main(String[] args) {
        Metallophone kettle = new Metallophone();

        kettle.dyadic = true;

        kettle.populateDataBank();
        kettle.pelog.put("i0", "____ ".repeat(12));

        if (args.length > 0) {
            String flaw, wire, tuned = new String();
            long aeon = System.currentTimeMillis();
            byte limit = 9;

            String[] strums = {
                "beadgcf",
                "bfbfb",
                "cgdae",
                "dadgad",
                "dgdgbd",
                "eadgbe",
                "fkbjdn",
                "unison",
            };

            ArrayList<String> clefs = new ArrayList<String>();

            if (Pattern.matches("^([ijkn][0-9]+?)+?.*", args[0])) {
                tuned = "default";
                for (String item : args) {
                    if (item.length() > limit) {
                        clefs.add(item.substring(0, limit));
                        continue;
                    }
                    clefs.add(item);
                }
            }
            else if (args.length == 1 && args[0].equals("gamut")) {
                System.out.println();
                for (String sign : kettle.pelog.keySet()) {
                    kettle.lontar(tuned, sign, aeon);
                }
                return;
            }
            else if (args.length == 2 && args[1].equals("gamut")) {
                short count = 0;
                while (count < strums.length) {
                    if (args[0].equals(strums[count])) {
                        tuned = args[0];
                        System.out.println();
                        for (String sign : kettle.pelog.keySet()) {
                            kettle.lontar(tuned, sign, aeon);
                        }
                        break;
                    }
                    count++;
                }

                if (! tuned.isEmpty()) {
                    return;
                }
            }
            else {
                short count = 0;
                while (count < strums.length) {
                    if (args[0].equals(strums[count])) {
                        tuned = args[0];
                        for (short niter = 1; niter < args.length; niter++) {
                            if (args[niter].length() > limit) {
                                clefs.add(args[niter].substring(0, limit));
                                continue;
                            }
                            clefs.add(args[niter]);
                        }
                        break;
                    }
                    count++;
                }

                if (clefs.size() > kettle.pelog.size()) {
                    System.err.println("Request denied: Excessive arguments!");
                    return;
                }
            }

            if (tuned.isEmpty()) {
                int span = args[0].length();
                flaw = span < limit ? args[0] : args[0].substring(0, limit);
                System.out.println(String.format("\n\t%s ?\n", flaw));
                for (String item : strums) {
                    System.out.println(String.format("\t%s", item));
                }
                System.out.println();
                return;
            }

            if (clefs.isEmpty()) {
                kettle.displayMenu();
                return;
            }

            System.out.println();
            for (String sign : clefs) {
                kettle.lontar(tuned, sign, aeon);
            }
        }
        else {
            kettle.displayMenu();
        }

        kettle.pelog.clear();
    }

}

