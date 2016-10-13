package com.h.test.customermoneyview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MoneyView mMoneyView;
    private MoneyView mMoneyView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMoneyView = (MoneyView) findViewById(R.id.money_view);
        mMoneyView1 = (MoneyView) findViewById(R.id.money_view1);

        mMoneyView.setNumber(9999.99f,false).start();
        mMoneyView1.setNumber(9999.99f,true).start();

    }
}
