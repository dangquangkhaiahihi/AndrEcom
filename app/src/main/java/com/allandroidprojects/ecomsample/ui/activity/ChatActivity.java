package com.allandroidprojects.ecomsample.ui.activity;

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

        webSocketManager = new WebSocketManager(this);
        webSocketManager.requestChatHistory();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = username+ ": " + messageEditText.getText().toString();
                if (!message.isEmpty()) {
                    webSocketManager.sendMessage("You: " + message);
                    messageEditText.setText("");

                    showMessage(message);
                }
            }
        });
    }

    // Display a message in chatTextView
    public void showMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Append the new message to the existing text
                chatTextView.append(message + "\n");
            }
        });
    }
    // Display the chat history in chatTextView
    public void showChatHistory(final String chatHistory) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                chatTextView.setText(chatHistory);
            }
        });
    }

    // Method to display a message received from the server
    public void showAdminMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                chatTextView.append("Admin: " + message + "\n");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webSocketManager.closeConnection();
    }
}
