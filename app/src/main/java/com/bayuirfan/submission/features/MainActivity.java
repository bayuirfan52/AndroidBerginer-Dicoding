package com.bayuirfan.submission.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bayuirfan.submission.R;
import com.bayuirfan.submission.adapter.MainRecyclerViewAdapter;
import com.bayuirfan.submission.data.MainData;
import com.bayuirfan.submission.data.Series;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Series> seriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponent();
        showData();
    }

    private void setupComponent(){
        recyclerView = findViewById(R.id.rv_main_list);
        recyclerView.setHasFixedSize(true);
        seriesList.addAll(MainData.getSeries());
    }

    private void showData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(this);
        adapter.setList(seriesList);
        recyclerView.setAdapter(adapter);
    }
}
