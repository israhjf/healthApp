package israel.healthapp.views.onboarding;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import israel.healthapp.R;


public class FitnessLevelFragment extends Fragment {
    private static final String TAG = "FitnessLevelFragment";

    private Button button;
    private String fitnessLevel;

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

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_buttons);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radio_beginner:
                        fitnessLevel = "beginner";
                        break;
                    case R.id.radio_intermadiate:
                        fitnessLevel = "intermediate";
                        break;
                    case R.id.radio_advanced:
                        fitnessLevel = "advanced";
                        break;
                }
            }
        });

        return view;
    }

    public void openNextFragment(){
        Bundle args = new Bundle();
        args.putString("fitnessLevelKey", fitnessLevel);
        Fragment userInfoFragment = new UserInfoFragment();
        userInfoFragment.setArguments(args);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.authentication_fragment_container, userInfoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch(view.getId()) {
//            case R.id.radio_beginner:
//                if (checked)
//                    fitnessLevel = "beginner";
//                    break;
//            case R.id.radio_intermadiate:
//                if (checked)
//                    fitnessLevel = "intermediate";
//                    break;
//            case R.id.radio_advanced:
//                if (checked)
//                    fitnessLevel = "advanced";
//                    break;
//        }
//    }
}