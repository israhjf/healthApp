package israel.healthapp.views.introductory;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import israel.healthapp.R;
import israel.healthapp.views.onboarding.AuthenticationActivity;

public class ThirdScreenFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_screen, container, false);
        button = (Button)view.findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        return view;
    }

    public void openNewActivity(){
        Intent intent = new Intent(getActivity(), AuthenticationActivity.class);
        startActivity(intent);
    }
}