package com.allandroidprojects.ecomsample.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.ProductDao;
import com.allandroidprojects.ecomsample.model.Product;
import com.allandroidprojects.ecomsample.ui.activity.ItemDetailsActivity;
import com.allandroidprojects.ecomsample.ui.activity.MainActivity;
import com.allandroidprojects.ecomsample.utility.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class ImageListFragment extends Fragment {

    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";
    private static MainActivity mActivity;

    public static List<Product> productlist;

    private AppDatabase mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.layout_recylerview_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        mDb = AppDatabase.getInMemoryDatabase(getContext().getApplicationContext());
        ProductDao productDao = mDb.getProductDAO();

        if (ImageListFragment.this.getArguments().getInt("type") == 1) {
            productlist = productDao.getItemByCategory("dog");
        } else if (ImageListFragment.this.getArguments().getInt("type") == 2) {
            productlist = productDao.getItemByCategory("cat");
        }
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(recyclerView, productlist));
    }


    // adapter to be changed.
    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private RecyclerView mRecyclerView;
        private List<Product> productdetials;

        // class viewholder of android;
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final SimpleDraweeView mImageView;
            public final LinearLayout mLayoutItem;
            public final ImageView mImageViewWishlist;
            public final TextView textView;
            public final TextView textViewDesc;
            public final TextView textViewPrice;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (SimpleDraweeView) view.findViewById(R.id.image1);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
                mImageViewWishlist = (ImageView) view.findViewById(R.id.ic_wishlist);
                textView = (TextView) view.findViewById(R.id.list_item_name);
                textViewDesc = (TextView) view.findViewById(R.id.list_item_Desc);
                textViewPrice = (TextView) view.findViewById(R.id.list_item_price);

            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, List<Product> products) {
            mRecyclerView = recyclerView;
            productdetials = products;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onViewRecycled(ViewHolder holder) {
            if (holder.mImageView.getController() != null) {
                holder.mImageView.getController().onDetach();
            }
            if (holder.mImageView.getTopLevelDrawable() != null) {
                holder.mImageView.getTopLevelDrawable().setCallback(null);
            }
        }

        @SuppressLint("RecyclerView")
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            final Uri uri = Uri.parse(productdetials.get(position).getItemImageUrl());
            holder.mImageView.setImageURI(uri);

            final String name = productdetials.get(position).getItemName();
            final String price = productdetials.get(position).getItemPrice();
            final String desc = productdetials.get(position).getItemDesc();
            final String category = productdetials.get(position).getCategory();
            final String id = productdetials.get(position).getId().toString();
            final String phone = productdetials.get(position).getPhone();

            holder.textView.setText(name);
            holder.textViewDesc.setText(desc);
            holder.textViewPrice.setText(price);

            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, ItemDetailsActivity.class);
                    intent.putExtra(STRING_IMAGE_URI, productdetials.get(position).getItemImageUrl());
                    intent.putExtra(STRING_IMAGE_POSITION, position);
                    intent.putExtra("name", name);
                    intent.putExtra("price", price);
                    intent.putExtra("desc", desc);
                    intent.putExtra("category", category);
                    intent.putExtra("id", id);
                    intent.putExtra("phone", phone);

                    mActivity.startActivity(intent);
                }
            });

            //Set click action for wishlist
            holder.mImageViewWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                    imageUrlUtils.addWishlistImageUri(productdetials.get(position).getItemImageUrl());

                    Product product = new Product();
                    product.setWishList(productdetials.get(position));
                    holder.mImageViewWishlist.setImageResource(R.drawable.ic_favorite_black_18dp);
                    notifyDataSetChanged();
                    Toast.makeText(mActivity, "Item added to Wishlist.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return productdetials.size();
        }
    }
}
