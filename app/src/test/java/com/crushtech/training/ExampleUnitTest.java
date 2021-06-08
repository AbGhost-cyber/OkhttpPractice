package com.crushtech.training;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void whenSetFollowRedirects_thenNotRedirected()
            throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();

        Request request = new Request.Builder()
                .url("http://t.co/I5YYd9tddw")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertEquals(response.code(), 301);
    }
}