package la.hackspace.reto3android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import la.hackspace.reto3android.Entity.PokemonEntity;
import la.hackspace.reto3android.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button boton = (Button)findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                operarIngreso();
            }
        });

    }

    public void operarIngreso(){

        ApiImplementation.getService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> pokemones, Response response) {
                String nombre = ((EditText)findViewById(R.id.editTextNombre)).getText().toString();
                String tipo = ((EditText)findViewById(R.id.editTextTipo)).getText().toString();
                if(esValido(pokemones,nombre,tipo)){
                    Intent nuevaActividad = new Intent(MainActivity.this,MuestraActivity.class);
                    startActivity(nuevaActividad);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("respuesta","Algo salio mal");
            }
        });


    }


    public boolean esValido(ArrayList<PokemonEntity> lp,String nom,String tip){

        for(PokemonEntity pok :lp){
            if(nom.equals(pok.getNombre()) && tip.equals(pok.getTipo())){
                return true;
            }
        }
        return false;
    }
}
