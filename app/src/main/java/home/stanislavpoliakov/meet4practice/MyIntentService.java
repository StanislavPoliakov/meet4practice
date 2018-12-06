package home.stanislavpoliakov.meet4practice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    private final String LOG_TAG = "meet4_logs";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        //Log.d(LOG_TAG, "IntentService: Started by onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if ("Change State".equals(intent.getAction())) {
            changeState();
            Intent broadcastIntent = new Intent("current_state");
            broadcastIntent.putExtra("STATE", StateManager.getInstance().getCurrentState());
            sendBroadcast(broadcastIntent);
            //Log.d(LOG_TAG, "IntentService: Send " + broadcastIntent.getStringExtra("STATE"));
        }
        //else Log.d(LOG_TAG, "No changes");
        //Log.d(LOG_TAG, "Attempting to change state...");
    }

    private void changeState() {
        StateManager.getInstance().changeState();
        //Log.d(LOG_TAG, "Current State: " + StateManager.getInstance().getCurrentState());
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction("Change State");
        return intent;
    }
}
