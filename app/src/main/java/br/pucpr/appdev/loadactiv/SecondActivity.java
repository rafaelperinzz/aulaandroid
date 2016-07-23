package br.pucpr.appdev.loadactiv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by PUCPR on 23/07/16.
 */
public class SecondActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = new Button(this);
        setContentView(btn);
        btn.setText("Clique aqui!!");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
