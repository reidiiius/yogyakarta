package yogyakarta;

import java.util.Scanner;
import java.util.TreeMap;

public class Metallophone {

    private static TreeMap<String, String> pelog;

    public Metallophone() {
        pelog = new TreeMap<String, String>();
    }

    public static void main(String[] args) {
        String sign, wire;
        long aeon = System.currentTimeMillis();

        // initialize treemap and timestamp
        Metallophone kettle = new Metallophone();

        // populate treemap
        populateDataBank();

        // check for user input data
        if (args.length > 0) {
            sign = args[0];
            if (kettle.pelog.containsKey(sign)) {
                wire = kettle.pelog.get(sign);
            } else {
                wire = "";
            }
        }
        else {  // prompt user for input data
            Scanner depot = new Scanner(System.in);
            System.out.print("\nSelect: ");
            sign = depot.nextLine();
            if (kettle.pelog.containsKey(sign)) {
                wire = kettle.pelog.get(sign);
            } else {
                wire = "";
            }
        }

        // arrange matrices
        if (wire != null && wire.length() >= 60) {
            System.out.println('\n');
            eadgbe(sign, wire, aeon);  // Guitar view

            System.out.println('\n');
            cgdae(sign, wire, aeon);   // Cello view

            System.out.println('\n');
        }
        else {
            System.out.println();
            displayMenu();

            System.out.println('\n');
        }
        kettle.pelog.clear();
    }

    // build and display menu
    private static void displayMenu() {
        short field = 1;
        for (String item : pelog.keySet()) {
            System.out.print('\t' + item);
            if (field % 7 == 0) {
                System.out.print('\n');
            }
            field++;
        }
    }

    // display fingerboard
    private static void displayBoard(String diadem, String[] tuning) {
        System.out.println('\t' + diadem);
        for (String crow : tuning) {
            System.out.println('\t' + crow);
        }
    }

    // headstock subroutines
    private static String sBj(String wire) {
        return wire.substring(50, 60) + wire.substring( 0, 50);
    }

    private static String sFn(String wire) {
        return wire.substring(25, 60) + wire.substring( 0, 25);
    }

    private static String sCn(String wire) {
        return wire.substring( 0, 60);
    }

    private static String sGn(String wire) {
        return wire.substring(35, 60) + wire.substring( 0, 35);
    }

    private static String sDn(String wire) {
        return wire.substring(10, 60) + wire.substring( 0, 10);
    }

    private static String sAn(String wire) {
        return wire.substring(45, 60) + wire.substring( 0, 45);
    }

    private static String sEn(String wire) {
        return wire.substring(20, 60) + wire.substring( 0, 20);
    }

    private static String sBn(String wire) {
        return wire.substring(55, 60) + wire.substring( 0, 55);
    }

    private static String sFk(String wire) {
        return wire.substring(30, 60) + wire.substring( 0, 30);
    }

    // composition procedures
    private static void beadgcf(String sign, String wire, long aeon) {
        String diadem = sign + "-beadgcf-sv" + aeon;
        String[] tuning = {
          sFn(wire),
          sCn(wire),
          sGn(wire),
          sDn(wire),
          sAn(wire),
          sEn(wire),
          sBn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void bfbfb(String sign, String wire, long aeon) {
        String diadem = sign + "-bfbfb-sv" + aeon;
        String[] tuning = {
          sBn(wire), sFn(wire), sBn(wire), sFn(wire), sBn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void cgdae(String sign, String wire, long aeon) {
        String diadem = sign + "-cgdae-sv" + aeon;
        String[] tuning = {
          sEn(wire), sAn(wire), sDn(wire), sGn(wire), sCn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void dadgad(String sign, String wire, long aeon) {
        String diadem = sign + "-dadgad-sv" + aeon;
        String[] tuning = {
          sDn(wire), sAn(wire), sGn(wire), sDn(wire), sAn(wire), sDn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void dgdgbd(String sign, String wire, long aeon) {
        String diadem = sign + "-dgdgbd-sv" + aeon;
        String[] tuning = {
          sDn(wire), sBn(wire), sGn(wire), sDn(wire), sGn(wire), sDn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void eadgbe(String sign, String wire, long aeon) {
        String diadem = sign + "-eadgbe-sv" + aeon;
        String[] tuning = {
          sEn(wire), sBn(wire), sGn(wire), sDn(wire), sAn(wire), sEn(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void fkbjdn(String sign, String wire, long aeon) {
        String diadem = sign + "-fkbjdn-sv" + aeon;
        String[] tuning = {
          sDn(wire), sBj(wire), sFk(wire), sDn(wire), sBj(wire), sFk(wire)
        };

        displayBoard(diadem, tuning);
    }

    private static void populateDataBank() {
pelog.put("j136y7",  "____ ____ SnPb UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
pelog.put("j167y2",  "HgAu ____ ____ ____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp ");
pelog.put("j17",     "____ ____ SnAu ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
pelog.put("j17y2",   "HgAg ____ ____ ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
pelog.put("j236",    "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
pelog.put("j23",     "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
pelog.put("j23k6",   "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
pelog.put("j246y3",  "HgHg PuFe SnTi ____ CuNp ____ ____ AuPb NpCu ____ ____ FePu ");
pelog.put("j256",    "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb ");
pelog.put("j25",     "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb ");
pelog.put("j25y6",   "TiCu FeMn ____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb ");
pelog.put("j26",     "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
pelog.put("j26y34",  "HgHg PuFe SnTi UrAg ____ ____ ____ AuPb NpCu ____ ____ FePu ");
pelog.put("j26y3",   "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
pelog.put("j2",      "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ AgUr ____ FePu ");
pelog.put("j2k34",   "TiCu FeMn ____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb ");
pelog.put("j2k56",   "HgHg PuFe ____ ____ CuNp PbAu ____ ____ NpCu ____ TiSn FePu ");
pelog.put("j2k56x4", "HgHg PuFe ____ ____ CuNp ____ ____ AuPb NpCu ____ TiSn FePu ");
pelog.put("j2k5",    "FeCu HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb ");
pelog.put("j2k6",    "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ ____ TiSn FePu ");
pelog.put("j2k6x5",  "HgHg PuFe ____ ____ CuNp PbAu ____ ____ ____ AgUr TiSn FePu ");
pelog.put("j2k6y3",  "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
pelog.put("j2y3",    "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
pelog.put("j346y5",  "NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp ____ ____ AuPb ");
pelog.put("j34k6",   "HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ TiCu FeMn ");
pelog.put("j36",     "HgAu ____ SnPb UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp ");
pelog.put("j3",      "HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ____ FeUr ");
pelog.put("j3k56x4", "HgTi ____ SnNp UrAu ____ ____ ____ AuUr NpSn ____ TiHg FeFe ");
pelog.put("j3k5",    "NpCu ____ TiSn FePu ____ PuFe ____ ____ CuNp PbAu ____ AuPb ");
pelog.put("j3k5x4",  "HgAu ____ SnPb UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp ");
pelog.put("j3k6",    "HgTi ____ SnNp UrAu ____ PbPb ____ AuUr ____ ____ TiHg FeFe ");
pelog.put("j56",     "UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ____ ____ SnPb ");
pelog.put("j56y7",   "UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp HgAu ____ ____ ");
pelog.put("j5",      "PbCu ____ AuSn ____ AgHg TiFe FeTi ____ ____ SnAu ____ CuPb ");
pelog.put("j5y6",    "PbCu ____ AuSn ____ AgHg TiFe FeTi HgAg ____ ____ ____ CuPb ");
pelog.put("j6",      "HgAu ____ SnPb ____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp ");
pelog.put("k125",    "____ AgUr ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
pelog.put("k12",     "____ AgUr ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
pelog.put("k12j5",   "____ AgUr ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
pelog.put("k135x4",  "____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp HgAu ____ SnPb ");
pelog.put("k157x6",  "HgHg PuFe SnTi ____ CuNp PbAu ____ ____ NpCu ____ ____ FePu ");
pelog.put("k15",     "____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
pelog.put("k17j5",   "TiCu FeMn HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ ");
pelog.put("k1",      "____ FeUr HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ");
pelog.put("k1j56y7", "____ AuUr NpSn ____ TiHg FeFe HgTi ____ SnNp UrAu ____ ____ ");
pelog.put("k1j5",    "____ AuUr NpSn ____ TiHg FeFe HgTi ____ ____ UrAu ____ PbPb ");
pelog.put("k1j6",    "____ PuFe SnTi ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
pelog.put("k1j6y7",  "____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp HgAu ____ ____ ");
pelog.put("k256",    "HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb FeCu ");
pelog.put("k257x1",  "NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
pelog.put("k25",     "NpCu ____ ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
pelog.put("k25x17",  "____ AgUr TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
pelog.put("k25x1",   "____ ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
pelog.put("k26",     "HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb FeCu ");
pelog.put("k26x5",   "HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
pelog.put("k2j17",   "____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb TiCu FeMn ");
pelog.put("k2j56",   "NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp ____ ____ AuPb ");
pelog.put("k2j56y7", "NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp PbAu ____ ____ ");
pelog.put("k2j5",    "NpCu ____ ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
pelog.put("k2j5x1",  "____ ____ TiSn FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
pelog.put("k2j5y6",  "NpCu ____ ____ FePu HgHg PuFe SnTi UrAg ____ ____ ____ AuPb ");
pelog.put("k2j6",    "HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ FeCu ");
pelog.put("k2",      "NpCu ____ ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
pelog.put("k2x1",    "____ ____ TiSn FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
pelog.put("k345x2",  "UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp HgAu ____ SnPb ");
pelog.put("k34",     "PbCu ____ AuSn ____ ____ TiFe FeTi HgAg ____ SnAu ____ CuPb ");
pelog.put("k34x2",   "PbCu ____ ____ ____ AgHg TiFe FeTi HgAg ____ SnAu ____ CuPb ");
pelog.put("k56",     "HgAu ____ SnPb ____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp ");
pelog.put("k56x4",   "HgAu ____ SnPb ____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp ");
pelog.put("k5",      "UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
pelog.put("k6",      "HgAg ____ SnAu ____ CuPb PbCu ____ AuSn ____ ____ TiFe FeTi ");
pelog.put("k6x5",    "HgAg ____ SnAu ____ CuPb PbCu ____ ____ ____ AgHg TiFe FeTi ");
pelog.put("n0",      "HgCu ____ SnSn ____ CuHg PbFe ____ AuAg ____ AgAu ____ FePb ");
pelog.put("n167",    "NpCu ____ ____ FePu ____ PuFe SnTi ____ CuNp PbAu ____ AuPb ");
pelog.put("n167x4",  "HgAu ____ ____ UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
pelog.put("n25x6",   "TiCu FeMn HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb ");
pelog.put("n26y5",   "____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
pelog.put("n345",    "____ PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ TiSn FePu ");
pelog.put("n345y7",  "____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp HgAu ____ SnPb ");
pelog.put("n45y2",   "HgTi ____ ____ UrAu ____ PbPb ____ AuUr NpSn ____ TiHg FeFe ");
pelog.put("n5y2",    "HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb FeCu ");
pelog.put("n67x2",   "____ AuUr ____ ____ TiHg FeFe HgTi ____ SnNp UrAu ____ PbPb ");
pelog.put("n6x2",    "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ ");
    }
}

