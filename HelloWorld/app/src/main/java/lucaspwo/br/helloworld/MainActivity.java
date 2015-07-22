package lucaspwo.br.helloworld;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Executa quando a aplicação é iniciada
        Toast t = Toast.makeText(this, "Aplicação iniciou", Toast.LENGTH_SHORT);
        t.show();
    }

    public void calcular(View v){
        EditText editA = (EditText) findViewById(R.id.editA);
        EditText editB = (EditText) findViewById(R.id.editB);
        EditText editC = (EditText) findViewById(R.id.editC);

        TextView textResultado = (TextView) findViewById(R.id.textResultado);

        //Pega o texto contido nos elementos EditText
        String tA, tB, tC;
        tA = editA.getText().toString();
        tB = editB.getText().toString();
        tC = editC.getText().toString();

        //Converte de Strings para floats para realizar operações matemáticas
        float vA, vB, vC, raiz1, raiz2;
        vA = Float.valueOf(tA);
        vB = Float.valueOf(tB);
        vC = Float.valueOf(tC);

        //Calcula delta e as raízes
        float delta = (vB*vB) - (4 * vA * vC);
        raiz1 = (float)(- vB + Math.sqrt(delta))/(2*vA);
        raiz2 = (float)(- vB - Math.sqrt(delta))/(2*vA);

        //Exibe os resultados no TextView
        String tRaiz1, tRaiz2;
        tRaiz1 = String.valueOf(raiz1);
        tRaiz2 = String.valueOf(raiz2);

        //Muda o valor do texto de resultado para exibir os resultados
        textResultado.setText("Raiz 1: " + tRaiz1 + ", Raiz 2: " + tRaiz2);
    }

    /*public void mudarCor(View v){
        Toast t = Toast.makeText(this, "Clicou no botão", Toast.LENGTH_SHORT);
        t.show();

        TextView texto = (TextView)findViewById(R.id.meuTextView);
        texto.setText("Meu novo texto");
        texto.setTextSize(35);
        int color = Color.parseColor("#FF4400");
        texto.setTextColor(color);
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        //Executa quando a aplicação é fechada
        Toast t = Toast.makeText(this, "Aplicação parou", Toast.LENGTH_SHORT);
        t.show();
    }
}
