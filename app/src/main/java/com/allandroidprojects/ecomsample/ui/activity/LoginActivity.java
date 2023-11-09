package com.allandroidprojects.ecomsample.ui.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.LogedInUser;
import com.allandroidprojects.ecomsample.dao.UserDao;
import com.allandroidprojects.ecomsample.model.User;

public class LoginActivity extends AppCompatActivity {
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        TextView register = (TextView) findViewById(R.id.registerclick);

        EditText txtUrname = (EditText) findViewById(R.id.txtUrname);
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        CardView view = (CardView) findViewById(R.id.btnlogin);

        view.setOnClickListener(v -> {
            String username = txtUrname.getText().toString();
            String password = txtPassword.getText().toString();
            mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
            UserDao userDao = mDb.getUserDAO();
            User user = userDao.searchByUsername(username);
            if (user == null) return;

            if(password.equals(user.getPassword())) {
                LogedInUser.setUser(user);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("cus_name", user.getFullname());
                startActivity(intent);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }
}
