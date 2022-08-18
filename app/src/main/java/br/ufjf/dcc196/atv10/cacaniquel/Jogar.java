package br.ufjf.dcc196.atv10.cacaniquel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Jogar extends AppCompatActivity {
    int moeda;
    int pontos;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button apostar;
    Button btnNovoJogo;
    Button btnSair;
    private TextView txtMoeda;
    private TextView txtPontos;
    TextView textViewMaxPontos;
    TextView txtNomeJogador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        bt_1=findViewById(R.id.bt_1);
        bt_2=findViewById(R.id.bt_2);
        bt_3=findViewById(R.id.bt_3);
        apostar = findViewById(R.id.apostar);
        btnNovoJogo=findViewById(R.id.btnNovoJogo);
        btnSair=findViewById(R.id.btnSair);
        txtMoeda=findViewById(R.id.txtMoeda);
        txtPontos=findViewById(R.id.txtPontos);
        textViewMaxPontos = findViewById(R.id.textViewMaxPontos);
        txtNomeJogador = findViewById(R.id.txtNomeJogador);




        btnNovoJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                moeda=20;
                pontos=0;
                bt_1.setEnabled(true);
                bt_2.setEnabled(true);
                bt_3.setEnabled(true);
                apostar.setEnabled(true);
                txtMoeda.setText("" + moeda);
                txtPontos.setText(""+pontos);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        apostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i1,i2,i3;
                Random r1 = new Random();
                Random r2 = new Random();
                Random r3 = new Random();
                i1 = r1.nextInt(10);
                i2 = r2.nextInt(10);
                i3 = r3.nextInt(10);
                bt_1.setText(String.valueOf(i1));
                bt_2.setText(String.valueOf(i2));
                bt_3.setText(String.valueOf(i3));
                checarJogo(i1,i2,i3);
            }
        });

    }

    public void checarJogo(int a, int b, int c){

        if(((a==7) &&(b==7)&&(c==7)) ){

            moeda = moeda + 100;
            pontos=pontos+100;
            AlertDialog.Builder alertaVenceu = new AlertDialog.Builder(this);
            alertaVenceu.setTitle("VITÓRIA");
            alertaVenceu.setMessage("Parabéns, você é o vencedor!");
            alertaVenceu.setIcon(android.R.drawable.star_on);
            alertaVenceu.setPositiveButton("OK",null);
            alertaVenceu.create();
            alertaVenceu.show();
            txtMoeda.setText(String.valueOf(moeda));
            txtPontos.setText(String.valueOf(pontos));
            bt_1.setTextColor(Integer.parseInt("@color/translucent_red"));
            bt_2.setTextColor(Integer.parseInt("@color/translucent_red"));
            bt_3.setTextColor(Integer.parseInt("@color/translucent_red"));

            bt_1.setEnabled(false);
            bt_2.setEnabled(false);
            bt_3.setEnabled(false);
        }
        else{
            if(((a==7) && (b==7)) || (a==7)&&(c==7) || ((b==7))){
                moeda=moeda+2;
                pontos=pontos+2;
                txtMoeda.setText(String.valueOf(moeda));
                txtPontos.setText(String.valueOf(pontos));
            }
            else{
                if((a==7) || (b==7) || (c==7)){

                    moeda=moeda+1;
                    pontos=pontos+1;
                    txtMoeda.setText(String.valueOf(moeda));
                    txtPontos.setText(String.valueOf(pontos));
                }
                else{
                    if((a!=7) && (b!=7)&&(c!=7)){
                        moeda=moeda-1;
                        txtMoeda.setText(String.valueOf(moeda));
                        txtPontos.setText(String.valueOf(pontos));
                        if(moeda==0){
                            AlertDialog.Builder alertaPerdeu = new AlertDialog.Builder(this);
                            alertaPerdeu.setTitle("GAME OVER");
                            alertaPerdeu.setMessage("Infelizmente você perdeu!");
                            alertaPerdeu.setIcon(android.R.drawable.ic_delete);
                            alertaPerdeu.setPositiveButton("OK",null);
                            alertaPerdeu.create();
                            alertaPerdeu.show();
                            bt_1.setText("");
                            bt_2.setText("");
                            bt_3.setText("");
                            bt_1.setEnabled(false);
                            bt_2.setEnabled(false);
                            bt_3.setEnabled(false);
                            apostar.setEnabled(false);
                        }
                    }
                }

            }

        }

    }
}