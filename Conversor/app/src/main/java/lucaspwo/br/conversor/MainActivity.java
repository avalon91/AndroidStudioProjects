package lucaspwo.br.conversor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ListView.OnItemClickListener{

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.minhaLista);

        ArrayList<String> array = new ArrayList<String>();
        array.add("Dólar");
        array.add("Iene");
        array.add("Libra");
        array.add("Euro");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EditText valor_edit = (EditText) findViewById(R.id.meuValor);
        String valor = valor_edit.getText().toString();

        float valor_d = Float.valueOf(valor);

        String tipo = (String) lista.getItemAtPosition(position);

        Intent it = new Intent(this, ResultadoActivity.class);
        it.putExtra("valor", valor_d);
        it.putExtra("tipo", tipo);
        startActivity(it);
    }
}
