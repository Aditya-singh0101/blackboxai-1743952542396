package com.spamdetector.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.spamdetector.R;
import com.spamdetector.adapters.ReportsPagerAdapter;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        ReportsPagerAdapter adapter = new ReportsPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Weekly");
                            break;
                        case 1:
                            tab.setText("Monthly");
                            break;
                        case 2:
                            tab.setText("Quarterly");
                            break;
                        case 3:
                            tab.setText("Half-Yearly");
                            break;
                        case 4:
                            tab.setText("Yearly");
                            break;
                    }
                }
        ).attach();
    }
}