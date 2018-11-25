package com.example.fikridzakwan.sunrise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailSunrise extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sunrise);
        ButterKnife.bind(this);

        txtTitle.setText(getIntent().getStringExtra("NG"));
        Glide.with(this).load(getIntent().getIntExtra("GG",0)).into(imgLogo);
    }
}
