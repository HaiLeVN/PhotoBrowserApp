package com.haile.photobrowserapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        ImageView imageView = findViewById(R.id.photoImageView);
        String photoUrl = getIntent().getStringExtra("photo_url");

        Glide.with(this).load(photoUrl).into(imageView);
    }
}
