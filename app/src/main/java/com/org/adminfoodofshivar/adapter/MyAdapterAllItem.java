package com.org.adminfoodofshivar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.org.adminfoodofshivar.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapterAllItem extends FirebaseRecyclerAdapter<Model,MyAdapterAllItem.MyviewHolder> {


    public MyAdapterAllItem(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyviewHolder holder, int position, @NonNull Model model) {

        holder.name_item_cart.setText(model.getName());
        holder.Food_price.setText(model.getPrice());
        Glide.with(holder.image_pending.getContext()).load(model.getImage()).into(holder.image_pending);




    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new MyviewHolder(view);

    }


    class MyviewHolder extends RecyclerView.ViewHolder{

        ImageView image_pending,button_remove,button_add,button_delete;
        TextView name_item_cart,Food_price,count_item;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            image_pending=(ImageView)itemView.findViewById(R.id.image_pending);
            button_remove=(ImageView)itemView.findViewById(R.id.button_remove);
            button_add=(ImageView)itemView.findViewById(R.id.button_add);
            button_delete=(ImageView)itemView.findViewById(R.id.button_delete);
            name_item_cart=(TextView)itemView.findViewById(R.id.name_item_cart);
            Food_price=(TextView)itemView.findViewById(R.id.Food_price);
            count_item=(TextView)itemView.findViewById(R.id.count_item);
        }
    }
}
