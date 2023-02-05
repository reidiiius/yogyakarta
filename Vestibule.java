package yogyakarta;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Vestibule {

    public static void main(String[] args) {
        Metallophone kettle = new Metallophone();

        kettle.dyadic = true;

        kettle.pelog.put("i0", "____ ".repeat(12));

        if (args.length > kettle.pelog.size()) {
            System.err.println("Request denied: Excessive arguments!");
            return;
        }

        if (args.length > 0) {
            String flaw, wire, tuned = new String();
            long aeon = kettle.horoLog();
            byte limit = 9;

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
                while (count < kettle.tunings.length) {
                    if (args[0].equals(kettle.tunings[count])) {
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
                while (count < kettle.tunings.length) {
                    if (args[0].equals(kettle.tunings[count])) {
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
            }

            if (tuned.isEmpty()) {
                int span = args[0].length();
                flaw = span < limit ? args[0] : args[0].substring(0, limit);
                System.out.println(String.format("\n\t%s ?\n", flaw));
                for (String item : kettle.tunings) {
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

