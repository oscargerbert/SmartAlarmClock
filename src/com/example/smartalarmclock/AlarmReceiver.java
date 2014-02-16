package com.example.smartalarmclock;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

//Needed to be able to unlock screen
public class AlarmReceiver extends WakefulBroadcastReceiver{

	@Override
	public void onReceive(Context con, Intent intent) {
		Intent newIntent = new Intent(con, Alarm.class);
		con.startActivity(newIntent);
		
	}

}
