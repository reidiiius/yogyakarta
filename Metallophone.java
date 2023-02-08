package yogyakarta;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Chequered Notation
 *
 * @version 1675886832
 * @author Reid Netterville III
 */
public class Metallophone {

    /**
     * Toggle betwixt tonal veils.
     */
    public boolean dyadic;

    /**
     * Buffer for pelog key tokens.
     */
    ArrayList<String> clefs = new ArrayList<String>();

    /**
     * Map of key accidentals to tonal sequence values.
     */
    TreeMap<String, String> pelog = new TreeMap<String, String>();

    /**
     * Map of pitch keys to range index values.
     */
    TreeMap<String, Integer> gears = new TreeMap<String, Integer>();

    // initialize record entries for gears
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

    /**
     * List of instrument tunings.
     */
    final String[] tunings = {
      "beadgcf",
      "bfbfb",
      "cgdae",
      "dadgad",
      "dgdgbd",
      "eadgbe",
      "fkbjdn",
      "unison",
    };

    /**
     * Populates instance.
     */
    public Metallophone() {
        populateDataBank();
    }

    /**
     * Clones a copy of tunings.
     *
     * @return list of instrument tunings
     */
    public String[] getTunings() {
        String[] stars = tunings.clone();

        return stars;
    }

    /**
     * Validates key token.
     *
     * @param sign key token
     * @return true if token matches pelog key
     */
    public boolean sentinel(String sign) {
        String expo = "^([ijkn][0-9]+?)+?.*";
        boolean flag = Pattern.matches(expo, sign);

        return flag;
    }

    /**
     * Getter for pelog values.
     *
     * @param sign key token
     * @return character sequence
     */
    public String getScale(String sign) {
        String wire = new String();

        if (sentinel(sign) && pelog.containsKey(sign)) {
            wire = pelog.get(sign);
        }

        return wire;
    }

    /**
     * Acquire epochal metric.
     *
     * @return epochal metric
     */
    public long horoLog() {
        long epoch = System.currentTimeMillis();

        return epoch;
    }

    /**
     * Configure and printout columns.
     *
     * @param stars list of key tokens
     */
    public void tabulate(String[] stars) {
        if (stars.length > 0) {
            short field = 0;
            short colum = 7;

            System.out.println();
            for (String sign : stars) {
                System.out.print(String.format("\t%s", sign));
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
            System.out.println("Collection is empty!");
        }
    }

    /**
     * Acquire pelog keys to be formatted into columns.
     */
    public void displayMenu() {
        if (pelog.size() > 0) {
            String[] stars = new String[pelog.size()];

            tabulate(pelog.keySet().toArray(stars));
        }
        else {
            System.out.println("Bank is empty!");
        }
    }

    /**
     * Translates tonal veils.
     *
     * @param yarn character sequence
     * @return character sequence
     */
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

    /**
     * Pass copy of clefs to tabulate and clear clefs.
     */
    public void apprisal() {
        if (clefs.isEmpty()) {
            System.out.println("\n\tNothing matched!\n");
        }
        else {
            String[] stars = new String[clefs.size()];

            tabulate(clefs.toArray(stars));
        }

        clefs.clear();
    }

    /**
     * Research pelog values.
     *
     * @param expo comparison token
     */
    public void regroup(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");
        String brief;

        for (String sign : pelog.keySet()) {
            brief = getScale(sign);

            if (dyadic) {
                brief = translate(brief);
            }

            if (Pattern.matches(kinda, brief)) {
                clefs.add(sign);
            }
        }

        apprisal();
    }

    /**
     * Research pelog keys.
     *
     * @param expo comparison token
     */
    public void request(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");

        for (String sign : pelog.keySet()) {
            if (Pattern.matches(kinda, sign)) {
                clefs.add(sign);
            }
        }

        apprisal();
    }

    /**
     * Display fingerboard matrix.
     *
     * @param diadem matrix headline
     * @param pegbox instrument courses
     */
    public void displayBoard(String diadem, String[] pegbox) {
        System.out.print(String.format("\t%s\n", diadem));
        for (String crow : pegbox) {
            System.out.print(String.format("\t%s\n", translate(crow)));
        }
    }

    /**
     * Tune instrument course and append octave.
     *
     * @param wire character sequence
     * @param gear range index
     * @throws StringIndexOutOfBoundsException
     * @return character sequence
     */
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

    /**
     * Instrument procedure for beadgcf tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for bfbfb tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for cgdae tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for dadgad tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for dgdgbd tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for eadgbe tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for fkbjdn tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
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

    /**
     * Instrument procedure for unison tuning.
     *
     * @param sign accidentals
     * @param wire character sequence
     * @param aeon epochal metric
     */
    public void unison(String sign, String wire, long aeon) {
        String diadem = sign + "-unison-i" + aeon;
        String[] pegbox = {
          machine(wire, gears.get("Cn")),
        };

        displayBoard(diadem, pegbox);
    }

    /**
     * Acquire stored value and process through instrument method.
     *
     * @param tuned instrument tuning
     * @param sign accidentals
     * @param aeon epochal metric
     */
    public void lontar(String tuned, String sign, long aeon) {
        String flaw, wire = getScale(sign);

        if (wire.isEmpty()) {
            flaw = String.format("\t%s ?\n", sign);

            System.out.println(flaw);
        }
        else {
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
    }

    /**
     * Pass all pelog entries to lontar for processing.
     *
     * @param tuned instrument tuning
     */
    public void every(String tuned) {
        long aeon = horoLog();

        System.out.println();
        for (String sign : pelog.keySet()) {
            lontar(tuned, sign, aeon);
        }
    }

    /**
     * Establish pelog record entries.
     */
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

