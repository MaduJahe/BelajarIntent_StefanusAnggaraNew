package com.example.belajarintent_stefanusanggaranew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String KONTAK = "REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("My title");
    }

    public void CardContact1 (View view) {
        Intent MengirimPesan = new Intent(MainActivity.this,activity_mengirim_pesan.class);
        MengirimPesan.putExtra(KONTAK, "Mengirim pesan ke Nilou");

        startActivity(MengirimPesan);
    }

    public void CardContact2 (View view){
        Intent MengirimPesan = new Intent(MainActivity.this, activity_mengirim_pesan.class);
        MengirimPesan.putExtra(KONTAK, "Ayaka");
        startActivity(MengirimPesan);
    }

    public void CardContact3 (View view) {
        Intent MengirimPesan = new Intent(MainActivity.this,activity_mengirim_pesan.class);
        MengirimPesan.putExtra(KONTAK, "Ganyu");
        startActivity(MengirimPesan);
    }
}