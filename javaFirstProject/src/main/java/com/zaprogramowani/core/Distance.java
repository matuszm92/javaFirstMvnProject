package com.zaprogramowani.core;

import java.util.Objects;

public class Distance {
    
    private static final float METERS_TO_INCHES_RATIO = 39.3701f;
    private static final float CENTIMETERS_TO_METERS_RATIO = 100f;
    private float centimeters;

    private Distance(float centimeters)  {
        if(centimeters < 0f) {
            throw new IllegalArgumentException();
        }
        this.centimeters = centimeters;
    }

    public float asCentimeters() {
        return centimeters;
    }

    public float asMeters() {
        return centimeters / CENTIMETERS_TO_METERS_RATIO;
    }

    public float asInches() {
        return asMeters() * METERS_TO_INCHES_RATIO;
    }

    public static Distance ofCentimeters(float centimeters) {
        return new Distance(centimeters);
    }

    public static Distance ofMeters(float meters) {
        return new Distance(meters * CENTIMETERS_TO_METERS_RATIO);
    }
    
    public static Distance ofInches(float inches) {
        return new Distance(inches / METERS_TO_INCHES_RATIO * CENTIMETERS_TO_METERS_RATIO);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Distance that = (Distance) o;
        return Objects.equals(centimeters, that.centimeters);
    }

}