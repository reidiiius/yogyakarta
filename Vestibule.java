package yogyakarta;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Vestibule {

    static Metallophone kettle = new Metallophone();

    static ArrayList<String> clefs = new ArrayList<String>();

    static void apprisal() {
        if (clefs.isEmpty()) {
            System.out.println("\n\tNothing matched!\n");
        }
        else {
            String[] stars = new String[clefs.size()];

            kettle.tabulate(clefs.toArray(stars));
        }
    }

    // research pelog values
    static void regroup(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");
        String brief;

        for (String sign : kettle.pelog.keySet()) {
            brief = kettle.pelog.get(sign);

            if (kettle.dyadic) {
                brief = kettle.translate(brief);
            }

            if (Pattern.matches(kinda, brief)) {
                clefs.add(sign);
            }
        }

        apprisal();
    }

    // research pelog keys
    static void request(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");

        for (String sign : kettle.pelog.keySet()) {
            if (Pattern.matches(kinda, sign)) {
                clefs.add(sign);
            }
        }

        apprisal();
    }

    // application entryway
    public static void main(String[] args) {
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
            else if (args.length == 2 && args[0].equals("group")) {
                if (args[1].length() < limit) {
                    regroup(args[1]);
                }
                else {
                    flaw = args[1].substring(0, limit);
                    System.out.println("\n\t" + flaw + "..?\n");
                }

                return;
            }
            else if (args.length == 2 && args[0].equals("query")) {
                if (args[1].length() < limit) {
                    request(args[1]);
                }
                else {
                    flaw = args[1].substring(0, limit);
                    System.out.println("\n\t" + flaw + "..?\n");
                }

                return;
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

