package com.org.adminfoodofshivar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.adminfoodofshivar.R;

import java.util.List;

public class MyAdapterPending extends RecyclerView.Adapter<MyViewHolderPending>{

    Context context;
    List<MyItemPending> MyItemPending;

    public MyAdapterPending(Context context, List<com.org.adminfoodofshivar.adapter.MyItemPending> myItemPending) {
        this.context = context;
        MyItemPending = myItemPending;
    }

    @NonNull
    @Override
    public MyViewHolderPending onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderPending(LayoutInflater.from(context).inflate(R.layout.pending_orders_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPending holder, int position) {
        holder.image_pending.setImageResource(MyItemPending.get(position).getImage_pending());
        holder.name_customer.setText(MyItemPending.get(position).getName_customer());
        holder.Food_quantity.setText(MyItemPending.get(position).getFood_quantity());
        holder.price.setText(MyItemPending.get(position).getPrice());
        holder.accept_btn.setText(MyItemPending.get(position).getAccept_btn());

        holder.accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAccepted = MyItemPending.get(position).isAccepted();
                if (isAccepted) {
                    showToast("Order is dispatched");
                    // Assuming you want to remove the item when accepted
                    MyItemPending.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, MyItemPending.size());
                } else {
                    showToast("Order is accepted");
                    MyItemPending.get(position).setAccepted(true);
                    // You might want to update the button text or perform other actions
                    notifyDataSetChanged();
                }
            }
        });

    }






    @Override
    public int getItemCount() {
        return MyItemPending.size();
    }
    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
