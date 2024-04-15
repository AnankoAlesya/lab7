package com.example.lab7;
import android.os.Bundle; import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View; import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    public DetailFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView title = view.findViewById(R.id.title);
        TextView details = view.findViewById(R.id.details);
        title.setText("");
        details.setText("");
        return view;
    }

}
