package com.allandroidprojects.ecomsample.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.model.Product;
import com.allandroidprojects.ecomsample.model.SearchProduct;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapterActivity extends RecyclerView.Adapter<SearchAdapterActivity.Holderview>{

    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";

    SearchProduct products = new SearchProduct();
    List<Product> productOriginal =  products.getProductList();

    int newposition;


    private List<Product> productlist;
    private Context context;

    public SearchAdapterActivity(List<Product> items, Context context)
    {
        productlist = items;
        this.context = context;
    }
    @Override
    public Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.customitem,parent,false);

        return new Holderview(layout);
    }

    @Override
    public void onBindViewHolder(Holderview holder, @SuppressLint("RecyclerView") final int position) {

//        holder.itemImage.setImageResource(productlist.get(position).getItemImageUrl());
        holder.itemName.setText(productlist.get(position).getItemName());
        holder.itemDesc.setText(productlist.get(position).getItemDesc());
        holder.itemPrice.setText("$ "+ productlist.get(position).getItemPrice());

        for(int i = 0; i < productOriginal.size(); i++)
        {
            String name = productOriginal.get(i).getItemName();
            if(productlist.get(position).getItemName().equals(name))
            {
                newposition = i;
            }
        }

        final String name = productlist.get(position).getItemName();
        final String price = productlist.get(position).getItemPrice();
        final String desc = productlist.get(position).getItemDesc();
        final boolean flag = true;

        holder.linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI, productlist.get(position).getItemImageUrl());
                intent.putExtra(STRING_IMAGE_POSITION, position);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("desc", desc);
                intent.putExtra("flag", flag);
                intent.putExtra("position", newposition);

                context.startActivity(intent);

            }

        });


    }


    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public void setFilter(List<Product> items)
    {
        productlist = new ArrayList<>();
        productlist.addAll(items);
        notifyDataSetChanged();
    }

    class Holderview extends RecyclerView.ViewHolder
    {

        ImageView itemImage;
        TextView itemName;
        TextView itemDesc;
        TextView itemPrice;
        LinearLayout linearLayout;

        Holderview(View itemview)
        {
            super(itemview);

            itemImage = (ImageView) itemview.findViewById(R.id.search_image);
            itemName = (TextView) itemview.findViewById(R.id.search_name);
            itemDesc = (TextView) itemview.findViewById(R.id.search_desc);
            itemPrice = (TextView) itemview.findViewById(R.id.search_price);
            linearLayout = (LinearLayout) itemview.findViewById(R.id.Search_layout);
        }
    }
}
