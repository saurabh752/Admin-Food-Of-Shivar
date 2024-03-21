package com.org.adminfoodofshivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.org.adminfoodofshivar.adapter.MyAdapterDelivery;
import com.org.adminfoodofshivar.adapter.Myitemdelivery;

import java.util.ArrayList;
import java.util.List;

public class OutForDeliveryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_for_delivery);
        recyclerView = findViewById(R.id.recyclerView);
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
        List<Myitemdelivery> Myitemdelivery = new ArrayList<>();
        Myitemdelivery.add(new Myitemdelivery("saurabh","Payment","Received","delivered",R.color.text_color));
        Myitemdelivery.add(new Myitemdelivery("Rutik","Payment","Not Received","delivered",R.color.not_received_card_color));

        Myitemdelivery.add(new Myitemdelivery("sagar","Payment","Pending","delivered",R.color.black));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapterDelivery adapter = new MyAdapterDelivery(this, Myitemdelivery);
        recyclerView.setAdapter(adapter);
    }
}