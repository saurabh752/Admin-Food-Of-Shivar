package com.org.adminfoodofshivar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.adminfoodofshivar.R;

import java.util.List;

public class MyAdapterDelivery extends RecyclerView.Adapter<MyViewHolderdelivery>{

    Context context;
    List<Myitemdelivery> Myitemdelivery;

    public MyAdapterDelivery(Context context, List<com.org.adminfoodofshivar.adapter.Myitemdelivery> myitemdelivery) {
        this.context = context;
        Myitemdelivery = myitemdelivery;
    }

    @NonNull
    @Override
    public MyViewHolderdelivery onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderdelivery(LayoutInflater.from(context).inflate(R.layout.out_for_delivery_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderdelivery holder, int position) {
        Myitemdelivery currentItem = Myitemdelivery.get(position);

        holder.name_item.setText(Myitemdelivery.get(position).getName_item());
        holder.payment_name.setText(Myitemdelivery.get(position).getPayment_name());
        holder.not_Received.setText(Myitemdelivery.get(position).getNot_Received());
        holder.Delivered_name.setText(Myitemdelivery.get(position).getDelivered_name());
        holder.card_color.setCardBackgroundColor(Myitemdelivery.get(position).getCard_color());


        int cardColor = 0;


        if ("Pending".equals(currentItem.getNot_Received())) {
            cardColor = context.getResources().getColor(R.color.black);
        } else if ("Received".equals(currentItem.getNot_Received())) {
            cardColor = context.getResources().getColor(R.color.text_color);
        } else if ("Not Received".equals(currentItem.getNot_Received())) {
            cardColor = context.getResources().getColor(R.color.not_received_card_color);
        }

        holder.card_color.setCardBackgroundColor(cardColor);



    }

    @Override
    public int getItemCount() {
        return Myitemdelivery.size();
    }
}
