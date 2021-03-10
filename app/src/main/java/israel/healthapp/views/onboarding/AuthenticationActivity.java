package israel.healthapp.views.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import israel.healthapp.R;

public class AuthenticationActivity extends AppCompatActivity {
    private static final String TAG = "AuthenticationActivity";
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        getSupportActionBar().hide();

        Log.d(TAG, "onCreate: Starting");
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.authentication_view_pager);
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WelcomeFragment(), "Welcome");
        adapter.addFragment(new FitnessLevelFragment(), "FitnessLevel");
        viewPager.setAdapter(adapter);
    }
}