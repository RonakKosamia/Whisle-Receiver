package whistle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyCallReceiver extends BroadcastReceiver {

	SharedPreferences prefs;
	boolean cut, flag = true;
	static MyPhoneStateListener listener;

	@Override
	public void onReceive(final Context context, Intent intent) {
		Log.d("main", "received");
		cut = false;
		prefs = PreferenceManager.getDefaultSharedPreferences(context);

		TelephonyManager tmanager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		if (listener == null) {
			listener = new MyPhoneStateListener(context);

			if (prefs.getBoolean("main_switch", false)) {
				Log.d("main", "Switch true & listening state");
				tmanager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
			}

		}

	}
}
