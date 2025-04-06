package com.spamdetector.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.spamdetector.fragments.ReportFragment;

public class ReportsPagerAdapter extends FragmentStateAdapter {

    public ReportsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a new instance of ReportFragment with the appropriate time period
        return ReportFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        // Weekly, Monthly, Quarterly, Half-Yearly, Yearly
        return 5;
    }
}