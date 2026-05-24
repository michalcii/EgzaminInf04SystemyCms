package com.example.egzamin_quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPytanie;
    private TextView textViewTresc;
    private RadioGroup radioGroup;
    private RadioButton radioA;
    private RadioButton radioB;
    private RadioButton radioC;
    private Button buttonDalej;

    private List<PytanieZamkniete> listaPytan;
    private int aktualnyIndeks = 0;
    private int punkty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPytanie = findViewById(R.id.imageViewPytanie);
        textViewTresc    = findViewById(R.id.textViewTresc);
        radioGroup       = findViewById(R.id.radioGroup);
        radioA           = findViewById(R.id.radioA);
        radioB           = findViewById(R.id.radioB);
        radioC           = findViewById(R.id.radioC);
        buttonDalej      = findViewById(R.id.buttonDalej);

        listaPytan = new ArrayList<>();
        listaPytan.add(new PytanieZamkniete("Które to schronisko?", "zad1", "Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Rycerzowej.", 'B'));
        listaPytan.add(new PytanieZamkniete("Zwierzę na zdjęciu to", "zad2", "owczarek.", "wilk.", "kozica.", 'A'));
        listaPytan.add(new PytanieZamkniete("W oddali są widoczne", "zad3", "Himalaje.", "Alpy.", "Tatry.", 'C'));

        wyswietlPytanie(aktualnyIndeks);

        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzOdpowiedzUzytkownika();
                aktualnyIndeks = (aktualnyIndeks + 1) % listaPytan.size();
                wyswietlPytanie(aktualnyIndeks);
                radioGroup.clearCheck();
            }
        });
    }

    private void wyswietlPytanie(int indeks) {
        PytanieZamkniete pytanie = listaPytan.get(indeks);
        textViewTresc.setText(pytanie.getTresc());
        radioA.setText(pytanie.getOdpowiedzA());
        radioB.setText(pytanie.getOdpowiedzB());
        radioC.setText(pytanie.getOdpowiedzC());
        int resId = getResources().getIdentifier(pytanie.getNazwaPliku(), "drawable", getPackageName());
        if (resId != 0) imageViewPytanie.setImageResource(resId);
    }

    private void sprawdzOdpowiedzUzytkownika() {
        int zaznaczoneId = radioGroup.getCheckedRadioButtonId();
        if (zaznaczoneId == -1) return;
        char wybor;
        if (zaznaczoneId == R.id.radioA)      wybor = 'A';
        else if (zaznaczoneId == R.id.radioB) wybor = 'B';
        else                                   wybor = 'C';
        if (listaPytan.get(aktualnyIndeks).sprawdzOdpowiedz(wybor)) punkty++;
    }
}