package com.google.fragmentcommunication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.fragmentcommunication.fragments.FragmentOne;
import com.google.fragmentcommunication.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentOne.Callback, FragmentTwo.Callback {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentOne = (FragmentOne) getSupportFragmentManager().findFragmentById(R.id.fOne);
        fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fTwo);

    }

    @Override
    public void onDataFromFragmentTwo(String data) {
        fragmentOne.setTextData(data);
    }

    @Override
    public void onDataFromFragmentOne(String data) {
        fragmentTwo.setTextData(data);
    }
}
