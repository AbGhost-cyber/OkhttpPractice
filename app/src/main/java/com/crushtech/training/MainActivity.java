package com.crushtech.training;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Goods> goodsArrayList;
    RecyclerView recyclerView;
    GoodsAdapter goodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvGoods);
        goodsArrayList = new ArrayList<>();
        setupRecyclerView();
    }

    public void setupRecyclerView() {
        setupDataItems();
        goodsAdapter = new GoodsAdapter(goodsArrayList);
        recyclerView.setAdapter(goodsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
    }

    public void setupDataItems() {
        goodsArrayList.add(new Goods("6 pounds of turkey Fish", "gd123333333", 100));
        goodsArrayList.add(new Goods("100kg of Meat", "gd123333334", 10));
        goodsArrayList.add(new Goods("15 crated of eggs", "gd123333335", 80));
        goodsArrayList.add(new Goods("20 packs of noodles", "gd123333336", 52));
        goodsArrayList.add(new Goods("a cartoon of can drinks", "gd123333337", 11));
        goodsArrayList.add(new Goods("2 gallons of vegetable oil", "gd123333338", 70));
    }


    static class Goods {
        String name, goodId;
        int price;

        Goods(String name, String goodId, int price) {
            this.name = name;
            this.price = price;
            this.goodId = goodId;
        }
    }
}