package com.example.cathaymovie;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PageFragment extends Fragment {

    private String fileName;
    private RecycleViewAdapter recycleViewAdapter;
    private RecyclerView recyclerView;
    private ReadFile readFile;

    public PageFragment(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        recyclerView = view.findViewById(R.id.movie_list_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        readFile = new ReadFile(fileName, getContext());
        recycleViewAdapter = new RecycleViewAdapter(readFile.getJson());
        recyclerView.setAdapter(recycleViewAdapter);

    }
}
