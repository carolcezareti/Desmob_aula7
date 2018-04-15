package paises.devmob.ftce.usjt.br.paises.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by carol on 31/03/2018.
 */

public class PaisesNetwork {
    public static ArrayList<Paises> buscarPaises(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        ArrayList<Paises> paises = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();

        try{
            JSONArray lista = new JSONArray(json);
            for(int i=0; i < lista.length(); i++){
                JSONObject item = (JSONObject)lista.get(i);
                Paises paises = new Paises();
                paises.setId(item.getInt("id"));
                paises.setNome(item.getString("nome"));
                paises.setBandeira(item.getString("bandeira"));
                paises.setRegiao(item.getString("regiao"));
                paises.setCapital(item.getString("capital"));

                JSONObject filaItem = item.getJSONObject("fila");
                Fila fila = new Fila();
                fila.setId(filaItem.getInt("id"));
                fila.setNome(filaItem.getString("nome"));
                fila.setFigura(filaItem.getString("figura"));
                paises.setFila(fila);
                paises.add();
            }
        }catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }


        return paises;
    }
}
