package com.example.tutorial_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button toplama_cikarma_button;
    private Button carp_button;
    private Button bol_button;
    private int toplama_cikarma_leveli;
    private int bolme_leveli;
    private int carpma_leveli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toplama_cikarma_button = (Button) findViewById(R.id.top_cik);
        carp_button = (Button) findViewById(R.id.carp);
        bol_button = (Button) findViewById(R.id.bol);


        toplama_cikarma_button.setOnClickListener(this);
        carp_button.setOnClickListener(this);
        bol_button.setOnClickListener(this);

    }
    @Override
    public  void onClick(View v){
        if(v.getId() == toplama_cikarma_button.getId()){
            //Toplama cikarma buttonu..
            Intent toplama_ekrani = new Intent(MainActivity.this,Toplama_seviyeleri.class);
            startActivity(toplama_ekrani);
        }else if(v.getId() == carp_button.getId()){
            //carpma buttonu
            Intent bolme_seviyeleri = new Intent(MainActivity.this,carpma_seviyeleri.class);
            startActivity(bolme_seviyeleri);
        }else{
            //bollme buttonuna tıklanirsa
            Intent carpma_seviyeleri = new Intent(MainActivity.this,bolme_seviyeleri.class);
            startActivity(carpma_seviyeleri);
        }
    }
}