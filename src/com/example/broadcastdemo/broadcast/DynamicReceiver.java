package com.example.broadcastdemo.broadcast;


import com.example.broadcastdemo.MainActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver { //�ʺA�s������

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(MainActivity.DYNAMIC_BROADCAST)) {  
			Log.i("msg","DynamicReceiver");
			String msg = intent.getStringExtra("msg");
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

		}

	}
}
