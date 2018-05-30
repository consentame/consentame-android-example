package me.consenta.android.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.consenta.android.consentame.ConsentaMe;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private Button test;
    private TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConsentaMe checkBox = new ConsentaMe(this, R.id.consent);

        test = findViewById(R.id.submit_btn);
        console = findViewById(R.id.main_console);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkBox.isChecked()) {
                    console.setTextColor(Color.RED);
                    console.setText(R.string.main_console_err_msg);
                } else {
                    console.setTextColor(Color.GREEN);
                    console.setText(
                            String.format(getString(R.string.main_console_success_msg), checkBox.getConsentId(), checkBox.getUserConsentId())
                    );
                }
            }
        });

    }
}
