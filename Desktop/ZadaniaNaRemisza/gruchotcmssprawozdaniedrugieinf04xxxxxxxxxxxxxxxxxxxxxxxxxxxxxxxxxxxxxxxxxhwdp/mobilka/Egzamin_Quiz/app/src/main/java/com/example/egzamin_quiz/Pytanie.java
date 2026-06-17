package com.example.egzamin_quiz;
public abstract class Pytanie {
    protected String tresc;
    protected String nazwaPliku;
    protected boolean odpowiedzPoprawna;

    public Pytanie(String tresc, String nazwaPliku) {
        this.tresc = tresc;
        this.nazwaPliku = nazwaPliku;
        this.odpowiedzPoprawna = false;
    }

    public String getTresc() {
        return tresc;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public abstract boolean sprawdzOdpowiedz(char odpowiedz);
}
