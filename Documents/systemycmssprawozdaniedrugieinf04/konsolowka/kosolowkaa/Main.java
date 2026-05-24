import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Inicjalizacja obiektu PytanieZamkniete ===");
        System.out.print("Podaj treść pytania: ");
        String tresc = scanner.nextLine();

        System.out.print("Podaj nazwę pliku graficznego: ");
        String plik = scanner.nextLine();

        System.out.print("Podaj treść odpowiedzi A: ");
        String odpA = scanner.nextLine();

        System.out.print("Podaj treść odpowiedzi B: ");
        String odpB = scanner.nextLine();

        System.out.print("Podaj treść odpowiedzi C: ");
        String odpC = scanner.nextLine();

        System.out.print("Podaj poprawną odpowiedź (A/B/C): ");
        char poprawna = scanner.nextLine().toUpperCase().charAt(0);

        PytanieZamkniete pytanie = new PytanieZamkniete(tresc, plik, odpA, odpB, odpC, poprawna);

        pytanie.wyswietlPytanie();

        System.out.print("Twoja odpowiedź (A/B/C): ");
        char udzielona = scanner.nextLine().toUpperCase().charAt(0);

        boolean wynik = pytanie.sprawdzOdpowiedz(udzielona);

        if (wynik) {
            System.out.println("Odpowiedź prawidłowa");
        } else {
            System.out.println("Odpowiedź nieprawidłowa");
        }

        scanner.close();
    }
}
