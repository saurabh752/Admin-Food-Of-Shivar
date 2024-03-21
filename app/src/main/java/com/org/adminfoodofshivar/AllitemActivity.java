package com.org.adminfoodofshivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.org.adminfoodofshivar.adapter.Model;
import com.org.adminfoodofshivar.adapter.MyAdapterAllItem;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AllitemActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapterAllItem myAdapterAllItem;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allitem);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"), Model.class)
                        .build();
        myAdapterAllItem = new MyAdapterAllItem(options);
        recyclerView.setAdapter(myAdapterAllItem);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapterAllItem.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapterAllItem.stopListening();
    }


}