package com.abiraj.secondassignment.ui.SwapNumber;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.abiraj.secondassignment.R;

public class SlideshowFragment extends Fragment implements View.OnClickListener {
     private EditText etFirst,etSecond;
     private Button btnSwap;


    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        etFirst = root.findViewById(R.id.etFirst);
        etSecond = root.findViewById(R.id.etSecond);
        btnSwap = root.findViewById(R.id.btnSwap);

        btnSwap.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {

            // Validation
        if(TextUtils.isEmpty(etFirst.getText())){

            etFirst.setError("Please Enter a number");
            etFirst.requestFocus();
        }else if(TextUtils.isEmpty(etSecond.getText())){

            etSecond.setError("Please Enter a number");
            etSecond.requestFocus();
        }

       int First, Second;

        First = Integer.parseInt(etFirst.getText().toString());
        Second = Integer.parseInt(etSecond.getText().toString());

        etFirst.setText(Integer.toString(Second));
        etSecond.setText(Integer.toString(First));

    }
}