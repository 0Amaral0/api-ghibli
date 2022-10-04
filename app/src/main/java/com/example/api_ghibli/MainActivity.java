package com.example.api_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView F1, F2, F3, F4, F5, F6;
    public static List<PostFilme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        F1 = (CardView) findViewById(R.id.f1);
        F2 = (CardView) findViewById(R.id.f2);
        F3 = (CardView) findViewById(R.id.f3);
        F4 = (CardView) findViewById(R.id.f4);
        F5 = (CardView) findViewById(R.id.f5);
        F6 = (CardView) findViewById(R.id.f6);

        F1.setOnClickListener((View.OnClickListener) this);
        F2.setOnClickListener((View.OnClickListener) this);
        F3.setOnClickListener((View.OnClickListener) this);
        F4.setOnClickListener((View.OnClickListener) this);
        F5.setOnClickListener((View.OnClickListener) this);
        F6.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.f1 :
                i = new Intent(this, f1.class);
                startActivity(i);
                break;
            case R.id.f2 :
                i = new Intent(this, f2.class);
                startActivity(i);
                break;
            case R.id.f3 :
                i = new Intent(this, f3.class);
                startActivity(i);
                break;
            case R.id.f4 :
                i = new Intent(this, f4.class);
                startActivity(i);
                break;
            case R.id.f5 :
                i = new Intent(this, f5.class);
                startActivity(i);
                break;
            case R.id.f6 :
                i = new Intent(this, f6.class);
                startActivity(i);
                break;

        }
    }
}