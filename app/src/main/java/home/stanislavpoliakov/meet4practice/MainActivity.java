package home.stanislavpoliakov.meet4practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView statusView;
    private final String LOG_TAG = "meet4_logs";
    private MyReceiver mReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();
    }

    private void initItems() {
        statusView = findViewById(R.id.state_view);
        Button changeStatus_button = findViewById(R.id.changeState_button);
        changeStatus_button.setOnClickListener(this);
        mReceiver = new MyReceiver(new MyViewCallBack());
        mIntentFilter = new IntentFilter("current_state"); //Объявляем фильтр, по которому
        //будем ловить сообщения
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
        //Log.d(LOG_TAG, "Main: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
        //Log.d(LOG_TAG, "Main: onPause");
    }

    @Override
    public void onClick(View v) {
        startService(MyIntentService.newIntent(MainActivity.this)); //startOnCommand
    }

    //Объявляем приватный класс который будет реализовавать наш функциональный интерфейс,
    //переопределяя его метод. Реализация находится в потоке Activity, в которой нужно будет
    //менять UI-компонент. И передаем объект этого класса в MyReceiver.
    private class MyViewCallBack implements ViewCallback {
        @Override
        public void onStatusChange(String status) {
            //Log.d(LOG_TAG, "onStatusChange: " + status);
            statusView.setText(status);
        }
    }
}
