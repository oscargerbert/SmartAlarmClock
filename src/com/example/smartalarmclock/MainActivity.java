package com.example.smartalarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TimePicker tp;
	@Override
	//standard onCreate method
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button butt = (Button) findViewById(R.id.btn_set_alarm);
		TimePicker tp = (TimePicker) findViewById(R.id.set_time);
		tp.setIs24HourView(true);
		butt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setAlarm();				
			}
		});
	}
	public void setAlarm() {
		long hej = 120000;
		AlarmManager alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(this, AlarmReceiver.class);
		PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
		//create an inexact and repeating alarm 2 miniutes from now.
		alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+hej, AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);
		Toast.makeText(this, "Hopefully an alarm is created", Toast.LENGTH_LONG).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate menu and add items to it (if present)
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//choose what happens when you click the items in the menu
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.action_settings:
    		openSettings();
    		return true;
    	default:
    		super.onOptionsItemSelected(item);
    	}
		return false;
    }
	//Do this when settings item, in menu, is clicked.
	public void openSettings() {
		//Open the preferences window
		Intent intent = new Intent(this, PrefActivity.class);
		startActivity(intent);
	}
}
