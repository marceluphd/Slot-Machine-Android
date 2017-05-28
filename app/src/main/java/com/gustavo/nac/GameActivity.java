package com.gustavo.nac;


import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.view.View;
import android.widget.Toast;




public class GameActivity extends AppCompatActivity {

    private TextView tvLogo_Nome;
    private Chronometer chTimer;
    private TextView tvFichas_Game;
    private TextView btRodar;

    private Button btnRodar;

    private ImageView ivLogo_Sexo;


    private ImageView ivSlot1, ivSlot2, ivSlot3;
    private Roda slot1, slot2, slot3;
    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        // Instânciando elementos da tela
        tvLogo_Nome = (TextView) findViewById(R.id.tvLogo_Nome);
        chTimer = (Chronometer) findViewById(R.id.chTimer);
        tvFichas_Game = (TextView) findViewById(R.id.tvFichas_Game);
        btRodar = (TextView) findViewById(R.id.btRodar);


        ivSlot1 = (ImageView) findViewById(R.id.ivImagem_1);
        ivSlot2 = (ImageView) findViewById(R.id.ivImagem_2);
        ivSlot3 = (ImageView) findViewById(R.id.ivImagem_3);


        btnRodar = (Button) findViewById(R.id.btRodar);

        ivLogo_Sexo = (ImageView) findViewById(R.id.ivLogo_Sexo);


        // Instânciando fonte
        Typeface fonte = Typeface.createFromAsset(getAssets(), "fonts/principal_font.ttf");


        // Criando cronometro e inicializando cronomero junto com a GameActivity
        chTimer.setBase(SystemClock.elapsedRealtime());
        chTimer.start();

        // Aplicando fonte
        tvLogo_Nome.setTypeface(fonte);
        chTimer.setTypeface(fonte);
        tvFichas_Game.setTypeface(fonte);
        btRodar.setTypeface(fonte);



        // Buscando paramentros da outra activity
        Bundle bundle = getIntent().getExtras();

        // Verificando e aplicando o nome
        if (bundle.containsKey("NOME")) {
            String nome = bundle.getString("NOME"); // Criando uma String nome que obtem os parametros da activity anterior através da key "NOME"
            tvLogo_Nome.setText(nome); // Setando o valor da variavel nome, no elemento desta activity
        }


        // Verificando sexo
        if (bundle.containsKey("VALOR_SEXO")) {

            int vlSexo = bundle.getInt("VALOR_SEXO"); // Geting do valor que definira o sexo selecionado nesta activity, através da key "VALOR_SEXO"

            if (vlSexo == 1)  // Se vlSexo for 1: O background da ImageView será Masculino
            {
                ivLogo_Sexo.setBackgroundResource(R.drawable.faendal_avatar);

            } else if (vlSexo == 2) // Se vlSexo for 2: O background da ImageView será Feminino
            {
                ivLogo_Sexo.setBackgroundResource(R.drawable.serana_avatar);
            }
        }


        // Verificando quantidade de Fichas
        if (bundle.containsKey("VALOR_FICHAS"))
        {
            // Geting do valor que definira a quantidade de fichas selecionada na activity anterior
            String vlFichas = bundle.getString("VALOR_FICHAS");

            tvFichas_Game.setText(vlFichas);
        }

        // Funcao que iniciara a Slot Machine
        btnRodar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivSlot1.setBackground(null);
                ivSlot2.setBackground(null);
                ivSlot3.setBackground(null);
                jogar(btnRodar);

            }
        });


        // Esta estrutura de codigo abaixo depende de outra classe java(Roda.java) para ter funcionamento

    }



    public void jogar(View v)
    {
        rodarSlot1();
        rodarSlot2();
        rodarSlot3();
        btnRodar.setEnabled(false);
        new Handler().postDelayed( new Runnable()
        {
            @Override
            public void run()
            {
                slot1 .pararDeRodar();
                slot2 .pararDeRodar();
                slot3 .pararDeRodar();
                exibeResultado();
                btnRodar .setEnabled( true );
            }
        }, 3000 );
    }
    private void exibeResultado()
    {
        if ( slot1.indiceAtual == slot2.indiceAtual && slot2.indiceAtual == slot3.indiceAtual)
        {
            Toast. makeText ( this, "Você ganhou", Toast.LENGTH_SHORT).show();
        }

        else if ( slot1.indiceAtual == slot2.indiceAtual || slot2 . indiceAtual == slot3.indiceAtual
                || slot1.indiceAtual == slot3.indiceAtual)
        {
            Toast.makeText ( this, "Pequena Premiação", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast. makeText ( this, "Você perdeu", Toast.LENGTH_SHORT ).show();
        }
    }
    private void rodarSlot1()
    {
        slot1 = new Roda( new Roda.RodaListener()
        {
            @Override
            public void novaImagem( final int resourceID)
            {
                runOnUiThread( new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ivSlot1 .setImageResource( resourceID );
                    }
                });
            }
        }, 200 , randomLong ( 0 , 200 ));
        slot1 .start();
    }
    private void rodarSlot2()
    {
        slot2 = new Roda( new Roda.RodaListener()
        {
            @Override
            public void novaImagem( final int resourceID)
            {
                runOnUiThread( new Runnable()
                {
                    @Override
                    public void run() {
                        ivSlot2 .setImageResource( resourceID );
                    }
                });
            }
        }, 200 , randomLong ( 150 , 400 ));
        slot2 .start();
    }
    private void rodarSlot3()
    {
        slot3 = new Roda( new Roda.RodaListener()
        {
            @Override
            public void novaImagem( final int resourceID)
            {
                runOnUiThread( new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ivSlot3 .setImageResource( resourceID );
                    }
                });
            }
        }, 200 , randomLong ( 300 , 600 ));
        slot3.start();
    }
}



