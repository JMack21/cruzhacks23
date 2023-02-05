package com.pascalcase.silvertrails.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pascalcase.silvertrails.databinding.FragmentHomeBinding;
import com.pascalcase.silvertrails.gamertools.imagescrolling.TouchImageView;

public class HomeFragment extends Fragment
{

    private FragmentHomeBinding binding;
    private TouchImageView campusMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        {
            campusMap = binding.campusPngImage;
            campusMap.receiverOfUpdate = this;
        }

        return binding.getRoot();
    }

    // Custom method
    public void onUpdateZoom()
    {
        Button moveMe = binding.moveMe;
        moveMe.setX(campusMap.getPubTransX());
        moveMe.setY(campusMap.getPubTransY());
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}