package israel.healthapp.views.introductory;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import israel.healthapp.R;
import israel.healthapp.views.onboarding.AuthenticationActivity;


public class FirstScreenFragment extends Fragment {
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_screen, container, false);
        button = (Button)view.findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    public void openNewActivity(){
        Intent intent = new Intent(getActivity(), AuthenticationActivity.class);
        startActivity(intent);
    }
}