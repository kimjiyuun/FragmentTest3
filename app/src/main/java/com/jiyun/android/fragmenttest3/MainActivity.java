package com.jiyun.android.fragmenttest3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceSrate) {
        super.onCreate(savedInstanceSrate);

        setContentView(R.layout.main);
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceSrate != null){
                return;
            }
            FragmentA firstFragment = new FragmentA();
            firstFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
    public void selecrFragment (View view) {
        Fragment fr = null;

        switch (view.getId()) {
            case R.id.button1:
                fr = new FragmentA();
                break;
            case R.id.button2:
                fr= new FragmentB();
                break;
        }

        FragmentManager fm =  getFragmentManager();
        FragmentTransaction flagmentTransaction = fm.beginTransaction();
        flagmentTransaction.replace(R.id.fragment_container, fr);
        flagmentTransaction.addToBackStack(null);
        flagmentTransaction.commit();

    }
}