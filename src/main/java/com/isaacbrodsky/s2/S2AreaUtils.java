package com.isaacbrodsky.s2;

import com.google.common.geometry.S2Cell;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
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

public class S2AreaUtils {
    public static Measure computeArea(S2CellId id, GeometryFactory factory) {
        final S2Cell cell = new S2Cell(id);
        final S2LatLng centroid = new S2LatLng(cell.getCenter());

        final Coordinate[] coords = new Coordinate[5];
        coords[0] = pointToCoord(cell.getVertex(0));
        coords[1] = pointToCoord(cell.getVertex(1));
        coords[2] = pointToCoord(cell.getVertex(2));
        coords[3] = pointToCoord(cell.getVertex(3));
        coords[4] = pointToCoord(cell.getVertex(0));

        final Polygon p = factory.createPolygon(coords);
        // Refer to https://gis.stackexchange.com/questions/127921/unit-of-geotools-getarea-function
        try {
            // Universal Transverse Mercator centered on the cell
            final String code = "AUTO:42001," + centroid.lngDegrees() + "," + centroid.latDegrees();
            final CoordinateReferenceSystem auto = CRS.decode(code);

            final MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

            final Polygon projed = (Polygon) JTS.transform(p, transform);
            return new Measure(projed.getArea(), SI.SQUARE_METRE);
        } catch (MismatchedDimensionException | TransformException | FactoryException e) {
            throw new RuntimeException("Failed to compute area for " + id.toString(), e);
        }
    }

    private static Coordinate pointToCoord(S2Point p) {
        final S2LatLng latLng = new S2LatLng(p);
        return new Coordinate(latLng.lngDegrees(), latLng.latDegrees());
    }
}
