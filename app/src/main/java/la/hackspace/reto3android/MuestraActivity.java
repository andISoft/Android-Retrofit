package la.hackspace.reto3android;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import la.hackspace.reto3android.Entity.PokemonEntity;
import la.hackspace.reto3android.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MuestraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra);


        ApiImplementation.getService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> pokemones, Response response) {
                mostrarPokemons(pokemones);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("respuesta","Algo salio mal");
            }
        });


    }



    public void mostrarPokemons(ArrayList<PokemonEntity> lp){

        ListView miLista = (ListView) findViewById(R.id.miLista);
        ArrayAdapter<PokemonEntity> adaptador = new ArrayAdapter<PokemonEntity>(this,android.R.layout.simple_list_item_1,lp);
        miLista.setAdapter(adaptador);


    }



    /*@Override
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

        return super.onOptionsItemSelected(item);
    }*/
}
