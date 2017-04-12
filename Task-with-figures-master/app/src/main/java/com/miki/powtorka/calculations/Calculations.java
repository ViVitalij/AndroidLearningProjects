package com.miki.powtorka.calculations;

import static java.lang.Math.sqrt;

/**
 * Created by Miki on 03.04.2017.
 */

public class Calculations {

    final private double pi = 3.1415;

    public double circleArea(double radius) {

        return pi * radius * radius;
    }

    public double circleCircuit(double radius) {
        return 2 * pi * radius;
    }

    public double rectangleArea(double a, double b) {
        return a * b;
    }

    public double rectangleCircuit(double a, double b) {
        return a + a + b + b;
    }

    public double triangleArea(double a) {
        return a * a * sqrt(3) / 2;
    }

    public double triangleCircuit(double a) {
        return 3 * a;
    }


}
