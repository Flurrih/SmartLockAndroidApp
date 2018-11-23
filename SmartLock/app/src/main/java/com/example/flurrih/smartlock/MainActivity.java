package com.example.flurrih.smartlock;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.flurrih.smartlock.Listeners.ConnectButtonListener;
import com.example.flurrih.smartlock.Networking.SmartLockClient;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {
    SmartLockClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        TextView theTextView = (TextView) findViewById(R.id.textView2);
        Button connectButton = (Button) findViewById(R.id.connectButton);

        connectButton.setOnClickListener(new ConnectButtonListener());

        try {
            startClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void startClient() throws Exception {
        client = new SmartLockClient();
        client.start();
    }
}
