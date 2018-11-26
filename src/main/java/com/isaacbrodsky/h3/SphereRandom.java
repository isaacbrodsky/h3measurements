package com.isaacbrodsky.h3;

import com.uber.h3core.util.GeoCoord;

public class SphereRandom {
    public static GeoCoord random() {
        double u = Math.random();
        double v = Math.random();

        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);

        return new GeoCoord(Math.toDegrees(theta), Math.toDegrees(phi));
    }
}
