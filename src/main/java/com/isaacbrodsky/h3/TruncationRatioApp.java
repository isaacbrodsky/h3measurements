package com.isaacbrodsky.h3;

import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;

/**
 * Hello world!
 *
 */
public class TruncationRatioApp {
    private static int MAX_ITERATIONS = 10000000;

    public static void main(String[] args) {
        try {
            H3Core h3Core = H3Core.newInstance();

            for (int res = 15; res > 0; res--) {
                int i = 0;
                int in = 0;
                int out = 0;
                for (; i < MAX_ITERATIONS; i++) {
                    GeoCoord rnd = SphereRandom.random();

                    long index = h3Core.geoToH3(rnd.lat, rnd.lng, res);
                    long truncated = h3Core.h3ToParent(index, res - 1);
                    long coarse = h3Core.geoToH3(rnd.lat, rnd.lng, res - 1);

                    if (truncated == coarse) {
                        in++;
                    } else {
                        out++;
                    }
                }

                System.out.format("final iterations=%d res=%d in=%d out=%d: %f\n", i, res, in, out, (double) in / (double) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
