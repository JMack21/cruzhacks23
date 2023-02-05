package com.pascalcase.silvertrails.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
//        double scale = campusMap.getZoomedXLeft();
//        double xOffset = campusMap.getZoomedXLeft();
//        double yOffset = campusMap.getZoomedXLeft();
//
//        double xPosThing = xOffset;
//        double yPosThing = yOffset;
//
//        binding.mapTX.setText("xpos: " + xPosThing);
//        binding.mapTY.setText("ypos: " + yPosThing);

//        System.out.println("~~~ D E B U G ~~~ xPosThing = " + xPosThing);
//        System.out.println("~~~ D E B U G ~~~ xPosThing = " + yPosThing);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}