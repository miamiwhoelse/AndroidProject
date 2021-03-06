package com.example.jozumaster.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JozuMaster on 04/05/2015.
 */
public class ProfileFragment extends Fragment {
    private static OnChange activityListenerVoid = new OnChange() {
        @Override
        public void change(View view, Fragment fragment) {}
    };

    private OnChange activityListener = ProfileFragment.activityListenerVoid;

    public ProfileFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            this.activityListener = (OnChange) activity;
        }catch(ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        this.activityListener = ProfileFragment.activityListenerVoid;
    }

    public OnChange getActivityListener() {
        return activityListener;
    }

    public void setActivityListener(OnChange activityListener) {
        this.activityListener = activityListener;
    }
}
