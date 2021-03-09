package israel.healthapp.views.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import israel.healthapp.R;

public class ViewPagerFragment extends Fragment {

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FirstScreenFragment());
        fragmentList.add(new SecondScreenFragment());
        fragmentList.add(new ThirdScreenFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentList,
                requireActivity().getSupportFragmentManager(), getLifecycle());

        viewPager = view.findViewById(R.id.viewPager);
        pagerAdapter = adapter;
        viewPager.setAdapter(pagerAdapter);

        return view;
    }
}