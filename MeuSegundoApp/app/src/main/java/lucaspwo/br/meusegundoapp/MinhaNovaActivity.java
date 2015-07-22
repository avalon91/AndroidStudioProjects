package lucaspwo.br.meusegundoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MinhaNovaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minha_nova);

        Intent it = getIntent();
        Bundle pacote = it.getBundleExtra("pacote");        //Recebe o pacote
        String texto = pacote.getString("texto");           //Retira o texto do pacote

        Toast t = Toast.makeText(this, texto, Toast.LENGTH_SHORT);  //Exibe o texto num toast
        t.show();

        TextView text1 = (TextView) findViewById(R.id.text1);       //Exibe o texto através de um elemento na tela
        text1.setText(texto);
        text1.setTextSize(40);
    }



}
