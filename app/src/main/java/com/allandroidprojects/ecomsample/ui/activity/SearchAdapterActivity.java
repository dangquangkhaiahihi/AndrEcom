package com.allandroidprojects.ecomsample.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.ProductDao;
import com.allandroidprojects.ecomsample.model.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapterActivity extends RecyclerView.Adapter<SearchAdapterActivity.Holderview> {

    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";

    private List<Product> productOriginal;
    private Context context;

    private AppDatabase mDb;

    public SearchAdapterActivity(List<Product> items, Context context) {
        productOriginal = items;
        this.context = context;
    }

    @Override
    public Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.customitem, parent, false);

        return new Holderview(layout);
    }

    @Override
    public void onBindViewHolder(Holderview holder, @SuppressLint("RecyclerView") final int position) {

        mDb = AppDatabase.getInMemoryDatabase(context.getApplicationContext());

        final String name = productOriginal.get(position).getItemName();
        final String price = productOriginal.get(position).getItemPrice();
        final String desc = productOriginal.get(position).getItemDesc();
        final Uri uri = Uri.parse(productOriginal.get(position).getItemImageUrl());
        final String category = productOriginal.get(position).getCategory();
        final String id = productOriginal.get(position).getId().toString();
        final String phone = productOriginal.get(position).getPhone();

        holder.itemImage.setImageURI(uri);
        holder.itemName.setText(name);
        holder.itemDesc.setText(desc);
        holder.itemPrice.setText(price);

        final boolean flag = true;

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI, productOriginal.get(position).getItemImageUrl());
                intent.putExtra(STRING_IMAGE_POSITION, position);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("desc", desc);
                intent.putExtra("category", category);
                intent.putExtra("id", id);
                intent.putExtra("phone", phone);

                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return productOriginal.size();
    }

    public void setFilter(List<Product> items) {
        productOriginal = new ArrayList<>();
        productOriginal.addAll(items);
        notifyDataSetChanged();
    }

    class Holderview extends RecyclerView.ViewHolder {
        SimpleDraweeView itemImage;
        TextView itemName;
        TextView itemDesc;
        TextView itemPrice;
        LinearLayout linearLayout;

        Holderview(View itemview) {
            super(itemview);
            itemImage = (SimpleDraweeView) itemview.findViewById(R.id.search_image);
            itemName = (TextView) itemview.findViewById(R.id.search_name);
            itemDesc = (TextView) itemview.findViewById(R.id.search_desc);
            itemPrice = (TextView) itemview.findViewById(R.id.search_price);
            linearLayout = (LinearLayout) itemview.findViewById(R.id.Search_layout);
        }
    }
}
