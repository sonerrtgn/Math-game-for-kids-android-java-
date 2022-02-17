package com.example.tutorial_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.OutputStream;
import java.util.Random;

public class toplama_oyunu extends AppCompatActivity implements View.OnClickListener{
    Button[] siklar;
    soru sorulacak;
    TextView soru_text;
    TextView puan_text;
    int cevap;
    int puan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplama_oyunu);
        puan = 0;
        puan_text = (TextView) findViewById(R.id.puan_drum);
        Intent veriler = getIntent();
        int seviye_bilgi = veriler.getIntExtra("seviye",0);
        sorulacak = new soru(0,seviye_bilgi);
        soru_text = (TextView) findViewById(R.id.soru);
        siklar = new Button[4];
        siklar[0] = (Button) findViewById(R.id.cevap_1);
        siklar[1] = (Button) findViewById(R.id.cevap_2);
        siklar[2] = (Button) findViewById(R.id.cevap_3);
        siklar[3] = (Button) findViewById(R.id.cevap_4);
        soruyu_yerlestir();

        for(Button i:siklar){
            i.setOnClickListener(this);
        }

    }
    public void soruyu_yerlestir(){
        int[] soru_bilgileri = sorulacak.soru_uret();
        String isaret;
        if(soru_bilgileri[0] == 0){
            isaret = " + ";
        }else{
            isaret = " - ";
        }
        soru_text.setText(soru_bilgileri[1] + isaret + soru_bilgileri[2]);
        Random r = new Random();
        int cevap_hangi_sikta = r.nextInt(4);
        siklar[cevap_hangi_sikta].setText(String.valueOf(soru_bilgileri[3]));
        cevap = soru_bilgileri[3];
        int count = 4;
        for(int i = 0; i< 4;i++){
            if(i != cevap_hangi_sikta){
                siklar[i].setText(String.valueOf(soru_bilgileri[count]));
                count++;
            }
        }
    }

    @Override
    public void onClick(View v){
        for(Button i:siklar){
            if (v.getId() == i.getId()) {
                if(cevap == Integer.valueOf((String) i.getText())){
                    puan++;
                }else{
                    puan--;
                }
                if(puan == 10){
                    sqlite_veriAl guncelleme = new sqlite_veriAl(this);
                    guncelleme.ac();

                    int simdiki_toplama_leveli = guncelleme.top_cik_level_kac();
                    guncelleme.top_cik_level_degistir(simdiki_toplama_leveli+1);
                    Intent geri_don = new Intent(toplama_oyunu.this,Toplama_seviyeleri.class);
                    guncelleme.kapat();
                    startActivity(geri_don);
                }
                puan_text.setText("PUAN : "+puan);
                soruyu_yerlestir();
            }
        }
    }
}