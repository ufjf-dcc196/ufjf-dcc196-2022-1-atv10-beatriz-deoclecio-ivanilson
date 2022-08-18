package br.ufjf.dcc196.atv10.cacaniquel;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**Atividade 10 - Caça Níquel
 Discentes:

 Beatriz Cunha Rodrigues - 201776038

 Deoclécio Porfirio Ferreira Filho - 201876043

 Ivanylson Honório Gonçalves - 201776002
 * **/
/**Classe Credito serve para mostrar o nome dos integrantes**/
public class Credito extends AppCompatActivity {
    //Criando o botato
    Button btnVoltar;
    //Chamando o criação do activity credito
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        btnVoltar=findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
