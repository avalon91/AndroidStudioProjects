package lucaspwo.br.conversor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ResultadoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent it = getIntent();

        double valor = it.getFloatExtra("valor", 0);
        double valor_antigo = valor;
        String tipo =
    }

}
