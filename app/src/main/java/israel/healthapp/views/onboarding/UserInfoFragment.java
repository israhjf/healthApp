package israel.healthapp.views.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import israel.healthapp.R;
import israel.healthapp.views.home.HomeActivity;

public class UserInfoFragment extends Fragment {
    private Button button;
    private String fitnessLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        button = (Button)view.findViewById(R.id.user_start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        fitnessLevel = getArguments().getString("fitnessLevelKey");
        return view;
    }

    public void openHomeActivity(){
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}