package com.example.lab7;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View; import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private static final String KEY_TITLE = "title";
    private static final String KEY_DETAILS = "details";
    private String title = "";
    private String details = "";
    public void updateData(String title, String details) {
        this.title = title;
        this.details = details;
        TextView titleText = getView().findViewById(R.id.title);
        TextView detailsText = getView().findViewById(R.id.details);
        titleText.setText(title);
        detailsText.setText(details);
    }
    public DetailFragment() {}
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_TITLE, title);
        outState.putString(KEY_DETAILS, details);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            title = savedInstanceState.getString(KEY_TITLE, "");
            details = savedInstanceState.getString(KEY_DETAILS, "");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView titleText = view.findViewById(R.id.title);
        TextView detailsText = view.findViewById(R.id.details);
        titleText.setText(title);
        detailsText.setText(details);
        return view;
    }

}
