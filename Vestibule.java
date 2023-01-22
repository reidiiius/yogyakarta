package yogyakarta;

import yogyakarta.Metallophone;

class Vestibule {

    public static void main(String[] args) {
        String sign, wire;
        long aeon = System.currentTimeMillis();

        // initialize treemap and timestamp
        Metallophone kettle = new Metallophone();

        // populate treemap
        kettle.populateDataBank();

        // check for user input
        if (args.length > 0) {
            System.out.println();
            for (String clef : args) {
                sign = clef;
                if (kettle.pelog.containsKey(sign)) {
                    wire = kettle.pelog.get(sign);
                    if (wire != null && wire.length() >= 60) {
                        kettle.eadgbe(sign, wire, aeon);
                    }
                 } else {
                    wire = String.format("\t%s ?", sign);
                    System.out.println(wire);
                }
                System.out.println();
            }
        }
        else {
            System.out.println();
            kettle.displayMenu();

            System.out.println('\n');
        }
        kettle.pelog.clear();
    }

}

