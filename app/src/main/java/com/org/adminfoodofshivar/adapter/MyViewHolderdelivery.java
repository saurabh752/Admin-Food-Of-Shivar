package com.org.adminfoodofshivar.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.org.adminfoodofshivar.R;

public class MyViewHolderdelivery extends RecyclerView.ViewHolder{
    TextView name_item,payment_name,not_Received,Delivered_name;
    CardView card_color;
    public MyViewHolderdelivery(@NonNull View itemView) {
        super(itemView);
        name_item=itemView.findViewById(R.id.name_customer);
        payment_name=itemView.findViewById(R.id.payment_name);
        not_Received=itemView.findViewById(R.id.not_Received);
        Delivered_name=itemView.findViewById(R.id.Delivered_name);
        card_color=itemView.findViewById(R.id.card_color);
    }
}
