package com.allandroidprojects.ecomsample.ui.activity;// Đoạn mã trong file ChatActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.socket.WebSocketManager;

public class ChatActivity extends AppCompatActivity {
    private EditText messageEditText;
    private Button sendButton;
    private TextView chatTextView;

    private TextView senderTextView;
    private String username;
    private WebSocketManager webSocketManager;

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

        webSocketManager = new WebSocketManager(this); // Truyền ChatActivity vào WebSocketManager

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();
                if (!message.isEmpty()) {
                    webSocketManager.sendMessage(message);
                    messageEditText.setText("");

                    // Hiển thị tin nhắn ngay lập tức trên TextView
                    showMessage("You: " + message);
                }
            }
        });
    }

    // Phương thức để hiển thị tin nhắn trên TextViewHiH
    public void showMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                chatTextView.append(message + "\n");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webSocketManager.closeConnection();
    }
}
