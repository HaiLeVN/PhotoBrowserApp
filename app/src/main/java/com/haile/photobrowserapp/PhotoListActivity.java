package com.haile.photobrowserapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haile.photobrowserapp.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        photoList = loadPhotos(); // Method to load photos

        PhotoAdapter adapter = new PhotoAdapter(photoList, this::openPhotoDetail);
        recyclerView.setAdapter(adapter);
    }

    private List<String> loadPhotos() {
        // Simulate photo URLs
        List<String> photos = new ArrayList<>();
        photos.add("https://images.nightcafe.studio/jobs/2miPllkuOBajZj3hdHgj/2miPllkuOBajZj3hdHgj--3--t2uyw.jpg?tr=w-1600,c-at_max");
        photos.add("https://images.nightcafe.studio/jobs/2miPllkuOBajZj3hdHgj/2miPllkuOBajZj3hdHgj--2--e1xwn.jpg?tr=w-1600,c-at_max");
        photos.add("https://images.nightcafe.studio/jobs/oki3HnrJt8mltmLQrgSY/oki3HnrJt8mltmLQrgSY--2--nya5q.jpg?tr=w-1600,c-at_max");
        photos.add("https://images.nightcafe.studio/jobs/EPHzaxGieEJlZ9uitrE4/EPHzaxGieEJlZ9uitrE4--1--7vkww.jpg?tr=w-1600,c-at_max");
        photos.add("https://images.nightcafe.studio/jobs/0rn9nIvfOa3IFDmlGVu3/0rn9nIvfOa3IFDmlGVu3--4--mpw6b_6x.jpg?tr=w-1600,c-at_max");
        photos.add("https://images.nightcafe.studio/jobs/0EV8fyaCothN9M38KxCc/0EV8fyaCothN9M38KxCc--1--ajv8t.jpg?tr=w-1600,c-at_max");
        return photos;
    }

    private void openPhotoDetail(String photoUrl) {
        Intent intent = new Intent(PhotoListActivity.this, PhotoDetailActivity.class);
        intent.putExtra("photo_url", photoUrl);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int position = layoutManager.findFirstVisibleItemPosition();
        outState.putInt("scroll_position", position);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt("scroll_position");
            recyclerView.scrollToPosition(position);
        }
    }
}
