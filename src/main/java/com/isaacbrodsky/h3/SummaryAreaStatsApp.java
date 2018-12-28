package com.isaacbrodsky.h3;

import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.GeometryFactory;

/**
 * Calculate the average area (and other descriptive statistics) for H3 cells.
 */
public class SummaryAreaStatsApp {
    private static final int MAX_ITERATIONS = 10000;

    public static void main(String[] args) {
        try {
            final GeometryFactory factory = new GeometryFactory();
            final H3Core h3Core = H3Core.newInstance();

            for (int res = 0; res <= 15; res++) {
                final SummaryStatistics statistics = new SummaryStatistics();
                int i = 0;

                for (; i < MAX_ITERATIONS; i++) {
                    final GeoCoord rnd = SphereRandom.random();

                    final long index = h3Core.geoToH3(rnd.lat, rnd.lng, res);

                    final Measure area = AreaUtils.computeArea(h3Core, factory, index);

                    statistics.addValue(AreaUtils.m2ToKm2(area.doubleValue()));
                }

                System.out.format("final iterations=%d res=%d stats in km2: %s\n", i, res, statistics.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
