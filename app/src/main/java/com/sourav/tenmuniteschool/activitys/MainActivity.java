package com.sourav.tenmuniteschool.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sourav.tenmuniteschool.R;
import com.sourav.tenmuniteschool.adapters.HomeMainAdapter;
import com.sourav.tenmuniteschool.modes.HomeMainList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView homeMainRv;
    HomeMainAdapter homeMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeMainRv = findViewById(R.id.homeMainRv);
        homeMainRv.setLayoutManager(new LinearLayoutManager(this));

        homeMainAdapter = new HomeMainAdapter(this, getHomeList());
        homeMainRv.setAdapter(homeMainAdapter);


    }

    private ArrayList<HomeMainList> getHomeList() {
        ArrayList<HomeMainList> homeMainItemList = new ArrayList<>();

        HomeMainList homeMainItem = new HomeMainList("Chapter");
        homeMainItemList.add(homeMainItem);

        homeMainItem = new HomeMainList("Video");
        homeMainItemList.add(homeMainItem);

        homeMainItem = new HomeMainList("Document");
        homeMainItemList.add(homeMainItem);

        homeMainItem = new HomeMainList("Audio");
        homeMainItemList.add(homeMainItem);

        return homeMainItemList;
    }


}