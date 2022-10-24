package com.isaacbrodsky.h3measurements.h3;

import com.isaacbrodsky.h3measurements.Args;
import com.isaacbrodsky.h3measurements.GeoUtils;
import com.isaacbrodsky.h3measurements.SphereRandom;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.LatLng;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.GeometryFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Calculate the average edge length (and other descriptive statistics) for H3 cells.
 */
public class SummaryPerimeterStatsApp {
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
            final H3Provider rnd = args.sphereRandom ? new SphereRandom() : new IndexRandom();
            final Random random = ThreadLocalRandom.current();

            for (int res = 0; res <= 15; res++) {
                final SummaryStatistics statistics = new SummaryStatistics();
                int i = 0;

                for (; i < MAX_ITERATIONS; i++) {
                    final long index = rnd.h3Index(res);

                    // Choose a random index, and then choose a random edge of that index.
                    final List<Long> edges = h3Core.originToDirectedEdges(index);
                    final long edge = edges.get(random.nextInt(edges.size()));
                    final List<LatLng> coords = h3Core.directedEdgeToBoundary(edge);

                    final Measure area = H3AreaUtils.computeLength(h3Core, factory, coords, index);

                    statistics.addValue(GeoUtils.mToKm(area.doubleValue()));
                }

                System.out.format("iterations=%d res=%d stats in km: %sratio of max to min: %f\n\n",
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
