package com.example.location_voiture;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
public class FragmentPeugeot extends Fragment {
    private View VoitureView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentPeugeot() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_peugeot, container, false);

        ArrayList<Voiture> exampleList = new ArrayList<>();
        exampleList.add(new Voiture(R.drawable.v308,"Peugeot 308", "67 990 DT"));
        exampleList.add(new Voiture(R.drawable.expert, "Peugeot Expert", "68 990 DT"));
        exampleList.add(new Voiture(R.drawable.partner, "Peugeot Partner", "48 990 DT"));
        exampleList.add(new Voiture(R.drawable.pickup, "PeugeotPickup", "56 900 DT"));
        exampleList.add(new Voiture(R.drawable.traveller, "Peugeot Traveller", "114 990 DT"));
        exampleList.add(new Voiture(R.drawable.v208, "Peugeot 208", "30 380 DT"));
        exampleList.add(new Voiture(R.drawable.v301, "Peugeot 301", "45 990 DT"));
        exampleList.add(new Voiture(R.drawable.v2008, "Peugeot 2008", "72 990 DT"));
        exampleList.add(new Voiture(R.drawable.v3008, "Peugeot 3008", "109 990 DT"));
        exampleList.add(new Voiture(R.drawable.v5008, "Peugeot 5008", "152 990 DT"));
        exampleList.add(new Voiture(R.drawable.boxer, "Peugeot boxer", "72 990 DT"));
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        ExampleAdapter adapter = new ExampleAdapter(exampleList);
        mRecyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);


        return rootView;




    }

}
