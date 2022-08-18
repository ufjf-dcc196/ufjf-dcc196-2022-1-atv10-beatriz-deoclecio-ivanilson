package br.ufjf.dcc196.atv10.cacaniquel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**Atividade 10 - Caça Níquel
 Discentes:

 Beatriz Cunha Rodrigues - 201776038

 Deoclécio Porfirio Ferreira Filho - 201876043

 Ivanylson Honório Gonçalves - 201776002
 * **/
public class MainActivity extends AppCompatActivity {

    TextView txtNome;
    Button btnEntrar;
    Button btnFechar;
    Button btnEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        btnEntrar = findViewById(R.id.btnVoltar);
        btnFechar = findViewById(R.id.btnFechar);
        btnEquipe = findViewById(R.id.btnEquipe);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Jogar.class);
                startActivity(intent);
            }
        });

        btnEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Credito.class);
                startActivity(intent);
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}