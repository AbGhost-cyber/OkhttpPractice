package com.crushtech.training.mvp;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Model implements Contract.Model {

    @Override
    public void fetchNextData(onFinishedListener onFinishedListener) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://jsonplaceholder.typicode.com/todos/" + generateRandom();
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                onFinishedListener.onFinished(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    JSONObject object = new JSONObject(Objects.requireNonNull(response.body()).string());
                    String title = object.getString("title");
                    new Handler(Looper.getMainLooper()).postDelayed(() ->
                            onFinishedListener.onFinished(title), 1300);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //btw 1 and 200
    private int generateRandom() {
        Random random = new Random();
        return 1 + random.nextInt((200 - 1) + 1);
    }
}
