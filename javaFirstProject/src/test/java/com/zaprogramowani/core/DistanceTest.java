package com.zaprogramowani.core;

import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {
    
    @Test
    public void shouldEqualsTheSameDistances() {
        // given
        Distance distance1 = Distance.ofCentimeters(50f);
        Distance distance2 = Distance.ofMeters(0.5f);

        // when
        boolean result = distance1.equals(distance2);

        // then
        Assert.assertTrue(result);
    }

}