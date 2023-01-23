package yogyakarta;

import yogyakarta.Metallophone;

class Vestibule {

    public static void main(String[] args) {
        Metallophone kettle = new Metallophone();

        kettle.dyadic = true;
        kettle.populateDataBank();

        if (args.length > 0) {
            String wire;
            long aeon = System.currentTimeMillis();

            System.out.println();
            for (String sign : args) {
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
            kettle.displayMenu();
        }

        kettle.pelog.clear();
    }

}

