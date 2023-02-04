package com.pascalcase.silvertrails;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.pascalcase.silvertrails.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment
{
    private FragmentFirstBinding binding;

    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mainActivity = (MainActivity) getActivity();
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.bungusButton.setText("fucking shit");

        binding.requestLocButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                binding.bungusButton.setText("bro");

                boolean hasCourseLocPerm = mainActivity.checkIfAlreadyHavePerm(Manifest.permission.ACCESS_COARSE_LOCATION);
                boolean hasFineLocPerm = mainActivity.checkIfAlreadyHavePerm(Manifest.permission.ACCESS_FINE_LOCATION);


                System.out.println("~~~ D E B U G ~~~: Clicked thingy");
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }

}