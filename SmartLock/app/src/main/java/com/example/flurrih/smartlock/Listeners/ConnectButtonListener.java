package com.example.flurrih.smartlock.Listeners;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.flurrih.smartlock.Networking.Client;
import com.example.flurrih.smartlock.R;

public class ConnectButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        TextView tv = (TextView)v.getRootView().findViewById(R.id.textView2);
        if(Client.getInstance().connectToServer()){
            tv.setText("Online");
            tv.setTextColor(Color.GREEN);
        }
        else{
            tv.setText("Offline");
            tv.setTextColor(Color.RED);
        }

    }
}
