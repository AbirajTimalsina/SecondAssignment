package com.abiraj.secondassignment.ui.Plaindrome;

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

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private EditText etPlaindrome;
    private Button btnPalindrome;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        etPlaindrome = root.findViewById(R.id.etPlaindrome);
        btnPalindrome = root.findViewById(R.id.btnPalindrome);
        btnPalindrome.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(etPlaindrome.getText())){

            etPlaindrome.setError("Please enter a number to calculate Plaindrome");
            etPlaindrome.requestFocus();
            return;
        }

        int First, Result;

        First = Integer.parseInt(etPlaindrome.getText().toString());
        PlaindromeClass plaindrome = new PlaindromeClass();
        Result = plaindrome.reverse(First);

        if(Result == First){
            Toast.makeText(getActivity(),  Result + " : is a plaindrome number", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(),Result + "is not a plaindrome number", Toast.LENGTH_LONG).show();
        }
    }

}