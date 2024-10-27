package com.example.uijust;

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

public class show extends Fragment {
    ExtendedFloatingActionButton fabCheckMeal;
    private ImageButton btnAddMeal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        fabCheckMeal = view.findViewById(R.id.fabCheckMeal);
        fabCheckMeal.setOnClickListener(view1 -> {
            //Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view1).navigate(R.id.showToMeal);
        });
        btnAddMeal = view.findViewById(R.id.btnAddMeal);
        btnAddMeal.setOnClickListener(view1 -> {
            Toast.makeText(requireActivity(), "Te", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view1).navigate(R.id.action_show_to_capture);
        });
        return view;
    }
}