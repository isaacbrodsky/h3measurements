package com.isaacbrodsky.h3measurements;

import org.geotools.geometry.jts.JTS;
import org.geotools.measure.Measure;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import si.uom.SI;

public class GeoUtils {
    private static final double M2_TO_KM2 = 0.000001;
    private static final double M_TO_KM = 0.001;

    public static Measure computeArea(String id, Polygon p, Coordinate centroid) {
        // Refer to https://gis.stackexchange.com/questions/127921/unit-of-geotools-getarea-function
        try {
            // Universal Transverse Mercator centered on the cell
            final String code = "AUTO:42001," + centroid.x + "," + centroid.y;
            final CoordinateReferenceSystem auto = CRS.decode(code);

            final MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

            final Polygon projed = (Polygon) JTS.transform(p, transform);
            return new Measure(projed.getArea(), SI.SQUARE_METRE);
        } catch (MismatchedDimensionException | TransformException | FactoryException e) {
            throw new RuntimeException("Failed to compute area for " + id, e);
        }
    }

    public static Measure computeLength(String id, LineString ls, Coordinate centroid) {
        // Refer to https://gis.stackexchange.com/questions/127921/unit-of-geotools-getarea-function
        try {
            // Universal Transverse Mercator centered on the cell
            final String code = "AUTO:42001," + centroid.x + "," + centroid.y;
            final CoordinateReferenceSystem auto = CRS.decode(code);

            final MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

            final LineString projed = (LineString) JTS.transform(ls, transform);
            // TODO: not clear if this is correct
            return new Measure(projed.getLength(), SI.METRE);
        } catch (MismatchedDimensionException | TransformException | FactoryException e) {
            throw new RuntimeException("Failed to compute edge length for " + id, e);
        }
    }

    public static double m2ToKm2(double m2) {
        return m2 * M2_TO_KM2;
    }

    public static double mToKm(double m) {
        return m * M_TO_KM;
    }
}
