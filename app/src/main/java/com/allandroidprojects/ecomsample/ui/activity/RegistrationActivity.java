package com.allandroidprojects.ecomsample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.UserDao;
import com.allandroidprojects.ecomsample.model.User;

public class RegistrationActivity extends AppCompatActivity {
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView login = (TextView) findViewById(R.id.txtlogintext);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });


        Button register = (Button) findViewById(R.id.btnRegister);
//        register.setOnClickListener(new View.OnClickListener(){
//
//            public void onClick(View view)
//            {
//                EditText txtUrname = (EditText) findViewById(R.id.txtUserName);
//                EditText txtPassword = (EditText) findViewById(R.id.txtPasswordReg);
//                EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
//                EditText txtFullname = (EditText) findViewById(R.id.txtFname);
//
//                String email = txtEmail.getText().toString();
//                String fullname = txtFullname.getText().toString();
//                String username = txtUrname.getText().toString();
//                String password = txtPassword.getText().toString();
//
//                User user = new User(email, fullname, username, password);
//
//                mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
//                UserDao userDao = mDb.getUserDAO();
//                userDao.insert(user);
//
//                Toast.makeText(RegistrationActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
//            }
//        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText txtUrname = (EditText) findViewById(R.id.txtUserName);
                EditText txtPassword = (EditText) findViewById(R.id.txtPasswordReg);
                EditText txtRePassword = (EditText) findViewById(R.id.txtRePassword); // Added for Re-password
                EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
                EditText txtFullname = (EditText) findViewById(R.id.txtFname);

                String email = txtEmail.getText().toString();
                String fullname = txtFullname.getText().toString();
                String username = txtUrname.getText().toString();
                String password = txtPassword.getText().toString();
                String rePassword = txtRePassword.getText().toString(); // Added for Re-password

                // Check if any field is empty
                if (email.isEmpty() || fullname.isEmpty() || username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution if any field is empty
                }

                // Check if passwords match
                if (!password.equals(rePassword)) {
                    Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution if passwords don't match
                }

                User user = new User(email, fullname, username, password);

                mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
                UserDao userDao = mDb.getUserDAO();
                userDao.insert(user);

                Toast.makeText(RegistrationActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });


    }
}
