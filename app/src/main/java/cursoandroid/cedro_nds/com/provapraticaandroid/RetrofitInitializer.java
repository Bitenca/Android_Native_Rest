package cursoandroid.cedro_nds.com.provapraticaandroid;


import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitInitializer {

    public Retrofit init (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sslapidev.mypush.com.br/world/countries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public interface ApiService{
        @GET("active/")
        Call<List<JSONObject>> listCountries();

        @GET("{id}/flag")
        Call<JSONObject> listCountryFlag(@Path("id") int id);
    }


}
