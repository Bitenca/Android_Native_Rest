package cursoandroid.cedro_nds.com.provapraticaandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = fm.findFragmentById(R.id.fragment_content);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.remove(fragment);
                    ft.replace(R.id.fragment_content, new MainFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction ft2 = fm.beginTransaction();
                    ft2.remove(fragment);
                    ft2.replace(R.id.fragment_content, new UserCountriesFragment());
                    ft2.commit();
                    return true;
                case R.id.navigation_notifications:
                    FragmentTransaction ft3 = fm.beginTransaction();
                    ft3.remove(fragment);
                    ft3.replace(R.id.fragment_content, new UserProfileFragment());
                    ft3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content, new MainFragment());
        ft.commit();

        ButterKnife.bind(this);
    }

}
