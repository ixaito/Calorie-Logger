package com.example.uijust;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class show extends Fragment {
    ExtendedFloatingActionButton fabCheckMeal;
    private ImageButton btnAddMeal;
    FloatingActionButton fabAddMealManually, fabAddMealCamera;
    Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        fabCheckMeal = view.findViewById(R.id.fabCheckMeal);
        fabCheckMeal.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.showToMeal));

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
            Navigation.findNavController(requireParentFragment().getView()).navigate(R.id.action_show_to_capture);
            dialog.dismiss();
        });

        btnAddMeal.setOnClickListener(view1 -> dialog.show());
        return view;
    }
}