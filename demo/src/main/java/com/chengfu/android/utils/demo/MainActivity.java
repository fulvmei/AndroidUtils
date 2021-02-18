package com.chengfu.android.utils.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chengfu.android.utils.demo.bean.MainItem;
import com.chengfu.android.utils.demo.ui.main.MainItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainItemAdapter mainItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mainItemAdapter = new MainItemAdapter();
        mainItemAdapter.submitList(getMainItemList());
        recyclerView.setAdapter(mainItemAdapter);
    }

    private List<MainItem> getMainItemList() {
        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem("ColorUtils", "颜色相关工具类", ColorUtilsDemoActivity.class));
        mainItems.add(new MainItem("DensityUtils", "单位转换工具类", DensityUtilsDemoActivity.class));
        mainItems.add(new MainItem("ScreenUtils", "屏幕相关工具类", ScreenUtilsDemoActivity.class));
        return mainItems;
    }
}