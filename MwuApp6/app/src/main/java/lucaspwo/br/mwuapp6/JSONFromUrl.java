package lucaspwo.br.mwuapp6;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tibuurcio on 23/07/15.
 */
public class JSONFromUrl {

    /* Retorna uma string em formato JSON através de uma url. */
    public static String getJSON(URL url) {

        // Esses dois precisam ser declarados for do try/catch
        // para que possam ser fechados depois no bloco finally
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Variável que vai conter a resposta em formato JSON.
        String resposta = null;

        try {
            // Cria o request para a url e abre a conexão
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Lê os dados de entrada em uma String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Caso os dados de entrada não consigam ser lidos,
                // não há necessidade de continuar.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            // Lê os dados a partir do reader e concatena na String a seguir
            // enquanto houver dados para ler.
            String line;
            while ((line = reader.readLine()) != null) {
                // O \n abaixo serve apenas para debug de código.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Caso a resposta tenha sido vazia, não precisamos continuar.
                return null;
            }
            resposta = buffer.toString();
        } catch (IOException e) {
            // Caso algum erro ocorra, imprime o erro.
            Log.e("Erro", "Erro ao pegar o JSON", e);
            return null;
        } finally {
            // Independente se conseguimos pegar a resposta ou não,
            // o código abaixo é executado para fechar as conexões.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("Erro", "Error closing stream", e);
                }
            }
        }

        return resposta;
    }
}
