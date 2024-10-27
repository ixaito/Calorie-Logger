package com.example.uijust;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

public class Meal extends Fragment {
    private TextView date;
    private ImageButton changeDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal, container, false);
        date = view.findViewById(R.id.date);
        changeDate = view.findViewById(R.id.changeDate);
        changeDate.setOnClickListener(view1 -> openDialog());
        return view;
    }

    private void openDialog(){
        DatePickerDialog dialog = new DatePickerDialog(requireActivity(),R.style.CustomDatePickerDialog,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date.setText(i + "." + (i1+1) + "." + i2);
            }
        }, 2024, 10, 26);
        dialog.show();
    }
}