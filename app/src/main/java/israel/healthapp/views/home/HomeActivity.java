package israel.healthapp.views.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import israel.healthapp.R;
import israel.healthapp.presenters.LoginPresenter;
import israel.healthapp.services.request.LoginRequest;
import israel.healthapp.services.response.LoginResponse;
import israel.healthapp.views.MainActivity;

public class HomeActivity extends AppCompatActivity implements LoginPresenter.View{
    private LoginPresenter presenter;
    private TextView userName;
    private TextView fitnessLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        presenter = new LoginPresenter(this);
        userName = findViewById(R.id.user_name);
        fitnessLevel = findViewById(R.id.fitness_level);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HomeActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LoginRequest request = new LoginRequest(getApplicationContext());
        LoginResponse response = presenter.getLoginResponse(request);
        if (response.success){
            userName.setText(response.getUser().getName());
            fitnessLevel.setText(response.getUser().getFitnessLevel());
            Toast.makeText(HomeActivity.this, "User Logged In!", Toast.LENGTH_SHORT).show();
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}