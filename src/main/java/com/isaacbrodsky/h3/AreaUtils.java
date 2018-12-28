package com.isaacbrodsky.h3;

import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import org.geotools.geometry.jts.JTS;
import org.geotools.measure.Measure;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import si.uom.SI;

import java.util.List;
import java.util.stream.Collectors;

public class AreaUtils {
    private static final double M2_TO_KM2 = 0.000001;

    public static Measure computeArea(H3Core h3Core, GeometryFactory factory, long index) {
        final List<GeoCoord> coords = h3Core.h3ToGeoBoundary(index);
        final GeoCoord centroid = h3Core.h3ToGeo(index);
        // Convert to closed loop
        coords.add(coords.get(0));

        final Polygon p = factory.createPolygon(
                coords.stream()
                        .map(c -> new Coordinate(c.lng, c.lat))
                        .collect(Collectors.toList())
                        .toArray(new Coordinate[0])
        );
        // Refer to https://gis.stackexchange.com/questions/127921/unit-of-geotools-getarea-function
        try {
            // Universal Transverse Mercator centered on the cell
            final String code = "AUTO:42001," + centroid.lng + "," + centroid.lat;
            final CoordinateReferenceSystem auto = CRS.decode(code);

            final MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

            final Polygon projed = (Polygon) JTS.transform(p, transform);
            return new Measure(projed.getArea(), SI.SQUARE_METRE);
        } catch (MismatchedDimensionException | TransformException | FactoryException e) {
            throw new RuntimeException("Failed to compute area for " + h3Core.h3ToString(index), e);
        }
    }

    public static double m2ToKm2(double m2) {
        return m2 * M2_TO_KM2;
    }
}
