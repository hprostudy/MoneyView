package com.h.test.customermoneyview;

/**
 * Created by H on 2016/10/13.
 */

public interface IRiseNumber {
    public void start();

    public MoneyView setNumber(float number);

    public MoneyView setNumber(float number, boolean flag);

    public MoneyView setNumber(int number);

    public MoneyView setDuration(long duration);

    public void setOnEnd(MoneyView.EndListener callback);

}
