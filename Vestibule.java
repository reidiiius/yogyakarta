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
        else if (args.length > 0) {
            String flaw, sign, tuned;
            long aeon = kettle.horoLog();
            int span, limit = 9;

            for (String item : args) {
                if (item.length() > limit) {
                    kettle.clefs.add(item.substring(0, limit));
                    continue;
                }
                kettle.clefs.add(item);
            }

            if (kettle.clefs.size() == 1) {
                if (kettle.sentinel(kettle.clefs.get(0))) {
                    tuned = kettle.tunings[0];

                    System.out.println();
                    for (String clef : kettle.clefs) {
                        kettle.compose(tuned, clef, aeon);
                    }

                    return;
                }
                else if (kettle.clefs.get(0).equals("gamut")) {
                    tuned = kettle.tunings[0];

                    kettle.every(tuned);
                    return;
                }
                else if (! kettle.guardian(kettle.clefs.get(0))) {
                    flaw = kettle.clefs.get(0);

                    System.out.println(String.format("\n\t%s ?\n", flaw));
                    for (String item : kettle.tunings) {
                       System.out.println(String.format("\t%s", item));
                    }
                    System.out.println();
                    return;
                }
                else {
                    kettle.dashboard();
                }
            }
            else if (kettle.clefs.size() == 2) {
                if (kettle.guardian(kettle.clefs.get(0)) &&
                    kettle.clefs.get(1).equals("gamut")) {
                    tuned = kettle.stockade(kettle.clefs.get(0));

                    kettle.every(tuned);
                    return;
                }
                else if (kettle.clefs.get(0).equals("group")) {
                    kettle.regroup(kettle.clefs.get(1));
                    return;
                }
                else if (kettle.clefs.get(0).equals("query")) {
                    kettle.request(kettle.clefs.get(1));
                    return;
                }
                else if (kettle.guardian(kettle.clefs.get(0)) &&
                    kettle.sentinel(kettle.clefs.get(1))) {
                    tuned = kettle.stockade(kettle.clefs.get(0));

                    System.out.println();
                    for (int niter = 1; niter < kettle.clefs.size(); niter++) {
                        sign = kettle.clefs.get(niter);

                        kettle.compose(tuned, sign, aeon);
                    }
                }
                else if (kettle.sentinel(kettle.clefs.get(0)) &&
                    kettle.sentinel(kettle.clefs.get(1))) {
                    tuned = kettle.tunings[0];

                    System.out.println();
                    for (String clef : kettle.clefs) {
                        kettle.compose(tuned, clef, aeon);
                    }
                }
                else {
                    flaw = kettle.clefs.get(0);

                    System.out.println(String.format("\n\t%s ?\n", flaw));
                    for (String item : kettle.tunings) {
                       System.out.println(String.format("\t%s", item));
                    }
                    System.out.println();
                    return;
                }
            }
            else if (kettle.clefs.size() > 2) {
                if (kettle.guardian(kettle.clefs.get(0)) &&
                    kettle.sentinel(kettle.clefs.get(1)) &&
                    kettle.sentinel(kettle.clefs.get(2))) {
                    tuned = kettle.stockade(kettle.clefs.get(0));

                    System.out.println();
                    for (int niter = 1; niter < kettle.clefs.size(); niter++) {
                        sign = kettle.clefs.get(niter);

                        kettle.compose(tuned, sign, aeon);
                    }
                }
                else if (kettle.sentinel(kettle.clefs.get(0)) &&
                    kettle.sentinel(kettle.clefs.get(1)) &&
                    kettle.sentinel(kettle.clefs.get(2))) {
                    tuned = kettle.tunings[0];

                    System.out.println();
                    for (String clef : kettle.clefs) {
                        kettle.compose(tuned, clef, aeon);
                    }
                }
                else {
                    kettle.dashboard();
                }
            }
            else {
                flaw = kettle.clefs.get(0);

                System.out.println(String.format("\n\t%s ?\n", flaw));
                for (String item : kettle.tunings) {
                   System.out.println(String.format("\t%s", item));
                }
                System.out.println();
                return;
            }

            kettle.clefs.clear();
        }
        else {
            kettle.dashboard();
        }

        kettle.scales.clear();
    }

}

