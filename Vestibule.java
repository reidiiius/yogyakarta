package yogyakarta;

class Vestibule {

    static Metallophone kettle = new Metallophone();

    public static void main(String[] args) {
        kettle.dyadic = true;
        kettle.scales.put("i0", "____ ".repeat(12));

        if (args.length > kettle.scales.size()) {
            System.err.println("Request denied: Excessive arguments!");
            return;
        }

        if (args.length > 0) {
            String flaw, wire, tuned = new String();
            long aeon = kettle.horoLog();
            byte limit = 9;

            if (kettle.sentinel(args[0])) {
                tuned = "default";

                for (String item : args) {
                    if (item.length() > limit) {
                        kettle.clefs.add(item.substring(0, limit));
                        continue;
                    }
                    kettle.clefs.add(item);
                }
            }
            else if (args.length == 1 && args[0].equals("gamut")) {
                tuned = "default";

                kettle.every(tuned);
                return;
            }
            else if (args.length == 2 && args[1].equals("gamut")) {
                short count = 0;

                while (count < kettle.tunings.length) {
                    if (args[0].equals(kettle.tunings[count])) {
                        tuned = args[0];

                        kettle.every(tuned);
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
                    kettle.regroup(args[1]);
                }
                else {
                    flaw = args[1].substring(0, limit);

                    System.out.println("\n\t" + flaw + "..?\n");
                }
                return;
            }
            else if (args.length == 2 && args[0].equals("query")) {
                if (args[1].length() < limit) {
                    kettle.request(args[1]);
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
                                kettle.clefs.add(args[niter].substring(0, limit));
                                continue;
                            }
                            kettle.clefs.add(args[niter]);
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

            if (kettle.clefs.isEmpty()) {
                kettle.dashboard();
                return;
            }

            System.out.println();
            for (String sign : kettle.clefs) {
                kettle.compose(tuned, sign, aeon);
            }

            kettle.clefs.clear();
        }
        else {
            kettle.dashboard();
        }

        kettle.scales.clear();
    }

}

