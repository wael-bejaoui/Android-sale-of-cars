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

public class FragmentVolkswagen extends Fragment {
    private View VoitureView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_volkswagen, container, false);

        ArrayList<Voiture> exampleList = new ArrayList<>();

        exampleList.add(new Voiture(R.drawable.up,"Volkswagen UP", "44 980 DT"));
        exampleList.add(new Voiture(R.drawable.polo, "Volkswagen POLO", "50 980 DT"));
        exampleList.add(new Voiture(R.drawable.polo_sedan, "Volkswagen POLO SEDAN", "54 980 DT"));
        exampleList.add(new Voiture(R.drawable.golf7, "Volkswagen GOLF7", "77 980 DT"));
        exampleList.add(new Voiture(R.drawable.jetta, "Volkswagen JETTA", "94 980 DT"));
        exampleList.add(new Voiture(R.drawable.passat, "Volkswagen PASSAT", "109 980 DT"));
        exampleList.add(new Voiture(R.drawable.tiguan, "Volkswagen TIGUAN", "128 980 DT"));
        exampleList.add(new Voiture(R.drawable.tuareg, "Volkswagen TWAREG", "379 980 DT"));
        exampleList.add(new Voiture(R.drawable.amarok, "Volkswagen AMAROK", "141 980 DT"));
        exampleList.add(new Voiture(R.drawable.multivan, "Volkswagen MULTIVAN", "249 980 DT"));
        exampleList.add(new Voiture(R.drawable.caddy, "Volkswagen CADDY", "59 980 DT"));
        exampleList.add(new Voiture(R.drawable.transporter, "Volkswagen TRANSPORTER", "68 480 DT"));
        exampleList.add(new Voiture(R.drawable.crafter, "Volkswagen CRAFTER", "101 980 DT"));
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        ExampleAdapter adapter = new ExampleAdapter(exampleList);
        mRecyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);


        return rootView;

    }
}
