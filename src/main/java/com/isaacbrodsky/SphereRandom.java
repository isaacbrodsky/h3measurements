package com.isaacbrodsky;

import com.uber.h3core.util.GeoCoord;

public class SphereRandom {
    /**
     * Random coordinate on the sphere, algorithm is from WolframAlpha.
     * http://mathworld.wolfram.com/SpherePointPicking.html
     */
    public static GeoCoord random() {
        double u = Math.random();
        double v = Math.random();

        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);

        return new GeoCoord(Math.toDegrees(theta), Math.toDegrees(phi));
    }
}
