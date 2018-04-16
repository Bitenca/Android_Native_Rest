package cursoandroid.cedro_nds.com.provapraticaandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Retrofit ri = new RetrofitInitializer().init();

        final RetrofitInitializer.ApiService apiService = ri.create(RetrofitInitializer.ApiService.class);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1 );
        }
        else {

            final Call<List<JSONObject>> request =  apiService.listCountries();

            request.enqueue(new Callback<List<JSONObject>>() {
                @Override
                public void onResponse(Call<List<JSONObject>> call, Response<List<JSONObject>> response) {
                    Log.i("FETCH_COUNTRIES",response.body().toString());

                }

                @Override
                public void onFailure(Call<List<JSONObject>> call, Throwable t) {
                    Toast.makeText(getContext(), "Nenhum pais encontrado", Toast.LENGTH_LONG).show();
                    Log.i("FETCH_COUNTRIES",request.request().toString());
                    Log.i("FETCH_COUNTRIES",apiService.listCountries().toString());

                }
            });
        }

        return inflater.inflate(R.layout.main_fragment, container, false);
    }
}


