package com.example.responsimobile.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsimobile.R;
import com.example.responsimobile.adapter.RSAdapter;
import com.example.responsimobile.model.DataItemFaskes;
import com.example.responsimobile.viewmodel.RSRujukanViewModel;

import java.util.ArrayList;

public class RSFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //menghubungkan ke layout activity main
    private RecyclerView recyclerView1;
    private RSAdapter rsAdapter;
    private RSRujukanViewModel rsRujukanViewModel;
    //data yg akan ditampilkan adapter ke recycler

    public RSFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rsAdapter = new RSAdapter(getContext());
        rsAdapter.notifyDataSetChanged();

        recyclerView1 = view.findViewById(R.id.rv_faskes);
        rsRujukanViewModel = new ViewModelProvider(this).get(RSRujukanViewModel.class);
        rsRujukanViewModel.setItemFaskes();
        rsRujukanViewModel.getResponseRSRujukan().observe(this, getResponseRSRujukan);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(rsAdapter);
    }

    private Observer<ArrayList<DataItemFaskes>> getResponseRSRujukan = new Observer<ArrayList<DataItemFaskes>>() {
        @Override
        public void onChanged(ArrayList<DataItemFaskes> dataItemFaskes) {
            if(rsRujukanViewModel != null){
                rsAdapter.setData(dataItemFaskes);
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_faskes, container, false);
    }
}