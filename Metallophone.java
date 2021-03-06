package yogyakarta;

import java.util.Scanner;
import java.util.TreeMap;

public class Metallophone {

    private static TreeMap<String, String> db;
    private static long srl;

    public Metallophone() {
        db = new TreeMap<String, String>();
        srl = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        String ndx, qp;

        // initialize treemap and timestamp
        Metallophone svara = new Metallophone();

        // populate treemap
        populateDataBank();

        // check for user input data
        if (args.length > 0) {
            ndx = args[0];
            if (svara.db.containsKey(ndx)) {
                qp = svara.db.get(ndx);
            } else {
                qp = "";
            }
        }
        else {  // prompt user for input data
            Scanner npt = new Scanner(System.in);
            System.out.print("\nSelect: ");
            ndx = npt.nextLine();
            if (svara.db.containsKey(ndx)) {
                qp = svara.db.get(ndx);
            } else {
                qp = "";
            }
        }

        // display processed fingerboard data
        if (qp != null && qp.length() >= 60) {
            System.out.println('\n');
            eadgbe(ndx, qp, svara.srl);  // Guitar view
            System.out.println('\n');
            cgdae(ndx, qp, svara.srl);   // Cello view
            System.out.println('\n');
        }
        else {  // build and display menu
            System.out.println();
            int field = 1;
            for (String item : svara.db.keySet()) {
                System.out.print('\t' + item);
                if (field % 7 == 0) {
                    System.out.print('\n');
                } 
                field++;
            }
            System.out.println('\n');
        }
        svara.db.clear();
    }

    // headstock subroutines
    private static String Bj(String qp) {
        return qp.substring(50, 60) + qp.substring( 0, 50);
    }

    private static String Fn(String qp) {
        return qp.substring(25, 60) + qp.substring( 0, 25);
    }

    private static String Cn(String qp) {
        return qp.substring( 0, 60);
    }

    private static String Gn(String qp) {
        return qp.substring(35, 60) + qp.substring( 0, 35);
    }

    private static String Dn(String qp) {
        return qp.substring(10, 60) + qp.substring( 0, 10);
    }

    private static String An(String qp) {
        return qp.substring(45, 60) + qp.substring( 0, 45);
    }

    private static String En(String qp) {
        return qp.substring(20, 60) + qp.substring( 0, 20);
    }

    private static String Bn(String qp) {
        return qp.substring(55, 60) + qp.substring( 0, 55);
    }

    private static String Fk(String qp) {
        return qp.substring(30, 60) + qp.substring( 0, 30);
    }

    // chordophone scordatura procedures
    private static void beadgcf(String ndx, String qp, long utm) {
        String[] tuning = {Fn(qp), Cn(qp), Gn(qp), Dn(qp), An(qp), En(qp), Bn(qp)};
        System.out.println('\t' + ndx + "-beadgcf-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void bfbfb(String ndx, String qp, long utm) {
        String[] tuning = {Bn(qp), Fn(qp), Bn(qp), Fn(qp), Bn(qp)};
        System.out.println('\t' + ndx + "-bfbfb-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void cgdae(String ndx, String qp, long utm) {
        String[] tuning = {En(qp), An(qp), Dn(qp), Gn(qp), Cn(qp)};
        System.out.println('\t' + ndx + "-cgdae-sv" + utm); 
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void dadgad(String ndx, String qp, long utm) {
        String[] tuning = {Dn(qp), An(qp), Gn(qp), Dn(qp), An(qp), Dn(qp)};
        System.out.println('\t' + ndx + "-dadgad-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void dgdgbd(String ndx, String qp, long utm) {
        String[] tuning = {Dn(qp), Bn(qp), Gn(qp), Dn(qp), Gn(qp), Dn(qp)};
        System.out.println('\t' + ndx + "-dgdgbd-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void eadgbe(String ndx, String qp, long utm) {
        String[] tuning = {En(qp), Bn(qp), Gn(qp), Dn(qp), An(qp), En(qp)};
        System.out.println('\t' + ndx + "-eadgbe-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void fkbjdn(String ndx, String qp, long utm) {
        String[] tuning = {Dn(qp), Bj(qp), Fk(qp), Dn(qp), Bj(qp), Fk(qp)};
        System.out.println('\t' + ndx + "-fkbjdn-sv" + utm);
        for (String pitch : tuning) {
            System.out.println('\t' + pitch);
        }
    }

    private static void populateDataBank() {
db.put("j136y7",  "____ ____ SnPb UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
db.put("j167y2",  "HgAu ____ ____ ____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp ");
db.put("j17k2",   "____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb TiCu FeMn ");
db.put("j17",     "____ ____ SnAu ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
db.put("j17y2",   "HgAg ____ ____ ____ CuPb PbCu ____ AuSn ____ AgHg TiFe FeTi ");
db.put("j236",    "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
db.put("j23",     "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
db.put("j23k6",   "HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
db.put("j246y3",  "HgHg PuFe SnTi ____ CuNp ____ ____ AuPb NpCu ____ ____ FePu ");
db.put("j256",    "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb ");
db.put("j25",     "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb ");
db.put("j25y6",   "TiCu FeMn ____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb ");
db.put("j26",     "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
db.put("j26y34",  "HgHg PuFe SnTi UrAg ____ ____ ____ AuPb NpCu ____ ____ FePu ");
db.put("j26y3",   "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb NpCu ____ ____ FePu ");
db.put("j2",      "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ AgUr ____ FePu ");
db.put("j2k34",   "TiCu FeMn ____ ____ ____ MnFe CuTi PbAg ____ AuAu ____ AgPb ");
db.put("j2k56",   "HgHg PuFe ____ ____ CuNp PbAu ____ ____ NpCu ____ TiSn FePu ");
db.put("j2k56x4", "HgHg PuFe ____ ____ CuNp ____ ____ AuPb NpCu ____ TiSn FePu ");
db.put("j2k5",    "FeCu HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb ");
db.put("j2k6",    "HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ____ ____ TiSn FePu ");
db.put("j2k6x5",  "HgHg PuFe ____ ____ CuNp PbAu ____ ____ ____ AgUr TiSn FePu ");
db.put("j2k6y3",  "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ ____ TiSn FePu ");
db.put("j2y3",    "HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ____ AgUr ____ FePu ");
db.put("j346y5",  "NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp ____ ____ AuPb ");
db.put("j34k6",   "HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ TiCu FeMn ");
db.put("j36",     "HgAu ____ SnPb UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp ");
db.put("j3",      "HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ____ FeUr ");
db.put("j3k56x4", "HgTi ____ SnNp UrAu ____ ____ ____ AuUr NpSn ____ TiHg FeFe ");
db.put("j3k5",    "NpCu ____ TiSn FePu ____ PuFe ____ ____ CuNp PbAu ____ AuPb ");
db.put("j3k5x4",  "HgAu ____ SnPb UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp ");
db.put("j3k6",    "HgTi ____ SnNp UrAu ____ PbPb ____ AuUr ____ ____ TiHg FeFe ");
db.put("j56",     "UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ____ ____ SnPb ");
db.put("j56y7",   "UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp HgAu ____ ____ ");
db.put("j5",      "PbCu ____ AuSn ____ AgHg TiFe FeTi ____ ____ SnAu ____ CuPb ");
db.put("j5y6",    "PbCu ____ AuSn ____ AgHg TiFe FeTi HgAg ____ ____ ____ CuPb ");
db.put("j6",      "HgAu ____ SnPb ____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp ");
db.put("k125",    "____ AgUr ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
db.put("k12",     "____ AgUr ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
db.put("k12j5",   "____ AgUr ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
db.put("k135x4",  "____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp HgAu ____ SnPb ");
db.put("k157x6",  "HgHg PuFe SnTi ____ CuNp PbAu ____ ____ NpCu ____ ____ FePu ");
db.put("k15",     "____ CuUr PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
db.put("k17j5",   "TiCu FeMn HgSn ____ SnHg MnFe CuTi ____ ____ AuAu ____ ____ ");
db.put("k1",      "____ FeUr HgSn ____ SnHg UrFe ____ PbAg ____ AuAu ____ AgPb ");
db.put("k1j56y7", "____ AuUr NpSn ____ TiHg FeFe HgTi ____ SnNp UrAu ____ ____ ");
db.put("k1j5",    "____ AuUr NpSn ____ TiHg FeFe HgTi ____ ____ UrAu ____ PbPb ");
db.put("k1j6",    "____ PuFe SnTi ____ CuNp PbAu ____ AuPb NpCu ____ ____ FePu ");
db.put("k1j6y7",  "____ CuUr PbSn ____ AuHg NpFe ____ TiAg FeNp HgAu ____ ____ ");
db.put("k256",    "HgMn ____ ____ MnHg CuFe PbTi ____ ____ NpAu ____ TiPb FeCu ");
db.put("k257x1",  "NpCu ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
db.put("k25",     "NpCu ____ ____ FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
db.put("k25x17",  "____ AgUr TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ ____ ");
db.put("k25x1",   "____ ____ TiSn FePu HgHg PuFe ____ ____ CuNp PbAu ____ AuPb ");
db.put("k26",     "HgMn ____ ____ MnHg CuFe PbTi ____ AuNp ____ ____ TiPb FeCu ");
db.put("k26x5",   "HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
db.put("k2j56",   "NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp ____ ____ AuPb ");
db.put("k2j56y7", "NpCu ____ ____ FePu HgHg PuFe SnTi ____ CuNp PbAu ____ ____ ");
db.put("k2j5",    "NpCu ____ ____ FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
db.put("k2j5x1",  "____ ____ TiSn FePu HgHg PuFe SnTi ____ ____ PbAu ____ AuPb ");
db.put("k2j5y6",  "NpCu ____ ____ FePu HgHg PuFe SnTi UrAg ____ ____ ____ AuPb ");
db.put("k2j6",    "HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ FeCu ");
db.put("k2",      "NpCu ____ ____ FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
db.put("k2x1",    "____ ____ TiSn FePu HgHg PuFe ____ UrAg ____ PbAu ____ AuPb ");
db.put("k345x2",  "UrCu ____ ____ ____ AuHg NpFe AgTi ____ FeNp HgAu ____ SnPb ");
db.put("k34",     "PbCu ____ AuSn ____ ____ TiFe FeTi HgAg ____ SnAu ____ CuPb ");
db.put("k34x2",   "PbCu ____ ____ ____ AgHg TiFe FeTi HgAg ____ SnAu ____ CuPb ");
db.put("k56",     "HgAu ____ SnPb ____ CuUr PbSn ____ ____ NpFe ____ TiAg FeNp ");
db.put("k56x4",   "HgAu ____ SnPb ____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp ");
db.put("k5",      "UrCu ____ PbSn ____ AuHg NpFe ____ ____ FeNp HgAu ____ SnPb ");
db.put("k6",      "HgAg ____ SnAu ____ CuPb PbCu ____ AuSn ____ ____ TiFe FeTi ");
db.put("k6x5",    "HgAg ____ SnAu ____ CuPb PbCu ____ ____ ____ AgHg TiFe FeTi ");
db.put("n0",      "HgCu ____ SnSn ____ CuHg PbFe ____ AuAg ____ AgAu ____ FePb ");
db.put("n167",    "NpCu ____ ____ FePu ____ PuFe SnTi ____ CuNp PbAu ____ AuPb ");
db.put("n167x4",  "HgAu ____ ____ UrCu ____ PbSn ____ AuHg NpFe AgTi ____ FeNp ");
db.put("n25x6",   "TiCu FeMn HgSn ____ ____ MnFe CuTi PbAg ____ ____ ____ AgPb ");
db.put("n26y5",   "____ ____ SnHg MnFe CuTi PbAg ____ ____ ____ AgPb TiCu FeMn ");
db.put("n345",    "____ PuFe ____ ____ CuNp PbAu ____ AuPb NpCu ____ TiSn FePu ");
db.put("n345y7",  "____ CuUr ____ ____ AuHg NpFe ____ TiAg FeNp HgAu ____ SnPb ");
db.put("n45y2",   "HgTi ____ ____ UrAu ____ PbPb ____ AuUr NpSn ____ TiHg FeFe ");
db.put("n5y2",    "HgMn ____ ____ MnHg CuFe ____ ____ AuNp NpAu ____ TiPb FeCu ");
db.put("n67x2",   "____ AuUr ____ ____ TiHg FeFe HgTi ____ SnNp UrAu ____ PbPb ");
db.put("n6x2",    "FeCu HgMn ____ ____ MnHg CuFe PbTi ____ AuNp NpAu ____ ____ ");
    }
}

