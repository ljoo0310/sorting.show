package com.example.yehoon.sorting_show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LogFragment extends Fragment {

    LogAdapter adapter;
    RecyclerView recyclerView;
    View emptyView;
    public List<String> fullLogList = new ArrayList<>();



    public static LogFragment newInstance() {
        LogFragment fragment = new LogFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_log, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.logrecyclerview);
        emptyView = rootView.findViewById(R.id.empty_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        adapter = new LogAdapter(new ArrayList<String>());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public void addLog(final String log) {
        emptyView.setVisibility(View.GONE);
        fullLogList.add(log);
        adapter.addLog(log);
    }

    public void clearLog() {
        if (adapter != null)
            adapter.clearLog();
        if (emptyView != null)
            emptyView.setVisibility(View.VISIBLE);
    }

    public List<String> getFullLogList(){
        return fullLogList;
    }



}
