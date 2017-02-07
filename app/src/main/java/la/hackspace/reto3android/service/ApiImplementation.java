package la.hackspace.reto3android.service;


import retrofit.RestAdapter;

public class ApiImplementation {

    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://victorcasass.com/api")
            .build();

    public static ApiService getService(){

        return restAdapter.create(ApiService.class);

    }

}
