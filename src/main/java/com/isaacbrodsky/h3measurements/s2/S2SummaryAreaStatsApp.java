package com.isaacbrodsky.h3measurements.s2;

import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.isaacbrodsky.h3measurements.Args;
import com.isaacbrodsky.h3measurements.GeoUtils;
import com.isaacbrodsky.h3measurements.IndexRandom;
import com.isaacbrodsky.h3measurements.SphereRandom;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.GeometryFactory;

/**
 * Calculate the average area (and other descriptive statistics) for S2 cells.
 */
public class S2SummaryAreaStatsApp {
    private static final int MAX_ITERATIONS = 10000;

    public static void main(String[] argv) {
        try {
            Args args = new Args();
            JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
            final GeometryFactory factory = new GeometryFactory();
            final S2Provider rnd = args.sphereRandom ? new SphereRandom() : new IndexRandom();

            for (int level = 0; level <= S2CellId.MAX_LEVEL; level++) {
                final SummaryStatistics statistics = new SummaryStatistics();
                int i = 0;

                for (; i < MAX_ITERATIONS; i++) {
                    final S2CellId id = rnd.s2Index(level);
                    final Measure area = S2AreaUtils.computeArea(id, factory);

                    statistics.addValue(GeoUtils.m2ToKm2(area.doubleValue()));
                }

                System.out.format("iterations=%d level=%d stats in km2: %sratio of max to min: %f\n\n",
                        i,
                        level,
                        statistics.toString(),
                        statistics.getMax() / statistics.getMin());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
