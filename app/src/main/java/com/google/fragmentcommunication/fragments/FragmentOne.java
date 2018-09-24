package com.google.fragmentcommunication.fragments;


import android.app.Activity;
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
public class FragmentOne extends Fragment {


    FragmentTwo.Callback callback;
    private EditText etOne;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            this.callback = (MainActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        this.etOne = view.findViewById(R.id.etOne);
        view.findViewById(R.id.bButtonOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onDataFromFragmentOne(etOne.getText().toString());
            }
        });
        return view;
    }

    public void setTextData(String textData) {
        etOne.setText(textData);
    }

    public interface Callback {
        void onDataFromFragmentTwo(String data);
    }

}
