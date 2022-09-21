package com.example.campominado;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.Set;

public class tela2 extends AppCompatActivity {
    Button botoes[] = new Button[64];
    Random rnd = new Random();
    int localBomb = rnd.nextInt(64);
    int click,contador = 1;
    SoundPool efeito;
    MediaPlayer musica;

    int vetor[] = {R.id.b101 ,R.id.b102,R.id.b103,R.id.b104,R.id.b105,R.id.b106,R.id.b107,R.id.b108,
            R.id.b201,R.id.b202,R.id.b203,R.id.b204,R.id.b205,R.id.b206,R.id.b207,R.id.b208,
            R.id.b301,R.id.b302,R.id.b303,R.id.b304,R.id.b305,R.id.b306,R.id.b307,R.id.b308,
            R.id.b401,R.id.b402,R.id.b403,R.id.b404,R.id.b405,R.id.b406,R.id.b407,R.id.b408,
            R.id.b501,R.id.b502,R.id.b503,R.id.b504,R.id.b505,R.id.b506,R.id.b507,R.id.b508,
            R.id.b601,R.id.b602,R.id.b603,R.id.b604,R.id.b605,R.id.b606,R.id.b607,R.id.b608,
            R.id.b701,R.id.b702,R.id.b703,R.id.b704,R.id.b705,R.id.b706,R.id.b707,R.id.b708,
            R.id.b801,R.id.b802,R.id.b803,R.id.b804,R.id.b805,R.id.b806,R.id.b807,R.id.b808};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        efeito = new SoundPool(4, AudioManager.STREAM_MUSIC, 8);
        click = efeito.load(tela2.this,R.raw.efeito,3);

        musica = MediaPlayer.create(tela2.this,R.raw.champion);


        for (int i = 0; i < 64;i++)
            botoes[i] = findViewById(vetor[i]);

        for(int i = 0 ; i < 64;i++){
            ehbomba(i);
        }

    }

    public void ehbomba(int x){
        botoes[x].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (localBomb == x) {
                    musica.start();
                    Intent intent = new Intent(tela2.this, tela3.class);
                    intent.putExtra("tentativas",contador);
                    startActivity(intent);
                    finish();
                } else {
                    efeito.play(click,1,1,1,0,1);
                    botoes[x].setBackgroundColor(Color.WHITE);
                    botoes[x].setClickable(false);
                    contador++;
                }
            }
        });
    }

}