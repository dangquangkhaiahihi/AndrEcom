package com.allandroidprojects.ecomsample.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.LogedInUser;
import com.allandroidprojects.ecomsample.dao.ProductDao;
import com.allandroidprojects.ecomsample.dao.UserDao;
import com.allandroidprojects.ecomsample.model.Product;
import com.allandroidprojects.ecomsample.model.User;
import com.allandroidprojects.ecomsample.utility.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.allandroidprojects.ecomsample.fragments.ImageListFragment.STRING_IMAGE_POSITION;
import static com.allandroidprojects.ecomsample.fragments.ImageListFragment.STRING_IMAGE_URI;

public class CartListActivity extends AppCompatActivity {
    private static Context mContext;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        mContext = CartListActivity.this;

        ArrayList<Product> productsInCart = new ArrayList<>();

        User logedInUser = LogedInUser.getUser();
        String productInCartStr = logedInUser.getCartItemIdComma();
        Integer totalNum = 0;

        if (!productInCartStr.equals("")) {
            List<Long> idList = new ArrayList<>();

            List<String> idProductInCart = new ArrayList<>(Arrays.asList(productInCartStr.split(",")));

            for (String element : idProductInCart) {
                Long longValue = Long.parseLong(element);
                idList.add(longValue);
            }

            mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
            ProductDao productDao = mDb.getProductDAO();

            for (Long id : idList) {
                Product product = productDao.getItemById(id);
                totalNum += Integer.parseInt(product.getPrice().replace("$", ""));
                productsInCart.add(product);
            }
        }

        TextView textViewTotal = (TextView) findViewById(R.id.text_action_bottom1);
        textViewTotal.setText("$" + totalNum);

        //Show cart layout based on items
        setCartLayout();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager recylerViewLayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(new CartListActivity.SimpleStringRecyclerViewAdapter(recyclerView, productsInCart, totalNum, textViewTotal));
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder> {

        private ArrayList<Product> productsInCart;
        private RecyclerView mRecyclerView;
        private TextView textTotal;
        private AppDatabase mDb;
        private Integer totalNum;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final SimpleDraweeView mImageView;
            public final LinearLayout mLayoutItem, mLayoutRemove , mLayoutEdit;
            public final TextView textViewName, textViewDesc, textViewPrice;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (SimpleDraweeView) view.findViewById(R.id.image_cartlist);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item_desc);
                mLayoutRemove = (LinearLayout) view.findViewById(R.id.layout_action1);
                mLayoutEdit = (LinearLayout) view.findViewById(R.id.layout_action2);
                textViewName = (TextView) view.findViewById(R.id.cardlist_name);
                textViewDesc = (TextView) view.findViewById(R.id.cardlist_desc);
                textViewPrice = (TextView) view.findViewById(R.id.cardlist_price);
            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView,
                                               ArrayList<Product> productsInCart, Integer totalNum, TextView totalTextView) {
            this.mRecyclerView = recyclerView;
            this.productsInCart = productsInCart;
            this.totalNum = totalNum;
            this.textTotal = totalTextView;
        }

        @Override
        public CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cartlist_item, parent, false);
            return new CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onViewRecycled(CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder) {
            if (holder.mImageView.getController() != null) {
                holder.mImageView.getController().onDetach();
            }
            if (holder.mImageView.getTopLevelDrawable() != null) {
                holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
            }
        }

        @Override
        public void onBindViewHolder(final CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final String name = productsInCart.get(position).getItemName();
            final String price = productsInCart.get(position).getItemPrice();
            final String desc = productsInCart.get(position).getItemDesc();
            final String uri = productsInCart.get(position).getItemImageUrl();
            final String category = productsInCart.get(position).getCategory();
            final String id = productsInCart.get(position).getId().toString();
            final String phone = productsInCart.get(position).getPhone();

            holder.textViewName.setText(name);
            holder.textViewDesc.setText(desc);
            holder.textViewPrice.setText(price);
            holder.mImageView.setImageURI(uri);

            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ItemDetailsActivity.class);

                    intent.putExtra(STRING_IMAGE_URI, uri);
                    intent.putExtra(STRING_IMAGE_POSITION, position);
                    intent.putExtra("name", name);
                    intent.putExtra("price", price);
                    intent.putExtra("desc", desc);
                    intent.putExtra("category", category);
                    intent.putExtra("id", id);
                    intent.putExtra("phone", phone);

                    mContext.startActivity(intent);
                }
            });

           //Set click action
            holder.mLayoutRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User logedInUser = LogedInUser.getUser();
                    String strIdCartItems = logedInUser.getCartItemIdComma();
                    List<String> idProductInCart = new ArrayList<>(Arrays.asList(strIdCartItems.split(",")));

                    TextView textViewTotal = (TextView) textTotal.findViewById(R.id.text_action_bottom1);
                    totalNum -= Integer.parseInt(productsInCart.get(position).getPrice().replace("$", ""));
                    textViewTotal.setText("$" + totalNum);

                    idProductInCart.remove(position);
                    productsInCart.remove(position);

                    String joinedCart = idProductInCart.stream().collect(Collectors.joining(","));
                    logedInUser.setCartItemIdComma(joinedCart);
                    LogedInUser.setUser(logedInUser);

                    mDb = AppDatabase.getInMemoryDatabase(mContext.getApplicationContext());
                    UserDao userDao = mDb.getUserDAO();

                    userDao.update(logedInUser);

                    notifyDataSetChanged();
                    //Decrease notification count

                    MainActivity.notificationCountCart--;
                }
            });

            //Set click action
            holder.mLayoutEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        @Override
        public int getItemCount() {
            return productsInCart.size();
        }
    }

    protected void setCartLayout(){
        LinearLayout layoutCartItems = (LinearLayout) findViewById(R.id.layout_items);
        LinearLayout layoutCartPayments = (LinearLayout) findViewById(R.id.layout_payment);
        LinearLayout layoutCartNoItems = (LinearLayout) findViewById(R.id.layout_cart_empty);

        if(MainActivity.notificationCountCart >0){
            layoutCartNoItems.setVisibility(View.GONE);
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        }else {
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartItems.setVisibility(View.GONE);
            layoutCartPayments.setVisibility(View.GONE);

            Button bStartShopping = (Button) findViewById(R.id.bAddNew);
            bStartShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
