package com.example.freshmart.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freshmart.Interface.ItemClickListener;
import com.example.freshmart.Model.Carts;
import com.example.freshmart.R;

import java.util.List;

public class CartViewHolder extends RecyclerView.Adapter<CartViewHolder.ViewHolder> {

    private Context context;
    private List<Carts> showCart_modelList;

    public CartViewHolder(Context context, List<Carts> showCart_models){
        this.context=context;
        this.showCart_modelList=showCart_models;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_order,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Carts carts=showCart_modelList.get(position);
        holder.product_name.setText(carts.getProduct_name());
        holder.price.setText(carts.getProduct_price());
        holder.quantity.setText(carts.getProduct_quanitiy());

    }

    @Override
    public int getItemCount() {

        return showCart_modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private  TextView product_name, price, quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            product_name=itemView.findViewById(R.id.product_name);
            price=itemView.findViewById(R.id.price);
            quantity=itemView.findViewById(R.id.qty);


        }
    }
}
