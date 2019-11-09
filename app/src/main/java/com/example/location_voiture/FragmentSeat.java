package com.example.location_voiture;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentSeat extends Fragment {
    private View VoitureView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_seat, container, false);

        ArrayList<Voiture> exampleList = new ArrayList<>();
        exampleList.add(new Voiture(R.drawable.ibiza, "SEAT IBIZA", "48 980 DT"));
        exampleList.add(new Voiture(R.drawable.ibizapop, "IBIZA POPULAIRE", "29 640 DT"));
        exampleList.add(new Voiture(R.drawable.leon, "SEAT LEON", "63 480 DT"));
        exampleList.add(new Voiture(R.drawable.arona, "SEAT ARONA", "65 480 DT"));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        ExampleAdapter adapter = new ExampleAdapter(exampleList);
        mRecyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);


        return rootView;

    }
}

