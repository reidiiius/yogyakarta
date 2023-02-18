package yogyakarta;

class Vestibule {

    static Metallophone kettle = new Metallophone();

    final static String[] stocks = kettle.getTunings();

    public static void main(String[] args) {
        kettle.dyadic = true;
        kettle.scales.put("i0", "____ ".repeat(12));

        if (args.length > kettle.scales.size()) {
            System.err.println("Request denied: Excessive arguments!");
        }
        else if (args.length > 0) {
            String flaw, sign, tuned = stocks[0];
            long aeon = kettle.horoLog();
            int span, limit = 9;

            for (String item : args) {
                if (item.length() > limit) {
                    kettle.buffs.add(item.substring(0, limit));
                    continue;
                }
                kettle.buffs.add(item);
            }

            if (kettle.buffs.size() == 1) {
                if (kettle.sentinel(kettle.buffs.get(0))) {
                    sign = kettle.buffs.get(0);

                    System.out.println();
                    kettle.compose(tuned, sign, aeon);
                }
                else if (kettle.buffs.get(0).equals("gamut")) {
                    kettle.every(tuned);
                }
                else if (kettle.guardian(kettle.buffs.get(0))) {
                    kettle.dashboard();
                }
                else {
                    flaw = kettle.buffs.get(0);

                    System.out.println(String.format("\n\t%s ?\n", flaw));
                    kettle.stockpile();
                    System.out.println();
                }
            }
            else if (kettle.buffs.size() == 2) {
                if (kettle.sentinel(kettle.buffs.get(0)) &&
                    kettle.sentinel(kettle.buffs.get(1))) {
                    System.out.println();
                    for (String clef : kettle.buffs) {
                        kettle.compose(tuned, clef, aeon);
                    }
                }
                else if (kettle.guardian(kettle.buffs.get(0)) &&
                    kettle.sentinel(kettle.buffs.get(1))) {
                    tuned = kettle.stockade(kettle.buffs.get(0));
                    sign = kettle.buffs.get(1);

                    System.out.println();
                    kettle.compose(tuned, sign, aeon);
                }
                else if (kettle.guardian(kettle.buffs.get(0)) &&
                    kettle.buffs.get(1).equals("gamut")) {
                    tuned = kettle.stockade(kettle.buffs.get(0));

                    kettle.every(tuned);
                }
                else if (kettle.guardian(kettle.buffs.get(0)) &&
                    ! kettle.sentinel(kettle.buffs.get(1))) {
                    kettle.dashboard();
                }
                else if (kettle.buffs.get(0).equals("group")) {
                    kettle.regroup(kettle.buffs.get(1));
                }
                else if (kettle.buffs.get(0).equals("query")) {
                    kettle.request(kettle.buffs.get(1));
                }
                else {
                    flaw = kettle.buffs.get(0);

                    System.out.println(String.format("\n\t%s ?\n", flaw));
                    kettle.stockpile();
                    System.out.println();
                }
            }
            else {
                if (kettle.sentinel(kettle.buffs.get(0))) {
                    System.out.println();
                    for (String clef : kettle.buffs) {
                        kettle.compose(tuned, clef, aeon);
                    }
                }
                else if (kettle.guardian(kettle.buffs.get(0))) {
                    tuned = kettle.stockade(kettle.buffs.get(0));

                    System.out.println();
                    for (int niter = 1; niter < kettle.buffs.size(); niter++) {
                        sign = kettle.buffs.get(niter);

                        kettle.compose(tuned, sign, aeon);
                    }
                }
                else {
                    flaw = kettle.buffs.get(0);

                    System.out.println(String.format("\n\t%s ?\n", flaw));
                    kettle.stockpile();
                    System.out.println();
                }
            }

            kettle.buffs.clear();
        }
        else {
            kettle.dashboard();
        }

        kettle.scales.clear();
    }

}

