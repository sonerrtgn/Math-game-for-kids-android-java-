package com.example.tutorial_one;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class bolme_seviyeleri extends AppCompatActivity implements  View.OnClickListener {
    Button geri_git;
    ImageButton seviyeler[];
    int toplama_cikarma_leveli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolme_seviyeleri);
        sqlite_veriAl bolme = new sqlite_veriAl(this);
        bolme.ac();
        toplama_cikarma_leveli = bolme.bol_level_kac();




        geri_git = (Button) findViewById(R.id.geri_git);
        geri_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_don = new Intent(bolme_seviyeleri.this,MainActivity.class);
                startActivity(geri_don);
            }
        });
        seviyeler = new ImageButton[9];
        seviyeler[0] = (ImageButton) findViewById(R.id.seviye_1);
        seviyeler[1] = (ImageButton) findViewById(R.id.seviye_2);
        seviyeler[2] = (ImageButton) findViewById(R.id.seviye_3);
        seviyeler[3] = (ImageButton) findViewById(R.id.seviye_4);
        seviyeler[4] = (ImageButton) findViewById(R.id.seviye_5);
        seviyeler[5] = (ImageButton) findViewById(R.id.seviye_6);
        seviyeler[6] = (ImageButton) findViewById(R.id.seviye_7);
        seviyeler[7] = (ImageButton) findViewById(R.id.seviye_8);
        seviyeler[8] = (ImageButton) findViewById(R.id.seviye_9);


        for(int i = 0; i< toplama_cikarma_leveli;i++){
            seviyeler[i].setBackgroundResource(R.drawable.cozulmus_seviye);
        }

        for(ImageButton i : seviyeler){
            i.setOnClickListener(this);
        }

    }
    @Override
    public void onClick(View v){
        int count = 0;
        while(count < 9){
            if(seviyeler[count].getId() == v.getId()){
                if (count == toplama_cikarma_leveli) {
                    Intent oyun_ekrani = new Intent(bolme_seviyeleri.this,bolme_oyunu.class);
                    oyun_ekrani.putExtra("seviye",(count+1));
                    startActivity(oyun_ekrani);
                    break;
                } else if (count > toplama_cikarma_leveli) {
                    AlertDialog alertDialog = new AlertDialog.Builder(bolme_seviyeleri.this).create();
                    alertDialog.setTitle("Uyarı");
                    alertDialog.setMessage("Bu seviyeye halen gelmediniz");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tamam",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(bolme_seviyeleri.this).create();
                    alertDialog.setTitle("Uyarı");
                    alertDialog.setMessage("Bu seviyeye Zaten çözülmüş.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tamam",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
            count++;
        }
    }
}