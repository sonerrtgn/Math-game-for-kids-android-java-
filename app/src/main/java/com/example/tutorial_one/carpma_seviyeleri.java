package com.example.tutorial_one;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class carpma_seviyeleri extends AppCompatActivity implements View.OnClickListener{
    Button geri_git;
    ImageButton seviyeler[] = new ImageButton[9];
    TextView tv;
    int carpma_leveli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpma_seviyeleri);
        final sqlite_veriAl level_veri = new sqlite_veriAl(this);
        level_veri.ac();
        carpma_leveli  = level_veri.carp_level_kac();
        level_veri.kapat();
        geri_git = (Button) findViewById(R.id.geri_git);
        geri_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_don = new Intent(carpma_seviyeleri.this,MainActivity.class);
                startActivity(geri_don);
            }
        });

        seviyeler[0] = (ImageButton) findViewById(R.id.seviye_1);
        seviyeler[1] = (ImageButton) findViewById(R.id.seviye_2);
        seviyeler[2] = (ImageButton) findViewById(R.id.seviye_3);
        seviyeler[3] = (ImageButton) findViewById(R.id.seviye_4);
        seviyeler[4] = (ImageButton) findViewById(R.id.seviye_5);
        seviyeler[5] = (ImageButton) findViewById(R.id.seviye_6);
        seviyeler[6] = (ImageButton) findViewById(R.id.seviye_7);
        seviyeler[7] = (ImageButton) findViewById(R.id.seviye_8);
        seviyeler[8] = (ImageButton) findViewById(R.id.seviye_9);
        for(int i = 0; i< carpma_leveli;i++){
            seviyeler[i].setBackgroundResource(R.drawable.cozulmus_seviye);
        }

        for(ImageButton i : seviyeler){
            i.setOnClickListener(this);
        }

    }
    public void onClick(View v){
        int count = 0;
        while(count < 9){
            if(seviyeler[count].getId() == v.getId()){
                if (count == carpma_leveli) {
                    Intent oyun_ekrani = new Intent(carpma_seviyeleri.this,carpma_oyunu.class);
                    oyun_ekrani.putExtra("seviye",(count+1));
                    startActivity(oyun_ekrani);
                    break;
                } else if (count > carpma_leveli) {
                    AlertDialog alertDialog = new AlertDialog.Builder(carpma_seviyeleri.this).create();
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
                    AlertDialog alertDialog = new AlertDialog.Builder(carpma_seviyeleri.this).create();
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