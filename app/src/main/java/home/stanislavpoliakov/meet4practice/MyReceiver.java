package home.stanislavpoliakov.meet4practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private ViewCallback mViewCallback;
    private final String LOG_TAG = "meet4_logs";

    public MyReceiver(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
        //Log.d(LOG_TAG, "Receiver: constructed");
    }

    /**
     * Реализация метода onRecieve для изменения UI-компонента по приему broadcast'-а
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onStatusChange(intent.getStringExtra("STATE"));
        //Log.d(LOG_TAG, "Receiver onReceive");
    }
}
