public class PytanieZamkniete extends Pytanie {
    private String odpowiedzA;
    private String odpowiedzB;
    private String odpowiedzC;
    private char poprawnaOdpowiedz;

    public PytanieZamkniete(String tresc, String nazwaPliku,
                            String odpowiedzA, String odpowiedzB, String odpowiedzC,
                            char poprawnaOdpowiedz) {
        super(tresc, nazwaPliku);
        this.odpowiedzA = odpowiedzA;
        this.odpowiedzB = odpowiedzB;
        this.odpowiedzC = odpowiedzC;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    @Override
    public boolean sprawdzOdpowiedz(char odpowiedz) {
        if (odpowiedz == poprawnaOdpowiedz) {
            this.odpowiedzPoprawna = true;
        } else {
            this.odpowiedzPoprawna = false;
        }
        return this.odpowiedzPoprawna;
    }

    public void wyswietlPytanie() {
        System.out.println("Pytanie: " + tresc);
        System.out.println("A: " + odpowiedzA);
        System.out.println("B: " + odpowiedzB);
        System.out.println("C: " + odpowiedzC);
    }
}
