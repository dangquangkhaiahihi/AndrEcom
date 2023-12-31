package com.allandroidprojects.ecomsample.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.LogedInUser;
import com.allandroidprojects.ecomsample.dao.ProductDao;
import com.allandroidprojects.ecomsample.dao.UserDao;
import com.allandroidprojects.ecomsample.fragments.ImageListFragment;
import com.allandroidprojects.ecomsample.model.Product;
import com.allandroidprojects.ecomsample.model.User;
import com.allandroidprojects.ecomsample.notification.NotificationCountSetClass;
import com.allandroidprojects.ecomsample.utility.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ItemDetailsActivity extends AppCompatActivity {
    int position;
    String stringImageUri;

    private static final int CALL_PHONE_PERMISSION_REQUEST_CODE = 123;

    private String name;
    private String price;
    private String desc;
    private String phone;
    private String category;
    private String id;

    List<Product> productitems = new ArrayList<>();

    SearchAdapterActivity adapter;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
        ProductDao productDao = mDb.getProductDAO();

        setContentView(R.layout.activity_item_details);
        SimpleDraweeView mImageView = (SimpleDraweeView) findViewById(R.id.image1);
        TextView textViewAddToCart = (TextView) findViewById(R.id.text_action_bottom1);
        TextView textViewBuyNow = (TextView) findViewById(R.id.text_action_bottom2);
        TextView product_names = (TextView) findViewById(R.id.item_detail_name);
        TextView product_price = (TextView) findViewById(R.id.item_detail_price);
        TextView item_detail_name = (TextView) findViewById(R.id.description_part);

        LinearLayout Desc_Layout = (LinearLayout) findViewById(R.id.text_layout);
        LinearLayout layoutWishList = (LinearLayout) findViewById(R.id.layout_action3);
        LinearLayout layoutPhoneCall = (LinearLayout) findViewById(R.id.layout_phone_call);
        RecyclerView rvApriori = (RecyclerView) findViewById(R.id.rv_apriori);

        layoutWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringImageUri = getIntent().getStringExtra(ImageListFragment.STRING_IMAGE_URI);
                position = getIntent().getIntExtra(ImageListFragment.STRING_IMAGE_POSITION, 0);
                name = getIntent().getStringExtra("name");
                price = getIntent().getStringExtra("price");
                phone = getIntent().getStringExtra("phone");
                desc = getIntent().getStringExtra("desc");

                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addWishlistImageUri(stringImageUri);

                Product product = new Product(name, desc, price, stringImageUri, phone);
                product.setWishList(product);

                Toast.makeText(ItemDetailsActivity.this, "Item added to Wishlist.", Toast.LENGTH_SHORT).show();
            }
        });

        layoutPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePhoneCall();
            }
        });

        //Getting image uri from previous screen
        if (getIntent() != null) {
            stringImageUri = getIntent().getStringExtra(ImageListFragment.STRING_IMAGE_URI);
            position = getIntent().getIntExtra(ImageListFragment.STRING_IMAGE_POSITION, 0);
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            phone = getIntent().getStringExtra("phone");
            desc = getIntent().getStringExtra("desc");
            category = getIntent().getStringExtra("category");

            productitems = productDao.getItemByCategory(category);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rvApriori.setLayoutManager(linearLayoutManager);
            adapter = new SearchAdapterActivity(productitems, ItemDetailsActivity.this);
            rvApriori.setAdapter(adapter);
        }

        product_names.setText(name);
        product_price.setText(price);
        item_detail_name.setText(desc);


        Uri uri = Uri.parse(stringImageUri);
        mImageView.setImageURI(uri);

        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User logedInUser = LogedInUser.getUser();
                String strIdCartItems = logedInUser.getCartItemIdComma();
                List<String> idProductInCart = new ArrayList<>();
                String idStr = getIntent().getStringExtra("id");

                if(strIdCartItems.equals("")) {
                    idProductInCart.add(idStr);
                } else {
                    idProductInCart = new ArrayList<>(Arrays.asList(strIdCartItems.split(",")));
                    idProductInCart.add(idStr);
                }

                String joinedCart = idProductInCart.stream().collect(Collectors.joining(","));
                logedInUser.setCartItemIdComma(joinedCart);
                LogedInUser.setUser(logedInUser);

                mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
                UserDao userDao = mDb.getUserDAO();

                userDao.update(logedInUser);

                Toast.makeText(ItemDetailsActivity.this, "Item added to cart.", Toast.LENGTH_SHORT).show();
                MainActivity.notificationCountCart = idProductInCart.size();
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            }
        });

        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemDetailsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handlePhoneCall() {
        // Check if the CALL_PHONE permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, initiate the call
            makePhoneCall();
        } else {
            // Permission not granted, request it from the user
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    CALL_PHONE_PERMISSION_REQUEST_CODE);
        }
    }

    private void makePhoneCall() {
        // Replace "0559261020" with the actual phone number
        String phoneNumber = "tel:" + phone;

        // Create an implicit intent to make a phone call
        Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));

        // Check if the device can handle the intent
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            // Start the phone call
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions

                Toast.makeText(ItemDetailsActivity.this, "Phone permission denied", Toast.LENGTH_SHORT).show();

                return;
            }
            startActivity(dialIntent);
        }
    }

    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CALL_PHONE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the phone call
                makePhoneCall();
            } else {
                // Permission denied, show a message or handle it accordingly
                Toast.makeText(ItemDetailsActivity.this, "Phone permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
