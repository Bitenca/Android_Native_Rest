package cursoandroid.cedro_nds.com.provapraticaandroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import cursoandroid.cedro_nds.com.provapraticaandroid.RetrofitInitializer;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Retrofit ri = new RetrofitInitializer().init();

        RetrofitInitializer.ApiService apiService = ri.create(RetrofitInitializer.ApiService.class);

        return inflater.inflate(R.layout.main_fragment, container, false);
    }
}


