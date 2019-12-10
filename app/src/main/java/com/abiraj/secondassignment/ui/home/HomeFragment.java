package com.abiraj.secondassignment.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.abiraj.secondassignment.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private EditText etRadius;
    private Button btnCalculate;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        etRadius = root.findViewById(R.id.etRadius);
        btnCalculate = root.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
            return root;
    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(etRadius.getText())){
            etRadius.setError("Please enter a value to calculate radius");
            etRadius.requestFocus();
            return;
        }

        int Radius = Integer.parseInt(etRadius.getText().toString());
        CircleOfArea AOC = new CircleOfArea(Radius);
        int Result = AOC.add();
        Toast.makeText(getActivity(), "Radius is : "+ Result, Toast.LENGTH_LONG).show();

    }
}

