package com.pascalcase.silvertrails;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pascalcase.silvertrails.databinding.FragmentHomeBinding;
import com.pascalcase.silvertrails.databinding.FragmentNotificationsBinding;
import com.pascalcase.silvertrails.databinding.FragmentStudySpotPopupBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudySpotPopupFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class StudySpotPopupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentStudySpotPopupBinding binding;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudySpotPopupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudySpotPopupFragment newInstance(String param1, String param2) {
        StudySpotPopupFragment fragment = new StudySpotPopupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public StudySpotPopupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStudySpotPopupBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study_spot_popup, container, false);
    }
}