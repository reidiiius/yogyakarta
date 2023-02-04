package yogyakarta;

import java.util.TreeMap;

public class Metallophone {

    public boolean dyadic;
    public TreeMap<String, String> pelog;

    TreeMap<String, Integer> gears = new TreeMap<String, Integer>();

    {
      gears.put("Aj", 40);
      gears.put("Ak", 50);
      gears.put("An", 45);
      gears.put("Bj", 50);
      gears.put("Bn", 55);
      gears.put("Ck",  5);
      gears.put("Cn",  0);
      gears.put("Dj",  5);
      gears.put("Dk", 15);
      gears.put("Dn", 10);
      gears.put("Ej", 15);
      gears.put("En", 20);
      gears.put("Fk", 30);
      gears.put("Fn", 25);
      gears.put("Gj", 30);
      gears.put("Gk", 40);
      gears.put("Gn", 35);
    }

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

    public Metallophone() {
        pelog = new TreeMap<String, String>();
        populateDataBank();
    }

    // acquire epochal metric
    public long horoLog() {
        return System.currentTimeMillis();
    }

    // build and display menu
    public void displayMenu() {
        if (pelog != null && pelog.size() > 0) {
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
        else {
            System.out.println("Bank is empty!");
        }
    }

    // substrata transitions
    public String translate(String yarn) {
        if (dyadic) {
            String[] metals = {
              "Ti","Mn","Fe","Cu","Ag","Sn","Au","Hg","Pb","Ur","Np","Pu","____"
            };
            String[] charms = {
               "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "__"
            };

            if (metals.length == charms.length) {
                byte niter = 0;
                while (niter < metals.length) {
                    yarn = yarn.replace(metals[niter], charms[niter]);
                    niter++;
                }
            }
        }

        return yarn;
    }

    // display fingerboard
    public void displayBoard(String diadem, String[] pegbox) {
        System.out.print(String.format("\t%s\n", diadem));
        for (String crow : pegbox) {
            System.out.print(String.format("\t%s\n", translate(crow)));
        }
    }

    // tension assemblage
    public String machine(String wire, int gear) {
        String head, tail, xtra = new String();
        int span = wire.length();
        byte numb = 4;

        if (gear > span) gear = span;

        head = wire.substring(gear, span);
        tail = wire.substring( 0, gear);

        if (head.length() >= numb) {
            try {
                xtra = head.substring( 0, numb);
            }
            catch (Exception anomaly) {
                System.err.println(anomaly);
            }
        }

        return String.format("%s%s%s", head, tail, xtra);
    }

    // instrument procedures
    public void beadgcf(String sign, String wire, long aeon) {
        String diadem = sign + "-beadgcf-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Fn")),
          machine(wire, gears.get("Cn")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("An")),
          machine(wire, gears.get("En")),
          machine(wire, gears.get("Bn")),
        };

        displayBoard(diadem, pegbox);
    }

    public void bfbfb(String sign, String wire, long aeon) {
        String diadem = sign + "-bfbfb-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Bn")),
          machine(wire, gears.get("Fn")),
          machine(wire, gears.get("Bn")),
          machine(wire, gears.get("Fn")),
          machine(wire, gears.get("Bn")),
        };

        displayBoard(diadem, pegbox);
    }

    public void cgdae(String sign, String wire, long aeon) {
        String diadem = sign + "-cgdae-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("En")),
          machine(wire, gears.get("An")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Cn")),
        };

        displayBoard(diadem, pegbox);
    }

    public void dadgad(String sign, String wire, long aeon) {
        String diadem = sign + "-dadgad-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("An")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("An")),
          machine(wire, gears.get("Dn")),
        };

        displayBoard(diadem, pegbox);
    }

    public void dgdgbd(String sign, String wire, long aeon) {
        String diadem = sign + "-dgdgbd-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("Bn")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Dn")),
        };

        displayBoard(diadem, pegbox);
    }

    public void eadgbe(String sign, String wire, long aeon) {
        String diadem = sign + "-eadgbe-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("En")),
          machine(wire, gears.get("Bn")),
          machine(wire, gears.get("Gn")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("An")),
          machine(wire, gears.get("En")),
        };

        displayBoard(diadem, pegbox);
    }

    public void fkbjdn(String sign, String wire, long aeon) {
        String diadem = sign + "-fkbjdn-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("Bj")),
          machine(wire, gears.get("Fk")),
          machine(wire, gears.get("Dn")),
          machine(wire, gears.get("Bj")),
          machine(wire, gears.get("Fk")),
        };

        displayBoard(diadem, pegbox);
    }

    public void unison(String sign, String wire, long aeon) {
        String diadem = sign + "-unison-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Cn")),
        };

        displayBoard(diadem, pegbox);
    }

    // acquire stored value and process through instrument
    public void lontar(String tuned, String sign, long aeon) {
        String flaw, wire;
        wire = pelog.get(sign);
        if (pelog.containsKey(sign)) {
            wire = pelog.get(sign);
            if (wire != null && wire.length() >= 60) {
                switch (tuned) {
                  case "beadgcf":
                      beadgcf(sign, wire, aeon);
                      break;
                  case "bfbfb":
                      bfbfb(sign, wire, aeon);
                      break;
                  case "cgdae":
                      cgdae(sign, wire, aeon);
                      break;
                  case "dadgad":
                      dadgad(sign, wire, aeon);
                      break;
                  case "dgdgbd":
                      dgdgbd(sign, wire, aeon);
                      break;
                  case "eadgbe":
                      eadgbe(sign, wire, aeon);
                      break;
                  case "fkbjdn":
                      fkbjdn(sign, wire, aeon);
                      break;
                  case "unison":
                      unison(sign, wire, aeon);
                      break;
                  default:
                      beadgcf(sign, wire, aeon);
                      break;
                }
                System.out.println();
            }
        } else {
            flaw = String.format("\t%s ?\n", sign);
            System.out.println(flaw);
        }
    }

    public void populateDataBank() {
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

