package com.ex.binarywatch;

import java.util.Calendar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Runnable currentTime = new CurrentTime();
		Thread thread = new Thread(currentTime);
		thread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	void showTime() {
		runOnUiThread(new Runnable(){
			@Override
			public void run() {
				TextView textView = (TextView)findViewById(R.id.textview1);
				TextView textH = (TextView)findViewById(R.id.textBinaryH);
				TextView textM = (TextView)findViewById(R.id.textBinaryM);
				TextView textS = (TextView)findViewById(R.id.textBinaryS);
				Calendar c = Calendar.getInstance();
				int hours = c.get(Calendar.HOUR_OF_DAY);
				int mins = c.get(Calendar.MINUTE);
				int secs = c.get(Calendar.SECOND);
				textView.setText(hours + ":" + mins + ":" + secs);

				String sHours = Integer.toBinaryString(hours);
				int sh = sHours.length();
				View vh0 = (View)findViewById(R.id.hours0);
				View vh1 = (View)findViewById(R.id.hours1);
				View vh2 = (View)findViewById(R.id.hours2);
				View vh3 = (View)findViewById(R.id.hours3);
				View vh4 = (View)findViewById(R.id.hours4);
				View vh5 = (View)findViewById(R.id.hours5);
				if (sh > 0 && sHours.charAt(sh-1) == '1') vh0.setBackgroundColor(Color.RED);
					else vh0.setBackgroundColor(Color.GRAY);
				if (sh > 1 && sHours.charAt(sh-2) == '1') vh1.setBackgroundColor(Color.RED);
					else vh1.setBackgroundColor(Color.GRAY);
				if (sh > 2 && sHours.charAt(sh-3) == '1') vh2.setBackgroundColor(Color.RED);
					else vh2.setBackgroundColor(Color.GRAY);
				if (sh > 3 && sHours.charAt(sh-4) == '1') vh3.setBackgroundColor(Color.RED);
					else vh3.setBackgroundColor(Color.GRAY);
				if (sh > 4 && sHours.charAt(sh-5) == '1') vh4.setBackgroundColor(Color.RED);
					else vh4.setBackgroundColor(Color.GRAY);
				if (sh > 5 && sHours.charAt(sh-6) == '1') vh5.setBackgroundColor(Color.RED);
					else vh5.setBackgroundColor(Color.GRAY);

				String sMins = Integer.toBinaryString(mins);
				int sm = sMins.length();
				View vm0 = (View)findViewById(R.id.mins0);
				View vm1 = (View)findViewById(R.id.mins1);
				View vm2 = (View)findViewById(R.id.mins2);
				View vm3 = (View)findViewById(R.id.mins3);
				View vm4 = (View)findViewById(R.id.mins4);
				View vm5 = (View)findViewById(R.id.mins5);
				if (sm > 0 && sMins.charAt(sm-1) == '1') vm0.setBackgroundColor(Color.RED);
					else vm0.setBackgroundColor(Color.GRAY);
				if (sm > 1 && sMins.charAt(sm-2) == '1') vm1.setBackgroundColor(Color.RED);
					else vm1.setBackgroundColor(Color.GRAY);
				if (sm > 2 && sMins.charAt(sm-3) == '1') vm2.setBackgroundColor(Color.RED);
					else vm2.setBackgroundColor(Color.GRAY);
				if (sm > 3 && sMins.charAt(sm-4) == '1') vm3.setBackgroundColor(Color.RED);
					else vm3.setBackgroundColor(Color.GRAY);
				if (sm > 4 && sMins.charAt(sm-5) == '1') vm4.setBackgroundColor(Color.RED);
					else vm4.setBackgroundColor(Color.GRAY);
				if (sm > 5 && sMins.charAt(sm-6) == '1') vm5.setBackgroundColor(Color.RED);
					else vm5.setBackgroundColor(Color.GRAY);

				String sSecs = Integer.toBinaryString(secs);
				int sl = sSecs.length();
				View vs0 = (View)findViewById(R.id.secs0);
				View vs1 = (View)findViewById(R.id.secs1);
				View vs2 = (View)findViewById(R.id.secs2);
				View vs3 = (View)findViewById(R.id.secs3);
				View vs4 = (View)findViewById(R.id.secs4);
				View vs5 = (View)findViewById(R.id.secs5);
				if (sl > 0 && sSecs.charAt(sl-1) == '1') vs0.setBackgroundColor(Color.RED);
					else vs0.setBackgroundColor(Color.GRAY);
				if (sl > 1 && sSecs.charAt(sl-2) == '1') vs1.setBackgroundColor(Color.RED);
					else vs1.setBackgroundColor(Color.GRAY);
				if (sl > 2 && sSecs.charAt(sl-3) == '1') vs2.setBackgroundColor(Color.RED);
					else vs2.setBackgroundColor(Color.GRAY);
				if (sl > 3 && sSecs.charAt(sl-4) == '1') vs3.setBackgroundColor(Color.RED);
					else vs3.setBackgroundColor(Color.GRAY);
				if (sl > 4 && sSecs.charAt(sl-5) == '1') vs4.setBackgroundColor(Color.RED);
					else vs4.setBackgroundColor(Color.GRAY);
				if (sl > 5 && sSecs.charAt(sl-6) == '1') vs5.setBackgroundColor(Color.RED);
					else vs5.setBackgroundColor(Color.GRAY);

				textH.setText(sHours);
				textM.setText(sMins);
				textS.setText(sSecs);
			}
		});
	}
	
	class CurrentTime implements Runnable {
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				showTime();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				} catch (Exception e) {}
			}
		}
	}

}
