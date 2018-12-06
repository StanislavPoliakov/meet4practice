package home.stanislavpoliakov.meet4practice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class MyIntentService extends IntentService {
    private final String LOG_TAG = "meet4_logs";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        changeState();
    }

    private void changeState() {
        StateManager.getInstance().changeState();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyIntentService.class);
    }
}
