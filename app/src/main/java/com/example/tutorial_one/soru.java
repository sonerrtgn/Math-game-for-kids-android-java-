package com.example.tutorial_one;

import java.util.Random;

public class soru {
    private int tur;
    private int aralik;
    public soru(int tur,int seviye){
        // tur = 0 toplama/cikarma, tur = 1 carpma, tur = 2 bolme.
        this.tur = tur;
        aralik = seviye*10;
    }
    public int[] soru_uret(){

        int[] soru_bilgileri = new int[7]; //0.indis = islem operatoru(0 toplama 1 cikarma 2 bolme 3 carpma) , 1.indis 1.sayi,2.indis 2.sayi 3.indis cevap, 4,5,6.indiler ise yanlis cevaplar.
        if(tur == 0){
            Random r = new Random();
            int isaret = r.nextInt(2);
            if(isaret == 0){
                //toplama
                soru_bilgileri[0] = 0;
                soru_bilgileri[1] = r.nextInt(aralik)+1;
                soru_bilgileri[2] = r.nextInt(aralik)+1;
                soru_bilgileri[3] = soru_bilgileri[1]+soru_bilgileri[2];
                soru_bilgileri[4] = soru_bilgileri[3] + (r.nextInt(3) +1);
                soru_bilgileri[5] = soru_bilgileri[3] - (r.nextInt(3) +4);
                soru_bilgileri[6] = soru_bilgileri[3] - (r.nextInt(3) +7);

            }else{
                //cikarma
                soru_bilgileri[0] = 1;
                soru_bilgileri[1] = r.nextInt(aralik)+1;
                soru_bilgileri[2] = r.nextInt((int)(aralik/2))+1;
                soru_bilgileri[3] = soru_bilgileri[1]-soru_bilgileri[2];
                soru_bilgileri[4] = soru_bilgileri[3] + (r.nextInt(3) +1);
                soru_bilgileri[5] = soru_bilgileri[3] - (r.nextInt(3) +4);
                soru_bilgileri[6] = soru_bilgileri[3] - (r.nextInt(3) +7);
            }
        }else if(tur == 1){
            //carpma
            Random r = new Random();
            int aralik = (int)this.aralik/3;
            soru_bilgileri[0] = 2;
            soru_bilgileri[1] = r.nextInt(aralik)+1;
            soru_bilgileri[2] = r.nextInt((int)(aralik/2))+1;
            soru_bilgileri[3] = soru_bilgileri[1]*soru_bilgileri[2];
            soru_bilgileri[4] = soru_bilgileri[3] + (r.nextInt(3) +1);
            soru_bilgileri[5] = soru_bilgileri[3] - (r.nextInt(3) +4);
            soru_bilgileri[6] = soru_bilgileri[3] + (r.nextInt(3) +7);
        }else{
            //bolme
            Random r = new Random();
            int aralik = (int)(this.aralik/3);

            soru_bilgileri[0] = 3;
            int sayi1 = r.nextInt(aralik)+1;
            int sayi2 = r.nextInt(aralik)+1;
            soru_bilgileri[1] = sayi1*sayi2;
            soru_bilgileri[2] =  sayi2;
            soru_bilgileri[3] =  sayi1;
            soru_bilgileri[4] = sayi1 - (r.nextInt(3)+1);
            soru_bilgileri[5] = sayi1 + (r.nextInt(3)+4);
            soru_bilgileri[6] = sayi1 - (r.nextInt(3)+7);

        }

        return soru_bilgileri;
    }
}
