package com.isaacbrodsky.h3measurements.h3;

import com.isaacbrodsky.h3measurements.SphereRandom;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;

/**
 * Calculate the percentage of area error when truncating indexes by reindexing their centroids.
 */
public class CentroidTruncationRatioApp {
    private static final int MAX_ITERATIONS = 1000000;

    public static void main(String[] args) {
        try {
            final H3Core h3Core = H3Core.newInstance();

            for (int res = 15; res > 0; res--) {
                for (int resTruncated = res - 1; resTruncated >= 0; resTruncated--) {
                    int i = 0;
                    int in = 0;
                    int out = 0;
                    for (; i < MAX_ITERATIONS; i++) {
                        final GeoCoord rnd = SphereRandom.random();

                        final long index = h3Core.geoToH3(rnd.lat, rnd.lng, res);
						final GeoCoord centroid = h3Core.h3ToGeo(index);
                        final long truncated = h3Core.geoToH3(centroid.lat, centroid.lng, resTruncated);
                        final long coarse = h3Core.geoToH3(rnd.lat, rnd.lng, resTruncated);

                        if (truncated == coarse) {
                            in++;
                        } else {
                            out++;
                        }
                    }

                    System.out.format("iterations=%d res=%d truncated=%d in=%d out=%d: %f percent contained\n",
                            i,
                            res,
                            resTruncated,
                            in,
                            out,
                            (double) in / (double) i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
