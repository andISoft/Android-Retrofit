package la.hackspace.reto3android.service;


import java.util.ArrayList;

import la.hackspace.reto3android.Entity.PokemonEntity;
import retrofit.Callback;
import retrofit.http.GET;

public interface ApiService {


    @GET("/lista_pokemons.php")

    void getPokemons(Callback<ArrayList<PokemonEntity>> callback);
}
