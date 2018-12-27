package com.isaacbrodsky.h3;

import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.geotools.geometry.jts.JTS;
import org.geotools.measure.Measure;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import si.uom.SI;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Calculate the percentage of area error when truncating indexes one resolution.
 */
public class AreaStatsApp {
    private static final double M2_TO_KM2 = 0.000001;

    private static final int MAX_ITERATIONS = 10000;

    public static void main(String[] args) {
        try {
            GeometryFactory factory = new GeometryFactory();
            H3Core h3Core = H3Core.newInstance();

            for (int res = 0; res <= 15; res++) {
                SummaryStatistics statistics = new SummaryStatistics();
                int i = 0;

                for (; i < MAX_ITERATIONS; i++) {
                    GeoCoord rnd = SphereRandom.random();

                    long index = h3Core.geoToH3(rnd.lat, rnd.lng, res);

                    Measure area = computeArea(h3Core, factory, index);

                    statistics.addValue(area.doubleValue() * M2_TO_KM2);
                }

                System.out.format("final iterations=%d res=%d stats in km2: %s\n", i, res, statistics.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Measure computeArea(H3Core h3Core, GeometryFactory factory, long index) {
        List<GeoCoord> coords = h3Core.h3ToGeoBoundary(index);
        GeoCoord centroid = h3Core.h3ToGeo(index);
        // Convert to closed loop
        coords.add(coords.get(0));

        Polygon p = factory.createPolygon(
                coords.stream()
                        .map(c -> new Coordinate(c.lng, c.lat))
                        .collect(Collectors.toList())
                        .toArray(new Coordinate[0])
        );
        try {
            String code = "AUTO:42001," + centroid.lng + "," + centroid.lat;
            CoordinateReferenceSystem auto = CRS.decode(code);

            MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

            Polygon projed = (Polygon) JTS.transform(p, transform);
            return new Measure(projed.getArea(), SI.SQUARE_METRE);
        } catch (MismatchedDimensionException | TransformException | FactoryException e) {
            // TODO Auto-generated catch block
            System.err.println("Failing on " + h3Core.h3ToString(index));
            e.printStackTrace();
        }
        return new Measure(0.0, SI.SQUARE_METRE);
    }
}
