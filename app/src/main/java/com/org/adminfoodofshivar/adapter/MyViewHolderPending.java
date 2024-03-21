package com.org.adminfoodofshivar.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.adminfoodofshivar.R;

public class MyViewHolderPending extends RecyclerView.ViewHolder {
    ImageView image_pending;
    TextView name_customer,Food_quantity,price,accept_btn;

    public MyViewHolderPending(@NonNull View itemView) {
        super(itemView);
        image_pending=itemView.findViewById(R.id.image_pending);
        name_customer=itemView.findViewById(R.id.name_customer);
        Food_quantity=itemView.findViewById(R.id.Food_quantity);
        price=itemView.findViewById(R.id.price);
        accept_btn=itemView.findViewById(R.id.accept_btn);

    }
}
