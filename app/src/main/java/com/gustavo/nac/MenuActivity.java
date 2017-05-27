package com.gustavo.nac;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity
{

    // Criando as variáveis dos botões
    private Button btSobre;
    private Button btJogar;

    private TextView tvCreditos;
    private TextView tvVersao;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializando os objetos da tela
        btSobre = (Button) findViewById(R.id.Btsobre);
        btJogar = (Button) findViewById(R.id.Btjogar);

        tvCreditos = (TextView) findViewById(R.id.tvCreditos);


        // Inicializando a fonte
        Typeface fonte = Typeface.createFromAsset(getAssets(),"fonts/principal_font.ttf");


        // Aplicando fonte
        btSobre.setTypeface(fonte);
        btJogar.setTypeface(fonte);
        tvCreditos.setTypeface(fonte);



        // Aplicando função OnClick
        btSobre.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent it_sobre = new Intent(MenuActivity.this, SobreActivity.class);

                startActivity(it_sobre);
            }
        });


        btJogar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it_jogar = new Intent(MenuActivity.this, GameConfigurationActivity.class);

                startActivity(it_jogar);
            }

        });

    }

}
