package com.example.smsapp;


import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button send;
	EditText mo,massage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main);
		send = (Button) findViewById(R.id.send);
		mo = (EditText) findViewById(R.id.mo);
		massage = (EditText) findViewById(R.id.massage);
		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				sendSms(mo.getText().toString(),massage.getText().toString());

			}
		});

	}

	
	private void toastMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	private void sendSms(String no,String msg){
       try{ Intent intent=new Intent(getApplicationContext(),MainActivity.class);  
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
        SmsManager sms=SmsManager.getDefault();  
        sms.sendTextMessage(no, null, msg, pi,null);
        toastMessage("success");
	}
       catch(Exception e){
   		toastMessage("failed");
   	}
	}
}
