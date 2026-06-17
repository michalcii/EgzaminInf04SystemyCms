package com.example.egzamin_quiz;
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

    public String getOdpowiedzA() { return odpowiedzA; }
    public String getOdpowiedzB() { return odpowiedzB; }
    public String getOdpowiedzC() { return odpowiedzC; }

    @Override
    public boolean sprawdzOdpowiedz(char odpowiedz) {
        odpowiedzPoprawna = (odpowiedz == poprawnaOdpowiedz);
        return odpowiedzPoprawna;
    }
}
