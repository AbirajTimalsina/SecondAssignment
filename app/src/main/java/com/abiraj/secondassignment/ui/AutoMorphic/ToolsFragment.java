package com.abiraj.secondassignment.ui.AutoMorphic;

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

public class ToolsFragment extends Fragment implements View.OnClickListener {

    private EditText etAutoMorphic;
    private Button btnAutoMorphic;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        etAutoMorphic = root.findViewById(R.id.etAutoMorphic);
        btnAutoMorphic = root.findViewById(R.id.btnAutoMorphic);

        btnAutoMorphic.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(etAutoMorphic.getText())){

            etAutoMorphic.setError("Please Enter a Number");
            etAutoMorphic.requestFocus();
        }

        int First, Result;

        AutoMorphicClass autoMorphicClass = new AutoMorphicClass();
        First = Integer.parseInt(etAutoMorphic.getText().toString());
        Result = autoMorphicClass.auto(First);

        if(Result== 0){

            Toast.makeText(getActivity(), First + ": is a AutoMorphic Number ", Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(getActivity(), First + " : is not a AutoMorphic Number", Toast.LENGTH_LONG).show();
        }
    }
}