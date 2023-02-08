# Yogyakarta
Chequered Notation

---

### Download

    git clone https://github.com/reidiiius/yogyakarta.git

---

### Usage
Command-line

    javac yogyakarta/*.java

:

    java yogyakarta.Vestibule

:

    java yogyakarta.Vestibule n0

:

    java yogyakarta.Vestibule k6 j5

:

    jar cfm kelapa.jar yogyakarta/Manifest.txt yogyakarta/*.class

:

    java -jar kelapa.jar query k1

:

    java -jar kelapa.jar k12 k15

:

    java -jar kelapa.jar group tw

:

    java -jar kelapa.jar eadgbe j6 j36

:

    java -jar kelapa.jar cgdae gamut | sensible-pager

REPL

    jshell --class-path kelapa.jar

:

    var o = new yogyakarta.Metallophone();

:

    o.displayMenu();

:

    var sign = "n0"; var wire = o.getScale(sign); var aeon = o.horoLog();

:

    for (var s : o.getTunings()) System.out.println("\n\t" + s);

:

    o.eadgbe(sign, wire, aeon);

:

    o.dyadic = true;

:

    o.cgdae(sign, wire, aeon);

:

    o.request("k1");

:

    o.lontar("beadgcf", "k15", aeon);

:

    o.regroup("tw");

:

    o.lontar("beadgcf", "k56", aeon);

:

    /exit

Cleanup

    rm kelapa.jar yogyakarta/*.class

---

### Distribution
MIT License

