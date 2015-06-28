package whistle.receiver;

import whistle.receiver.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	SharedPreferences prefs;
	Editor edit;
	public static int whistleValue = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		edit = prefs.edit();
		ToggleButton tb1 = (ToggleButton) findViewById(R.id.switch1);
		tb1.setChecked(prefs.getBoolean("main_switch", false));
		tb1.setOnCheckedChangeListener(this);
		Button test = (Button) findViewById(R.id.button_test);
		test.setOnClickListener(this);
		Button settings = (Button) findViewById(R.id.button_setting);
		settings.setOnClickListener(this);
		Button more = (Button) findViewById(R.id.button_more);
		more.setOnClickListener(this);
		Button rate = (Button) findViewById(R.id.button_rate);
		rate.setOnClickListener(this);
		Button star = (Button) findViewById(R.id.button_star);
		star.setOnClickListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		switch (arg0.getId()) {
		case R.id.switch1:
			edit.putBoolean("main_switch", arg1);
			edit.commit();
			break;
		}
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.button_test:
			startActivity(new Intent(getApplicationContext(),
					TestActivity.class));
			break;
		case R.id.button_setting:
			startActivity(new Intent(getApplicationContext(),
					SettingsActivity.class));
			break;
		case R.id.button_more:
			startActivity(new Intent(getApplicationContext(),
					MoreActivity.class));
			break;
		case R.id.button_star:
		case R.id.button_rate:
			Intent rat = new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://play.google.com/store/apps/details?id="
							+ getPackageName()));
			startActivity(rat);

			break;
		}
	}

}
