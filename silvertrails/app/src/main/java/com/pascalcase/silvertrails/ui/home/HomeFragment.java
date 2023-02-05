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

import com.pascalcase.silvertrails.MainActivity;
import com.pascalcase.silvertrails.databinding.FragmentHomeBinding;
import com.pascalcase.silvertrails.gamertools.imagescrolling.TouchImageView;
import com.pascalcase.silvertrails.gamertools.maptools.MapMarker;
import com.pascalcase.silvertrails.gamertools.maptools.MapMarkerManager;

public class HomeFragment extends Fragment
{

    private MainActivity mainActivity;
    private FragmentHomeBinding binding;

    private TouchImageView campusMap;

    private MapMarkerManager mapMarkerManager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        mainActivity = (MainActivity) getActivity();
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        {
            campusMap = binding.campusPngImage;
            campusMap.receiverOfUpdate = this;

            mapMarkerManager = new MapMarkerManager();
            mapMarkerManager.addMarker(new MapMarker(binding.moveMe, 70f, 0f));

            Button chunga = new Button(getContext());
            binding.mapMarkersLayout.addView(chunga);
            mapMarkerManager.addMarker(new MapMarker(chunga, 300f, 300f));
        }

        mainActivity.requestLocationPermsIfNeeded();

        return binding.getRoot();
    }

    // Custom method
    public void onUpdateZoom()
    {
        float transX = campusMap.getPubTransX();
        float transY = campusMap.getPubTransY();
        float scaleX = campusMap.getPubScaleX();
        float scaleY = campusMap.getPubScaleY();

        mapMarkerManager.updateMarkerPositions(transX, transY, scaleX, scaleY);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}