package israel.healthapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import israel.healthapp.R;
import israel.healthapp.views.introductory.ViewPagerAdapter;
import israel.healthapp.views.introductory.ViewPagerFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ViewPagerFragment.class, null)
                    .commit();
        }
    }
}