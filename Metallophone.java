package yogyakarta;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Chequered Notation
 *
 * @version 1676408257
 * @author Reid Netterville III
 */
public class Metallophone {

    /**
     * Toggle betwixt tonal veils.
     */
    public boolean dyadic;

    /**
     * Buffer for scales key tokens.
     */
    ArrayList<String> clefs = new ArrayList<String>();

    /**
     * Map of key accidentals to tonal sequence values.
     */
    TreeMap<String, String> scales = new TreeMap<String, String>();

    /**
     * Map of pitch keys to range index values.
     */
    TreeMap<String, Integer> gears = new TreeMap<String, Integer>();

    // initialize entries for gears
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
     * Map of tuning keys to pitches values.
     */
    TreeMap<String, String[]> stones = new TreeMap<String, String[]>();

    // initialize entries for stones
    {
      stones.put("beadgcf", new String[] {"Fn","Cn","Gn","Dn","An","En","Bn"});
      stones.put("bfbfb",   new String[] {"Bn","Fn","Bn","Fn","Bn"});
      stones.put("cgdae",   new String[] {"En","An","Dn","Gn","Cn"});
      stones.put("dadgad",  new String[] {"Dn","An","Gn","Dn","An","Dn"});
      stones.put("dgdgbd",  new String[] {"Dn","Bn","Gn","Dn","Gn","Dn"});
      stones.put("eadgbe",  new String[] {"En","Bn","Gn","Dn","An","En"});
      stones.put("fkbjdn",  new String[] {"Dn","Bj","Fk","Dn","Bj","Fk"});
      stones.put("unison",  new String[] {"Cn"});
    }

    /**
     * List of instrument tunings.
     */
    String[] tunings = stones.keySet().toArray(new String[stones.size()]);

    /**
     * List of tonal veils.
     */
    String[] metals = {
      "Ti","Mn","Fe","Cu","Ag","Sn","Au","Hg","Pb","Ur","Np","Pu","____"
    };
    String[] charms = {
       "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "__"
    };
    String[] arcane = {
       "2", "3", "4", "5", "6", "7", "8", "9", "N", "P", "Q", "R", "__"
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
        String[] cords = tunings.clone();

        return cords;
    }

    /**
     * Validates tunings key token.
     *
     * @param strum instrument tuning
     */
    public String stockade(String strum) {
        String tuned = "beadgcf";
        short count = 0;

        while (count < tunings.length) {
            if (strum.equals(tunings[count])) {
                tuned = strum;

                break;
            }
            count++;
        }

        return tuned;
    }

    /**
     * Validates scales key token.
     *
     * @param sign key token
     * @return true if token matches scales key
     */
    public boolean sentinel(String sign) {
        String expo = "^([ijkn][0-9]+?)+?.*";
        boolean flag = Pattern.matches(expo, sign);

        return flag;
    }

    /**
     * Getter for scales values.
     *
     * @param sign key token
     * @return character sequence
     */
    public String getScale(String sign) {
        String wire = new String();

        if (sentinel(sign) && scales.containsKey(sign)) {
            wire = scales.get(sign);
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
     * @param signs list of key tokens
     */
    public void tabulate(String[] signs) {
        if (signs.length > 0) {
            short field = 0;
            short colum = 7;

            System.out.println();
            for (String sign : signs) {
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
     * Acquire scales keys to be formatted into columns.
     */
    public void dashboard() {
        if (scales.size() > 0) {
            String[] cords = getTunings();
            String[] signs = new String[scales.size()];

            System.out.print("\n\t");
            for (String item : cords) {
                System.out.print(item + " ");
            }
            System.out.println();

            tabulate(scales.keySet().toArray(signs));
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
            if (metals.length == charms.length) {
                char niter = 0;

                while (niter < metals.length) {
                    yarn = yarn.replace(metals[niter], charms[niter]);

                    niter++;
                }
            }
        }

        return yarn;
    }

    /**
     * Pass copy of clefs to tabulate then clear clefs.
     */
    public void apprisal() {
        if (clefs.isEmpty()) {
            System.out.println("\n\tNothing matched!\n");
        }
        else {
            String[] signs = new String[clefs.size()];

            tabulate(clefs.toArray(signs));
        }

        clefs.clear();
    }

    /**
     * Research scales values.
     *
     * @param expo comparison token
     */
    public void regroup(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");
        String brief;

        for (String sign : scales.keySet()) {
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
     * Research scales keys.
     *
     * @param expo comparison token
     */
    public void request(String expo) {
        String kinda = String.format("%s%s%s", "^.*", expo, ".*$");

        for (String sign : scales.keySet()) {
            if (Pattern.matches(kinda, sign)) {
                clefs.add(sign);
            }
        }

        apprisal();
    }

    /**
     * Printout fingerboard matrix.
     *
     * @param diadem matrix headline
     * @param pegbox instrument courses
     */
    public void fingerboard(String diadem, String[] pegbox) {
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
     * Acquire stored value then process through machine.
     *
     * @param tuned instrument tuning
     * @param sign accidentals
     * @param aeon epochal metric
     */
    public void compose(String tuned, String sign, long aeon) {
        String flaw, wire = getScale(sign);

        if (wire.isEmpty()) {
            flaw = String.format("\t%s ?", sign);

            System.out.println(flaw);
        }
        else {
            String cord = stockade(tuned);
            String diadem = String.format("%s-%s-i%s", sign, cord, aeon);

            String[] pitches = stones.get(cord);
            String[] pegbox = new String[pitches.length];

            for (char niter = 0; niter < pitches.length; niter++) {
                pegbox[niter] = machine(wire, gears.get(pitches[niter]));
            }

            fingerboard(diadem, pegbox);
        }

        System.out.println();
    }

    /**
     * Pass all scales entries to compose for processing.
     *
     * @param tuned instrument tuning
     */
    public void every(String tuned) {
        long aeon = horoLog();

        System.out.println();
        for (String sign : scales.keySet()) {
            compose(tuned, sign, aeon);
        }
    }

    /**
     * Initialize entries for scales.
     */
    public void populateDataBank() {
      scales.put("j136l7"  ,"____ ____ SnPb UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
      scales.put("j167l2"  ,"HgAu ____ ____ ____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp ");
      scales.put("j17l2"   ,"HgAg ____ ____ ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
      scales.put("j17"     ,"____ ____ SnAu ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
      scales.put("j236"    ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
      scales.put("j23"     ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
      scales.put("j23k6"   ,"HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
      scales.put("j246l3"  ,"HgHg PuFe SnTi ____ CuNp ____ ____ AuPb NpCu ____ ____ FePu ");
      scales.put("j256"    ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb ");
      scales.put("j25"     ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb ");
      scales.put("j25l6"   ,"TiCu FeMn ____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb ");
      scales.put("j26"     ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
      scales.put("j26l34"  ,"HgHg PuFe SnTi UrAg ____ ____ ____ AuPb NpCu ____ ____ FePu ");
      scales.put("j26l3"   ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
      scales.put("j2"      ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ AgUr ____ FePu ");
      scales.put("j2k34"   ,"TiCu FeMn ____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb ");
      scales.put("j2k56"   ,"HgHg PuFe ____ ____ CuNp PbAu ____ ____ NpCu ____ TiSn FePu ");
      scales.put("j2k56m4" ,"HgHg PuFe ____ ____ CuNp ____ ____ AuPb NpCu ____ TiSn FePu ");
      scales.put("j2k5"    ,"FeCu HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb ");
      scales.put("j2k6"    ,"HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ ____ TiSn FePu ");
      scales.put("j2k6l3"  ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
      scales.put("j2k6m5"  ,"HgHg PuFe ____ ____ CuNp PbAu ____ ____ ____ AgUr TiSn FePu ");
      scales.put("j2l3"    ,"HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
      scales.put("j346l5"  ,"NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp ____ ____ AuPb ");
      scales.put("j34k6"   ,"HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ TiCu FeMn ");
      scales.put("j36"     ,"HgAu ____ SnPb UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp ");
      scales.put("j3"      ,"HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ____ FeUr ");
      scales.put("j3k56m4" ,"HgTi ____ SnNp UrAu ____ ____ ____ AuUr NpSn ____ TiHg FeFe ");
      scales.put("j3k5m4"  ,"HgAu ____ SnPb UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp ");
      scales.put("j3k5"    ,"NpCu ____ TiSn FePu ____ PuFe ____ ____ CuNp PbAu ____ AuPb ");
      scales.put("j3k6"    ,"HgTi ____ SnNp UrAu ____ PbPb ____ AuUr ____ ____ TiHg FeFe ");
      scales.put("j56l7"   ,"UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp HgAu ____ ____ ");
      scales.put("j56"     ,"UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ____ ____ SnPb ");
      scales.put("j5l6"    ,"PbCu ____ AuSn ____ AgHg TiFe FeTi HgAg ____ ____ ____ CuPb ");
      scales.put("j5"      ,"PbCu ____ AuSn ____ AgHg TiFe FeTi ____ ____ SnAu ____ CuPb ");
      scales.put("j6"      ,"HgAu ____ SnPb ____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp ");
      scales.put("k125"    ,"____ AgUr ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      scales.put("k12"     ,"____ AgUr ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      scales.put("k12j5"   ,"____ AgUr ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      scales.put("k135m4"  ,"____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp HgAu ____ SnPb ");
      scales.put("k157m6"  ,"HgHg PuFe SnTi ____ CuNp PbAu ____ ____ NpCu ____ ____ FePu ");
      scales.put("k15"     ,"____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
      scales.put("k17j5"   ,"TiCu FeMn HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ ");
      scales.put("k1"      ,"____ FeUr HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ");
      scales.put("k1j56l7" ,"____ AuUr NpSn ____ TiHg FeFe HgTi ____ SnNp UrAu ____ ____ ");
      scales.put("k1j5"    ,"____ AuUr NpSn ____ TiHg FeFe HgTi ____ ____ UrAu ____ PbPb ");
      scales.put("k1j6l7"  ,"____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp HgAu ____ ____ ");
      scales.put("k1j6"    ,"____ PuFe SnTi ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
      scales.put("k256"    ,"HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb FeCu ");
      scales.put("k257m1"  ,"NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
      scales.put("k25m17"  ,"____ AgUr TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
      scales.put("k25m1"   ,"____ ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      scales.put("k25"     ,"NpCu ____ ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
      scales.put("k26"     ,"HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb FeCu ");
      scales.put("k26m5"   ,"HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
      scales.put("k2j17"   ,"____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb TiCu FeMn ");
      scales.put("k2j56l7" ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp PbAu ____ ____ ");
      scales.put("k2j56"   ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp ____ ____ AuPb ");
      scales.put("k2j5l6"  ,"NpCu ____ ____ FePu HgHg PuFe SnTi UrAg ____ ____ ____ AuPb ");
      scales.put("k2j5m1"  ,"____ ____ TiSn FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      scales.put("k2j5"    ,"NpCu ____ ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
      scales.put("k2j6"    ,"HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ FeCu ");
      scales.put("k2m1"    ,"____ ____ TiSn FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      scales.put("k2"      ,"NpCu ____ ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
      scales.put("k345m2"  ,"UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp HgAu ____ SnPb ");
      scales.put("k34m2"   ,"PbCu ____ ____ ____ AgHg TiFe FeTi HgAg ____ SnAu ____ CuPb ");
      scales.put("k34"     ,"PbCu ____ AuSn ____ ____ TiFe FeTi HgAg ____ SnAu ____ CuPb ");
      scales.put("k56"     ,"HgAu ____ SnPb ____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp ");
      scales.put("k56m4"   ,"HgAu ____ SnPb ____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp ");
      scales.put("k5"      ,"UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
      scales.put("k6"      ,"HgAg ____ SnAu ____ CuPb PbCu ____ AuSn ____ ____ TiFe FeTi ");
      scales.put("k6m5"    ,"HgAg ____ SnAu ____ CuPb PbCu ____ ____ ____ AgHg TiFe FeTi ");
      scales.put("n0"      ,"HgCu ____ SnSn ____ CuHg PbFe ____ AuAg ____ AgAu ____ FePb ");
      scales.put("n167m4"  ,"HgAu ____ ____ UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
      scales.put("n167"    ,"NpCu ____ ____ FePu ____ PuFe SnTi ____ CuNp PbAu ____ AuPb ");
      scales.put("n25m6"   ,"TiCu FeMn HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb ");
      scales.put("n26l5"   ,"____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
      scales.put("n345l7"  ,"____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp HgAu ____ SnPb ");
      scales.put("n345"    ,"____ PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ TiSn FePu ");
      scales.put("n45l2"   ,"HgTi ____ ____ UrAu ____ PbPb ____ AuUr NpSn ____ TiHg FeFe ");
      scales.put("n5l2"    ,"HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb FeCu ");
      scales.put("n67m2"   ,"____ AuUr ____ ____ TiHg FeFe HgTi ____ SnNp UrAu ____ PbPb ");
      scales.put("n6m2"    ,"FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ ");
    }

}

