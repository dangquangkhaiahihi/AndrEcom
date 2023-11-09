package com.allandroidprojects.ecomsample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.allandroidprojects.ecomsample.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatActivity extends AppCompatActivity {
    private EditText messageEditText;
    private Button sendButton;
    private TextView chatTextView;

    private TextView senderTextView;
    private String username;
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        messageEditText = (EditText) findViewById(R.id.messageEditText);
        sendButton = (Button) findViewById(R.id.sendButton);
        chatTextView = (TextView) findViewById(R.id.chatTextView);
        senderTextView = (TextView) findViewById(R.id.sender_name);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        senderTextView.setText("Please chat with me if you got some problem " + username);



    }

}
