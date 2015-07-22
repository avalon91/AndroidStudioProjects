package lucaspwo.br.meusegundoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirNovaTela(View view){
        /*Button b = (Button) view;
        Toast t = Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT);
        t.show();*/

        /*Intent it = new Intent(this, MinhaNovaActivity.class);        //Abre uma nova activity através de um intent
        startActivity(it);*/
        //finish();

        Uri uri = Uri.parse("tel:999213787");                   //Prepara um parse com um número de telefone para ser discado
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        startActivity(it);
    }

    public void enviarInfo(View view){                              //Exemplo para passar dados entre activities
        EditText edit1 = (EditText) findViewById(R.id.edit1);
        String texto = edit1.getText().toString();

        Bundle pacote = new Bundle();       //Cria um pacote
        pacote.putString("texto",texto);    //Coloca uma string no pacote

        Intent it = new Intent(this, MinhaNovaActivity.class);
        it.putExtra("pacote", pacote);
        startActivity(it);
    }
}
