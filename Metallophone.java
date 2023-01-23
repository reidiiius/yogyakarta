package yogyakarta;

import java.util.TreeMap;

public class Metallophone {

    public static boolean dyadic;
    public static TreeMap<String, String> pelog;

    public Metallophone() {
        pelog = new TreeMap<String, String>();
    }

    // build and display menu
    public static void displayMenu() {
        short field = 0;
        short colum = 7;

        System.out.println();
        for (String item : pelog.keySet()) {
            System.out.print(String.format("\t%s", item));
            if (++field % colum == 0) {
                System.out.println();
            }
        }
        if (field % colum == 0) {
            System.out.println();
        }
        else {
            System.out.println('\n');
        }
    }

    private static String translate(String yarn) {
        if (dyadic) {
            yarn = yarn.replace("Ti", "o");
            yarn = yarn.replace("Mn", "p");
            yarn = yarn.replace("Fe", "q");
            yarn = yarn.replace("Cu", "r");
            yarn = yarn.replace("Ag", "s");
            yarn = yarn.replace("Sn", "t");
            yarn = yarn.replace("Au", "u");
            yarn = yarn.replace("Hg", "v");
            yarn = yarn.replace("Pb", "w");
            yarn = yarn.replace("Ur", "x");
            yarn = yarn.replace("Np", "y");
            yarn = yarn.replace("Pu", "z");
            yarn = yarn.replace("____", "__");
        }

        return yarn;
    }

    // display fingerboard
    private static void displayBoard(String diadem, String[] tuning) {
        System.out.print(String.format("\t%s\n", diadem));
        for (String crow : tuning) {
            System.out.print(String.format("\t%s\n", translate(crow)));
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
    public static void beadgcf(String sign, String wire, long aeon) {
        String diadem = sign + "-beadgcf-i" + aeon;
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

    public static void bfbfb(String sign, String wire, long aeon) {
        String diadem = sign + "-bfbfb-i" + aeon;
        String[] tuning = {
          sBn(wire), sFn(wire), sBn(wire), sFn(wire), sBn(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void cgdae(String sign, String wire, long aeon) {
        String diadem = sign + "-cgdae-i" + aeon;
        String[] tuning = {
          sEn(wire), sAn(wire), sDn(wire), sGn(wire), sCn(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void dadgad(String sign, String wire, long aeon) {
        String diadem = sign + "-dadgad-i" + aeon;
        String[] tuning = {
          sDn(wire), sAn(wire), sGn(wire), sDn(wire), sAn(wire), sDn(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void dgdgbd(String sign, String wire, long aeon) {
        String diadem = sign + "-dgdgbd-i" + aeon;
        String[] tuning = {
          sDn(wire), sBn(wire), sGn(wire), sDn(wire), sGn(wire), sDn(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void eadgbe(String sign, String wire, long aeon) {
        String diadem = sign + "-eadgbe-i" + aeon;
        String[] tuning = {
          sEn(wire), sBn(wire), sGn(wire), sDn(wire), sAn(wire), sEn(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void fkbjdn(String sign, String wire, long aeon) {
        String diadem = sign + "-fkbjdn-i" + aeon;
        String[] tuning = {
          sDn(wire), sBj(wire), sFk(wire), sDn(wire), sBj(wire), sFk(wire)
        };

        displayBoard(diadem, tuning);
    }

    public static void populateDataBank() {
      pelog.put("j136l7"  ,"____ ____ SnPb UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
      pelog.put("j167l2"  ,"HgAu ____ ____ ____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp ");
      pelog.put("j17l2"   ,"HgAg ____ ____ ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
      pelog.put("j17"     ,"____ ____ SnAu ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
      pelog.put("j236"    ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("j23"     ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
      pelog.put("j23k6"   ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
      pelog.put("j246l3"  ,"HgHg PuFe SnTi ____ CuNp ____ ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("j256"    ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb ");
      pelog.put("j25"     ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb ");
      pelog.put("j25l6"   ,"TiCu FeMn ____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb ");
      pelog.put("j26"     ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("j26l34"  ,"HgHg PuFe SnTi UrAg ____ ____ ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("j26l3"   ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("j2"      ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ AgUr ____ FePu ");
      pelog.put("j2k34"   ,"TiCu FeMn ____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb ");
      pelog.put("j2k56"   ,"HgHg PuFe ____ ____ CuNp PbAu ____ ____ NpCu ____ TiSn FePu ");
      pelog.put("j2k56m4" ,"HgHg PuFe ____ ____ CuNp ____ ____ AuPb NpCu ____ TiSn FePu ");
      pelog.put("j2k5"    ,"FeCu HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb ");
      pelog.put("j2k6"    ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ ____ TiSn FePu ");
      pelog.put("j2k6l3"  ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
      pelog.put("j2k6m5"  ,"HgHg PuFe ____ ____ CuNp PbAu ____ ____ ____ AgUr TiSn FePu ");
      pelog.put("j2l3"    ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
      pelog.put("j346l5"  ,"NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp ____ ____ AuPb ");
      pelog.put("j34k6"   ,"HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ TiCu FeMn ");
      pelog.put("j36"     ,"HgAu ____ SnPb UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp ");
      pelog.put("j3"      ,"HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ____ FeUr ");
      pelog.put("j3k56m4" ,"HgTi ____ SnNp UrAu ____ ____ ____ AuUr NpSn ____ TiHg FeFe ");
      pelog.put("j3k5m4"  ,"HgAu ____ SnPb UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp ");
      pelog.put("j3k5"    ,"NpCu ____ TiSn FePu ____ PuFe ____ ____ CuNp PbAu ____ AuPb ");
      pelog.put("j3k6"    ,"HgTi ____ SnNp UrAu ____ PbPb ____ AuUr ____ ____ TiHg FeFe ");
      pelog.put("j56l7"   ,"UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp HgAu ____ ____ ");
      pelog.put("j56"     ,"UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ____ ____ SnPb ");
      pelog.put("j5l6"    ,"PbCu ____ AuSn ____ AgHg TiFe FeTi HgAg ____ ____ ____ CuPb ");
      pelog.put("j5"      ,"PbCu ____ AuSn ____ AgHg TiFe FeTi ____ ____ SnAu ____ CuPb ");
      pelog.put("j6"      ,"HgAu ____ SnPb ____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp ");
      pelog.put("k125"    ,"____ AgUr ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      pelog.put("k12"     ,"____ AgUr ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      pelog.put("k12j5"   ,"____ AgUr ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      pelog.put("k135m4"  ,"____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp HgAu ____ SnPb ");
      pelog.put("k157m6"  ,"HgHg PuFe SnTi ____ CuNp PbAu ____ ____ NpCu ____ ____ FePu ");
      pelog.put("k15"     ,"____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
      pelog.put("k17j5"   ,"TiCu FeMn HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ ");
      pelog.put("k1"      ,"____ FeUr HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ");
      pelog.put("k1j56l7" ,"____ AuUr NpSn ____ TiHg FeFe HgTi ____ SnNp UrAu ____ ____ ");
      pelog.put("k1j5"    ,"____ AuUr NpSn ____ TiHg FeFe HgTi ____ ____ UrAu ____ PbPb ");
      pelog.put("k1j6l7"  ,"____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp HgAu ____ ____ ");
      pelog.put("k1j6"    ,"____ PuFe SnTi ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
      pelog.put("k256"    ,"HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb FeCu ");
      pelog.put("k257m1"  ,"NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
      pelog.put("k25m17"  ,"____ AgUr TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
      pelog.put("k25m1"   ,"____ ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      pelog.put("k25"     ,"NpCu ____ ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      pelog.put("k26"     ,"HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb FeCu ");
      pelog.put("k26m5"   ,"HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
      pelog.put("k2j17"   ,"____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb TiCu FeMn ");
      pelog.put("k2j56l7" ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp PbAu ____ ____ ");
      pelog.put("k2j56"   ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp ____ ____ AuPb ");
      pelog.put("k2j5l6"  ,"NpCu ____ ____ FePu HgHg PuFe SnTi UrAg ____ ____ ____ AuPb ");
      pelog.put("k2j5m1"  ,"____ ____ TiSn FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      pelog.put("k2j5"    ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      pelog.put("k2j6"    ,"HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ FeCu ");
      pelog.put("k2m1"    ,"____ ____ TiSn FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      pelog.put("k2"      ,"NpCu ____ ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      pelog.put("k345m2"  ,"UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp HgAu ____ SnPb ");
      pelog.put("k34m2"   ,"PbCu ____ ____ ____ AgHg TiFe FeTi HgAg ____ SnAu ____ CuPb ");
      pelog.put("k34"     ,"PbCu ____ AuSn ____ ____ TiFe FeTi HgAg ____ SnAu ____ CuPb ");
      pelog.put("k56"     ,"HgAu ____ SnPb ____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp ");
      pelog.put("k56m4"   ,"HgAu ____ SnPb ____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp ");
      pelog.put("k5"      ,"UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
      pelog.put("k6"      ,"HgAg ____ SnAu ____ CuPb PbCu ____ AuSn ____ ____ TiFe FeTi ");
      pelog.put("k6m5"    ,"HgAg ____ SnAu ____ CuPb PbCu ____ ____ ____ AgHg TiFe FeTi ");
      pelog.put("n0"      ,"HgCu ____ SnSn ____ CuHg PbFe ____ AuAg ____ AgAu ____ FePb ");
      pelog.put("n167m4"  ,"HgAu ____ ____ UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
      pelog.put("n167"    ,"NpCu ____ ____ FePu ____ PuFe SnTi ____ CuNp PbAu ____ AuPb ");
      pelog.put("n25m6"   ,"TiCu FeMn HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb ");
      pelog.put("n26l5"   ,"____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
      pelog.put("n345l7"  ,"____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp HgAu ____ SnPb ");
      pelog.put("n345"    ,"____ PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ TiSn FePu ");
      pelog.put("n45l2"   ,"HgTi ____ ____ UrAu ____ PbPb ____ AuUr NpSn ____ TiHg FeFe ");
      pelog.put("n5l2"    ,"HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb FeCu ");
      pelog.put("n67m2"   ,"____ AuUr ____ ____ TiHg FeFe HgTi ____ SnNp UrAu ____ PbPb ");
      pelog.put("n6m2"    ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ ");
    }

}

