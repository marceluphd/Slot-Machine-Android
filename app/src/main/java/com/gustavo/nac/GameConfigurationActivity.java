package com.gustavo.nac;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GameConfigurationActivity extends AppCompatActivity
{

    public int valorSexo;

    public EditText etNome;

    private Spinner spFichas;

    private RadioButton rbMasculino;
    private RadioButton rbFeminino;

    private TextView tvLogo;
    private TextView tvNome;
    private TextView tvFichas;
    private TextView tvCreditos;

    private Button Btjogar;

    private ImageView ivSexo;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_configuration);


        // Instânciando elementos da tela
        tvLogo = (TextView)findViewById(R.id.tvLogo);
        tvCreditos = (TextView)findViewById(R.id.tvCreditos);
        tvFichas = (TextView)findViewById(R.id.tvFichas);
        tvNome = (TextView)findViewById(R.id.tvNome);


        rbMasculino = (RadioButton)findViewById(R.id.rbMasculino);
        rbFeminino = (RadioButton)findViewById(R.id.rbFeminino);

        Btjogar = (Button)findViewById(R.id.Btjogar);

        ivSexo = (ImageView)findViewById(R.id.ivSexo);

        spFichas = (Spinner)findViewById(R.id.spFichas);

        etNome = (EditText)findViewById(R.id.etNome);

        //Toast toast = Toast.makeText(context, text, duration);




        Typeface fonte = Typeface.createFromAsset(getAssets(), "fonts/principal_font.ttf");


        // Setando fonte nos elementos da tela
        tvLogo.setTypeface(fonte);
        tvCreditos.setTypeface(fonte);
        tvFichas.setTypeface(fonte);
        tvNome.setTypeface(fonte);
        rbMasculino.setTypeface(fonte);
        rbFeminino.setTypeface(fonte);
        Btjogar.setTypeface(fonte);





        // Função que controla a imagem e Radio Button
        rbMasculino.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(rbMasculino.isChecked())
                {
                    ImageView ivMasculino = (ImageView) findViewById(R.id.ivSexo);
                    ivSexo.setBackgroundResource(R.drawable.faendal);
                    valorSexo = 1;
                    rbFeminino.setChecked(false);

                }

                if (rbFeminino.isChecked())
                {
                    rbMasculino.setChecked(false);
                }
            }

        });

        rbFeminino.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {

                if (rbFeminino.isChecked())
                {
                    ImageView rbFeminino = (ImageView) findViewById(R.id.ivSexo);
                    ivSexo.setBackgroundResource(R.drawable.serana);
                    valorSexo = 2;
                    rbMasculino.setChecked(false);

                }

                if (rbMasculino.isChecked())
                {
                    rbFeminino.setChecked(false);
                }
            }

        });

        // Função que passa para a cena principal do game junto com alguns parametros
        Btjogar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Criando uma nova intenção para chamar a proxima Activity - linha 1
                // Obtendo dados do EditText, onde o usuário insere seu nome e com isso passar como parametro para a proxima Activity através de uma key "NOME" - linha 2
                // Obtendo o valor da variável que definira o sexo, ela será acessáda através de uma key "VALOR_SEXO" - linha 3
                // Obtendo o valor da da variável valorFichas que definirá a quantidade de fichas selecionada pelo usuário
                // Iniciando a Intent it_jogar que aplicara todos os comandos - linha 5

                Intent it_jogar = new Intent(GameConfigurationActivity.this, GameActivity.class); // linha 1
                it_jogar.putExtra("NOME", etNome.getText().toString()); // linha 2
                it_jogar.putExtra("VALOR_SEXO", valorSexo); // linha 3
                it_jogar.putExtra("VALOR_FICHAS", spFichas.getSelectedItem().toString()); //linha - 4
                startActivity(it_jogar); // linha 5



            }

        });

    }
}




