package lucaspwo.br.mwuapp6;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listview_mensagens);

        GetJSONTask task = new GetJSONTask();
        task.execute("http://10.5.24.113/get_mensagens/");


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
            return true;
        }
        else if (id == R.id.action_refresh){
            //Refresh na lista
        }

        return super.onOptionsItemSelected(item);
    }

    public class GetJSONTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

            ArrayList<String> array = new ArrayList<>();

            try{
                s = "{\'mensagens\': [{\'autor\': \'Herbeton\', \'hora\': \'10:03\', \'texto\': \'kkk\'}, {\'autor\': \'Gabriel\', \'hora\': \'11:11\', \'texto\': \'Nova mensagem\'}, {\'autor\': \'Herbeton\', \'hora\': \'11:11\', \'texto\': \'H\'}, {\'autor\': \'\\u30ac\\u30d6\\u30ea\\u30a8\\u30eb\\u3002\', \'hora\': \'11:15\', \'texto\': \'\\u308f\\u305f\\u3061\\u308f\\u30ac\\u30d6\\u30ea\\u30a8\\u30eb\\u3067\\u3059\\u3002\'}, {\'autor\': \'Gabriel Tib\\u00farcio\', \'hora\': \'11:16\', \'texto\': \'Essa \\u00e9 uma mensagem de teste usada para o minicurso de android da ECT.\'}, {\'autor\': \'Gabriel\', \'hora\': \'11:36\', \'texto\': \'Ruben chegou bastante atrasado!\'}], \'quantidade\': 6}";
                JSONObject json = new JSONObject(s);
                JSONArray mensagens = json.getJSONArray("mensagens");

                for(int i = 0; i < mensagens.length(); i++){
                    JSONObject mensagem_atual = mensagens.getJSONObject(i);
                    String texto = mensagem_atual.getString("autor");
                    texto = texto + ": ";
                    texto = texto + mensagem_atual.getString("texto") + " | ";
                    texto = texto + mensagem_atual.getString("hora");
                    array.add(texto);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, array);

                lista.setAdapter(adapter);

            } catch (JSONException e){
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                String resultado = JSONFromUrl.getJSON(url);
                return resultado;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
