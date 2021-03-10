package israel.healthapp.views.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import israel.healthapp.R;


public class FitnessLevelFragment extends Fragment {
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fitness_level, container, false);
        button = (Button)view.findViewById(R.id.button_next_fitness_level);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextFragment();
            }
        });
        return view;
    }

    public void openNextFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.authentication_fragment_container, new UserInfoFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_beginner:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_intermadiate:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_advanced:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}