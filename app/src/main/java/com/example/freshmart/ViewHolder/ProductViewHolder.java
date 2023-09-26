
package com.example.freshmart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshmart.Interface.ItemClickListener;
import com.example.freshmart.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName, txtProductDescription;
    //public ImageView imageView;
    public ItemClickListener listener;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);


        //imageView= (ImageView) itemView.findViewById(R.id.product_image);
        txtProductName=(TextView)itemView.findViewById(R.id.product_name);
        txtProductDescription=(TextView) itemView.findViewById(R.id.product_description);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        listener.onClick(view, getAbsoluteAdapterPosition());
    }
}
