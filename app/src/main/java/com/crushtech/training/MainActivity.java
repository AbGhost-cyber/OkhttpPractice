package com.crushtech.training;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.crushtech.training.mvp.Contract;
import com.crushtech.training.mvp.Model;
import com.crushtech.training.mvp.Presenter;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements Contract.View {
    TextView textString;
    Presenter presenter;
    ProgressBar progressBar;
    MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textString = findViewById(R.id.my_text);
        presenter = new Presenter(this, new Model());
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.btn);

        button.setOnClickListener(v -> {
            presenter.onButtonClick();
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textString.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        textString.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(String string) {
        textString.setText(string);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}