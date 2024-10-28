package com.example.uijust;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Meal extends Fragment {
    private TextView date;
    private ImageButton changeDate;

    private ImageButton btnAddMeal;
    FloatingActionButton fabAddMealManually, fabAddMealCamera;
    Dialog dialog;

    ImageButton btnReturn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal, container, false);
        date = view.findViewById(R.id.date);
        changeDate = view.findViewById(R.id.changeDate);
        changeDate.setOnClickListener(view1 -> openDialog());

        // add meal dialog
        btnAddMeal = view.findViewById(R.id.btnAddMeal);
        dialog = new Dialog(requireActivity());
        dialog.setContentView(R.layout.fragment_dialog_add_meal);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setDimAmount(0.7f);

        fabAddMealCamera = dialog.findViewById(R.id.fabAddMealCamera);
        fabAddMealManually = dialog.findViewById(R.id.fabAddMealManually);

        fabAddMealManually.setOnClickListener(view1 -> {
            Toast.makeText(requireActivity(), "Manually", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        fabAddMealCamera.setOnClickListener(view1 -> {
            Navigation.findNavController(requireParentFragment().getView()).navigate(R.id.action_meal_to_capture);
            dialog.dismiss();
        });

        btnAddMeal.setOnClickListener(view1 -> dialog.show());

        // navigate to show fragment
        btnReturn = view.findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireParentFragment().getView()).navigate(R.id.action_meal_to_show);
            }
        });
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