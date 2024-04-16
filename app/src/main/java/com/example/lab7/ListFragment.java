package com.example.lab7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> months = new ArrayList<String>();
        prepareDataList(months);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, months);
        ListView someList = (ListView) view.findViewById(R.id.someList);
        someList.setAdapter(adapter);
        someList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<String> dataDetails = new ArrayList<String>();
                prepareDetailsList(dataDetails);
                String title = adapterView.getItemAtPosition(i).toString();
                String details = dataDetails.get(i);

                Bundle result = new Bundle();
                result.putString("title", title);
                result.putString("details", details);
                getParentFragmentManager().setFragmentResult("detailKey", result);
            }

        });
    }
    public void prepareDataList(ArrayList<String> data){
        data.add("Январь");
        data.add("Февраль");
        data.add("Март");
        data.add("Апрель");
        data.add("Май");
        data.add("Июнь");
        data.add("Июль");
        data.add("Август");
        data.add("Сентябрь");
        data.add("Октябрь");
        data.add("Ноябрь");
        data.add("Декабрь");
    }

    public void prepareDetailsList(ArrayList<String> data){
        data.add("Январь - второй месяц зимы");
        data.add("Февраль - третий месяц зимы");
        data.add("Март - первый месяц весны");
        data.add("Апрель - второй месяц весны");
        data.add("Май - третий месяц весны");
        data.add("Июнь - первый месяц лета");
        data.add("Июль - второй месяц лета");
        data.add("Август - третий месяц лета");
        data.add("Сентябрь - первый месяц осени");
        data.add("Октябрь - второй месяц осени");
        data.add("Ноябрь - третий месяц осени");
        data.add("Декабрь - первый месяц зимы");

    }

}