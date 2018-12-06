package home.stanislavpoliakov.meet4practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView statusView;

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
    }

    @Override
    public void onClick(View v) {
        startService(MyIntentService.newIntent(MainActivity.this));
    }
}
