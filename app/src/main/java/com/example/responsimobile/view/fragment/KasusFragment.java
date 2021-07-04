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
import com.example.responsimobile.adapter.KasusAdapter;
import com.example.responsimobile.model.ContentItemDataHarian;
import com.example.responsimobile.viewmodel.DataHarianViewModel;

import java.util.ArrayList;


public class KasusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //menghubungkan ke layout activity main
    private RecyclerView recyclerView;
    private KasusAdapter kasusAdapter;
    private DataHarianViewModel dataHarianViewModel;
    //data yg akan ditampilkan adapter ke recycler

    public KasusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kasusAdapter = new KasusAdapter(getContext());
        kasusAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rv_data);
        dataHarianViewModel = new ViewModelProvider(this).get(DataHarianViewModel.class);
        dataHarianViewModel.setItemDataHarian();
        dataHarianViewModel.getResponseData().observe(getViewLifecycleOwner(), getResponseData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(kasusAdapter);
    }

    private Observer<ArrayList<ContentItemDataHarian>> getResponseData = new Observer<ArrayList<ContentItemDataHarian>>() {
        @Override
        public void onChanged(ArrayList<ContentItemDataHarian> contentItemDataHarians) {
            if(dataHarianViewModel != null){
                kasusAdapter.setData(contentItemDataHarians);
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}