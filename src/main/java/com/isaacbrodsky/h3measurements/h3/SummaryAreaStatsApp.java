package com.isaacbrodsky.h3measurements.h3;

import com.beust.jcommander.JCommander;
import com.isaacbrodsky.h3measurements.Args;
import com.isaacbrodsky.h3measurements.GeoUtils;
import com.isaacbrodsky.h3measurements.IndexRandom;
import com.isaacbrodsky.h3measurements.SphereRandom;
import com.uber.h3core.H3Core;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.GeometryFactory;

/**
 * Calculate the average area (and other descriptive statistics) for H3 cells.
 */
public class SummaryAreaStatsApp {
    private static final int MAX_ITERATIONS = 10000;

    public static void main(String[] argv) {
        try {
            Args args = new Args();
            JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
            final GeometryFactory factory = new GeometryFactory();
            final H3Core h3Core = H3Core.newInstance();
            final H3Provider rnd = args.randomSphere ? new SphereRandom() : new IndexRandom();

            for (int res = 0; res <= 15; res++) {
                final SummaryStatistics statistics = new SummaryStatistics();
                int i = 0;

                for (; i < MAX_ITERATIONS; i++) {
                    final long index = rnd.h3Index(res);

                    final Measure area = H3AreaUtils.computeArea(h3Core, factory, index);

                    statistics.addValue(GeoUtils.m2ToKm2(area.doubleValue()));
                }

                System.out.format("iterations=%d res=%d stats in km2: %sratio of max to min: %f\n\n",
                        i,
                        res,
                        statistics.toString(),
                        statistics.getMax() / statistics.getMin());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
