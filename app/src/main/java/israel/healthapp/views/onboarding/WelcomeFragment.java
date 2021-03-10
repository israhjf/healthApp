package israel.healthapp.views.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import israel.healthapp.R;

public class WelcomeFragment extends Fragment {
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        button = (Button)view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextFragment();
            }
        });
        return view;
    }

    public void openNextFragment(){
        FitnessLevelFragment newGamefragment = new FitnessLevelFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.authentication_view_pager, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}