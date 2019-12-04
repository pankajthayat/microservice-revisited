package com.example.microservice.limitservice.bean;

public class LimitConfiguration {

    private int minimum;

    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public LimitConfiguration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
