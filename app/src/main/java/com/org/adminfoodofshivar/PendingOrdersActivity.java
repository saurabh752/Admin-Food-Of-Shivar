package com.org.adminfoodofshivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.org.adminfoodofshivar.adapter.MyAdapterPending;
import com.org.adminfoodofshivar.adapter.MyItemPending;

import java.util.ArrayList;
import java.util.List;

public class PendingOrdersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);
        recyclerView =findViewById(R.id.recyclerView);
        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        List<MyItemPending> MyItemPending = new ArrayList<>();
        MyItemPending.add(new MyItemPending(R.drawable.menu2,"Saurabh Mane","Quantity","2","Accept"));
        MyItemPending.add(new MyItemPending(R.drawable.menu3,"Rutik","Quantity","5","Accept"));
        MyItemPending.add(new MyItemPending(R.drawable.menu2,"Sagar","Quantity","8","Accept"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapterPending adapter = new MyAdapterPending(this, MyItemPending);
        recyclerView.setAdapter(adapter);
    }
}