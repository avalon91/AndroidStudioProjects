package lucaspwo.br.meuapp3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ListView.OnItemClickListener{

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.minha_lista);

        ArrayList<String> array = new ArrayList<String>();
        array.add("Item 1");
        array.add("Item 2");
        array.add("Item 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        lista.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.v("Teste", "Foi clicado");
        //Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
