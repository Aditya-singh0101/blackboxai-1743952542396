package com.spamdetector.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.spamdetector.R;

public class ReportFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    public static ReportFragment newInstance(int position) {
        ReportFragment fragment = new ReportFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        TextView reportTextView = view.findViewById(R.id.reportTextView);

        if (getArguments() != null) {
            int position = getArguments().getInt(ARG_POSITION);
            reportTextView.setText("Report for " + getReportPeriod(position));
        }

        return view;
    }

    private String getReportPeriod(int position) {
        switch (position) {
            case 0: return "Weekly";
            case 1: return "Monthly";
            case 2: return "Quarterly";
            case 3: return "Half-Yearly";
            case 4: return "Yearly";
            default: return "Unknown";
        }
    }
}