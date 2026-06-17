import java.util.Random;

public class Main {

    static class Tablica {

        private int[] tab;
        private int liczbaElementow;

        public Tablica(int rozmiar) {
            this.liczbaElementow = rozmiar;
            this.tab = new int[rozmiar];
            Random rand = new Random();
            for (int i = 0; i < liczbaElementow; i++) {
                tab[i] = rand.nextInt(1000) + 1;
            }
        }

        public void wyswietlElementy() {
            System.out.println("Wszystkie elementy tablicy:");
            for (int i = 0; i < liczbaElementow; i++) {
                System.out.println(i + ": " + tab[i]);
            }
        }

        public int wyszukajWartosc(int wartosc) {
            for (int i = 0; i < liczbaElementow; i++) {
                if (tab[i] == wartosc) {
                    return i;
                }
            }
            return -1;
        }

        public int wyswietlNieparzyste() {
            System.out.println("Liczby nieparzyste:");
            int licznik = 0;
            for (int i = 0; i < liczbaElementow; i++) {
                if (tab[i] % 2 != 0) {
                    System.out.println(tab[i]);
                    licznik++;
                }
            }
            return licznik;
        }

        public double obliczSrednia() {
            double suma = 0;
            for (int i = 0; i < liczbaElementow; i++) {
                suma += tab[i];
            }
            return suma / liczbaElementow;
        }
    }

    public static void main(String[] args) {
        Tablica tablica = new Tablica(25);

        tablica.wyswietlElementy();

        int szukana = 500;
        int indeks = tablica.wyszukajWartosc(szukana);
        if (indeks != -1) {
            System.out.println("Znaleziono wartosc " + szukana + " na indeksie: " + indeks);
        }

        int ileNieparzystych = tablica.wyswietlNieparzyste();
        System.out.println("Razem nieparzystych: " + ileNieparzystych);

        double srednia = tablica.obliczSrednia();
        System.out.println("Srednia wszystkich elementow: " + srednia);
    }
}