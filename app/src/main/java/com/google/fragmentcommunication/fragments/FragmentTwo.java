package com.google.fragmentcommunication.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.fragmentcommunication.MainActivity;
import com.google.fragmentcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {


    private String textData;
    private EditText etTwo;

    FragmentOne.Callback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            this.callback = (MainActivity) context;
        }
    }

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        this.etTwo = view.findViewById(R.id.etTwo);

        view.findViewById(R.id.bButtonTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onDataFromFragmentTwo(etTwo.getText().toString());
            }
        });


        return view;
    }

    public void setTextData(String textData) {
        etTwo.setText(textData);
    }

    public interface Callback {
        void onDataFromFragmentOne(String data);
    }

}
