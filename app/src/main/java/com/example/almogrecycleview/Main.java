package com.example.almogrecycleview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.intellij.lang.annotations.JdkConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Main#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Main extends Fragment implements RecyclerViewInterface {
    private ArrayList<DataModel> dataSet;

    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Main.
     */
    // TODO: Rename and change types and number of parameters
    public static Main newInstance(String param1, String param2) {
        Main fragment = new Main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recycleView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity()); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();

        for(int i=0 ; i<MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    //MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]


            ));
        }



        CustomAdapter addapter = new CustomAdapter(getContext(),dataSet,this);
        recycleView.setAdapter(addapter);

         return view;
    }


    @Override
    public void onItemClick(int pos,View view) {
        String[] strArr = {"Staghorn coral is one of the most important types of coral reef species in a coral reef ecosystem.\n" +
                "Not only are these reef-building hard corals one of the fastest growing, they also provide a sheltered home to a vast array of marine animals.\n",
                "These stony reef-building corals grow in colonies across the Indo-Pacific and thrive in shallow coral reefs in depths of up to 20 metres.\n" +
                        "Leaf Corals grow upwards in an unusual conical shape, and their giant ruffled edges make them look like big cabbages.\n",
                "The Elkhorn has to be one of the most striking types of coral reef species. \n" +
                        "Its spectacular antler-like features stand out from other types of coral reef species, and are an impressive sight for any snorkeler or diver.\n",
                "The stunning Carnation Coral species can be found on coral reefs around the Red Sea, Indian Ocean and the Western Pacific.\n" +
                        "The Carnation Coral thrives in areas with strong current, and usually grow on walls or underneath rocky overhangs.\n",
                "Bubble Coral is one of the most intriguing types of coral reef species.\n" +
                        "Usually found in sheltered areas at depths of 3-35 meters, the Bubble Coral is often mistaken for fish eggs.\n",
                "One of the most elegant types of coral reef species, is the Gorgonian Sea Fan.\n" +
                        " Found predominantly in the Bahamas and the West Indies, this beautiful soft coral is made up of an intricate network of branchlets which grow from a small base.\n"};
        int[] imgArr = {R.drawable.staghorn_big,R.drawable.leaf_big,R.drawable.elkhorn_big,R.drawable.carnation_big,R.drawable.bubble_big,R.drawable.gorgonian_big};
        Bundle bundle = new Bundle();
        bundle.putString("description",strArr[pos]);
        bundle.putInt("image",imgArr[pos]);
        getParentFragmentManager().setFragmentResult("bundle",bundle);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.moveToSecondFrag();

    }

}