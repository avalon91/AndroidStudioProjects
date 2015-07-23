package lucaspwo.br.meuapp5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView list;

    @Override
    protected void onStart() {
        super.onStart();
        TextView t = (TextView) findViewById(R.id.nomeText);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String nome = prefs.getString("nomePref", "Fulano");

        t.setText(nome);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listaDrawer);

        String[] lista = {"Android", "iOS", "Windows", "OS X", "Linux", "Configurações"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //return true;
            Toast.makeText(this, "Clicou em settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_info){
            Toast.makeText(this, "Clicou em informações", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, InfoActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) list.getItemAtPosition(position);
        Toast.makeText(this, "Clicou no item " + item, Toast.LENGTH_SHORT).show();
        if(item.equals("Configurações")){
            Intent it = new Intent(this, SettingsActivity.class);
            startActivity(it);
        }
    }
}
