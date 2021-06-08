package com.crushtech.training;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public String url = "https://raw.github.com/square/okhttp/master/README.md";
    //    ArrayList<Goods> goodsArrayList;
//    RecyclerView recyclerView;
//    GoodsAdapter goodsAdapter;
    TextView textString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textString = findViewById(R.id.my_text);

        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        recyclerView = findViewById(R.id.rvGoods);
//        goodsArrayList = new ArrayList<>();
//        setupRecyclerView();
    }

    void run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call requestCall = client.newCall(request);

        requestCall.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                call.cancel();
            }


            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String res = Objects.requireNonNull(response.body()).string();
                MainActivity.this.runOnUiThread(() -> {
                    textString.setText(res);
                });
            }
        });
    }

//    public void setupRecyclerView() {
//        setupDataItems();
//        goodsAdapter = new GoodsAdapter(goodsArrayList);
//        recyclerView.setAdapter(goodsAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
//                DividerItemDecoration.VERTICAL));
//    }

//    public void setupDataItems() {
//        goodsArrayList.add(new Goods("6 pounds of turkey Fish", "gd123333333", 100));
//        goodsArrayList.add(new Goods("100kg of Meat", "gd123333334", 10));
//        goodsArrayList.add(new Goods("15 crated of eggs", "gd123333335", 80));
//        goodsArrayList.add(new Goods("20 packs of noodles", "gd123333336", 52));
//        goodsArrayList.add(new Goods("a cartoon of can drinks", "gd123333337", 11));
//        goodsArrayList.add(new Goods("2 gallons of vegetable oil", "gd123333338", 70));
//    }


//    static class Goods {
//        String name, goodId;
//        int price;
//
//        Goods(String name, String goodId, int price) {
//            this.name = name;
//            this.price = price;
//            this.goodId = goodId;
//        }
//    }
}