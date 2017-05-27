package com.gustavo.nac;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class Splash_ScreenActivity extends AppCompatActivity
{

    private final int SPLASH_DISPLAY_LENGTH = 3500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);


        // Instância a fonte
        Typeface fonte = Typeface.createFromAsset(getAssets(),"fonts/principal_font.ttf");



        // chamando função da animação
        carregar();

    }

    private void carregar()
    {

        // Criando uma variável do tipo Animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        // Instânciando o elemento da tela que obtera a animação
        ImageView v = (ImageView) findViewById(R.id.splash_image);

        if (v != null)
        {
            v.clearAnimation();
            v.startAnimation(anim);
        }

        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                Intent intent = new Intent(Splash_ScreenActivity.this, MenuActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                Splash_ScreenActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

}


