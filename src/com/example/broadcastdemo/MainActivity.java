package com.example.broadcastdemo;

import com.example.broadcastdemo.broadcast.DynamicReceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_static_broadcast_A,btn_static_broadcast_B,btn_static_broadcast_C,btn_dynamic_broadcast;
	private Context context;
	public static final String STATIC_BROADCASTA="com.example.broadcastreceiverdemo.static_broadcastA"; 
	public static final String STATIC_BROADCASTB="com.example.broadcastreceiverdemo.static_broadcastB"; 
	public static final String STATIC_BROADCASTC="com.example.broadcastreceiverdemo.static_broadcastC"; 
	public static final String DYNAMIC_BROADCAST="com.example.broadcastdemo.dynamic_broadcast"; 
	private DynamicReceiver dynamicReceiver= new DynamicReceiver();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.context = this;
		findView();
		setAction();

	}

	private void findView(){
		btn_static_broadcast_A = (Button) findViewById(R.id.btn_static_broadcast_A);
		btn_static_broadcast_B = (Button) findViewById(R.id.btn_static_broadcast_B);
		btn_static_broadcast_C = (Button) findViewById(R.id.btn_static_broadcast_C);
		btn_dynamic_broadcast = (Button)findViewById(R.id.btn_dynamic_broadcast);
	}
	private void setAction() {
		btn_static_broadcast_A.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
		       Intent intent = new Intent();
		       intent.setAction(STATIC_BROADCASTA); 
		       intent.putExtra("broadcastsender", "靜態AAA");  //intent.putExtra(key,value);
		       intent.putExtra("broadcastreceiver", "rely2");  
		       intent.putExtra("status", "processing2");  
		       intent.putExtra("sn", "流水序號2");
		       intent.putExtra("mission", "任務編號2");  
               sendBroadcast(intent); 

			}
		});
		
		btn_static_broadcast_B.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
		       Intent intent = new Intent();
		       intent.setAction(STATIC_BROADCASTB); 
		       intent.putExtra("broadcastsender", "子系統名稱BBB");  
		       intent.putExtra("broadcastreceiver", "rely");  
		       intent.putExtra("status", "processing");  
		       intent.putExtra("sn", "流水序號");
		       intent.putExtra("mission", "任務編號");  
               sendBroadcast(intent); 

			}
		});
		
		btn_static_broadcast_C.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		       Intent intent = new Intent();
		       intent.setAction(STATIC_BROADCASTC);
		       intent.putExtra("broadcastsender", "子系統名稱CCC");  
		       intent.putExtra("broadcastreceiver", "rely");  
		       intent.putExtra("status", "processing");  
		       intent.putExtra("sn", "流水序號");
		       intent.putExtra("mission", "任務編號");  
               sendBroadcast(intent); 

			}
		});
		
		btn_dynamic_broadcast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();  
                intent.setAction(DYNAMIC_BROADCAST);  
                intent.putExtra("msg", "動態");
                sendBroadcast(intent); 
				
			}
		});

	}

	@Override
	protected void onStart() {//動態註冊廣播
		super.onStart();
		IntentFilter filter = new IntentFilter();
		filter.addAction(DYNAMIC_BROADCAST);
		registerReceiver(dynamicReceiver, filter);
	}

	@Override
	protected void onStop() {//動態註銷註冊使用
		super.onStop();
		unregisterReceiver(dynamicReceiver);
	}
	


}