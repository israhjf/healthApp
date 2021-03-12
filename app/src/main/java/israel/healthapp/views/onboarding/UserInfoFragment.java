package israel.healthapp.views.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import israel.healthapp.R;
import israel.healthapp.models.User;
import israel.healthapp.presenters.RegisterPresenter;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.RegisterResponse;
import israel.healthapp.views.home.HomeActivity;

public class UserInfoFragment extends Fragment implements RegisterPresenter.View {
    private static final String TAG = "UserInfoFragment";

    private String fitnessLevel;
    private String name;
    private String birthdate;
    private Float height;
    private Float weight;
    private String gender;
    private RegisterPresenter presenter;

    private EditText nameEditText;
    private EditText birthDateEditText;
    private EditText heightEditText;
    private EditText weightEditText;
    private Switch simpleSwitch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        presenter = new RegisterPresenter(this);

        nameEditText = view.findViewById(R.id.userinfo_user_name);
        birthDateEditText = view.findViewById(R.id.user_birthdate);
        heightEditText = view.findViewById(R.id.user_height);
        weightEditText = view.findViewById(R.id.user_weight);
        simpleSwitch = (Switch) view.findViewById(R.id.genderSwitch);

        Button button = (Button)view.findViewById(R.id.user_start_button);
        fitnessLevel = getArguments().getString("fitnessLevelKey");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveUserInput();
                if (name != null && birthdate != null && height != 0.0f && weight != 0.0f && gender != null){
                    User user = new User(name, birthdate, height, weight, gender, fitnessLevel);
                    RegisterRequest request = new RegisterRequest(user, getContext());
                    RegisterResponse response = presenter.getRegisterResponse(request);
                    if (response.success)
                        openHomeActivity();
                    else{
                        Log.e(TAG, "Error: while registering User");
                        Toast.makeText(getActivity(), "Error: while registering", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Error: invalid input!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void retrieveUserInput(){
        try {
            name = nameEditText.getText().toString();
            birthdate = birthDateEditText.getText().toString();
            height = Float.parseFloat(heightEditText.getText().toString());
            weight = Float.parseFloat(weightEditText.getText().toString());
            Boolean genderBoolean = simpleSwitch.isChecked();
            gender = genderBoolean ? "M" : "F";
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void openHomeActivity(){
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}