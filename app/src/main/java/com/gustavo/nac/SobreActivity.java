package com.gustavo.nac;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SobreActivity extends AppCompatActivity
{

    // Variáveis que obtem os elementos da tela
    private TextView tvCreditos;
    private TextView tvVersao;
    private TextView tvConteudo;
    private TextView tvTituloApp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);


        // Instanciando fonte
        Typeface fonte = Typeface.createFromAsset(getAssets(),"fonts/principal_font.ttf");


       // Instanciando os elementos da tela
        tvCreditos = (TextView) findViewById(R.id.tvCreditos);
        tvVersao = (TextView) findViewById(R.id.tvVersao);
        tvConteudo = (TextView) findViewById(R.id.tvConteudo);
        tvTituloApp = (TextView) findViewById(R.id.tvTituloApp);


        // Aplicando fonte aos elementos da tela
        tvCreditos.setTypeface(fonte);
        tvVersao.setTypeface(fonte);
        tvConteudo.setTypeface(fonte);
        tvTituloApp.setTypeface(fonte);
    }

}
