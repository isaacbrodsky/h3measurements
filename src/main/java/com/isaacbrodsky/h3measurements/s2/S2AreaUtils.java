package com.isaacbrodsky.h3measurements.s2;

import com.google.common.geometry.S2Cell;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
import com.isaacbrodsky.h3measurements.GeoUtils;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;

public class S2AreaUtils {
    public static Measure computeArea(S2CellId id, GeometryFactory factory) {
        final S2Cell cell = new S2Cell(id);
        final Coordinate centroid = s2PointToCoord(cell.getCenter());

        final Coordinate[] coords = new Coordinate[5];
        coords[0] = s2PointToCoord(cell.getVertex(0));
        coords[1] = s2PointToCoord(cell.getVertex(1));
        coords[2] = s2PointToCoord(cell.getVertex(2));
        coords[3] = s2PointToCoord(cell.getVertex(3));
        coords[4] = s2PointToCoord(cell.getVertex(0));

        final Polygon p = factory.createPolygon(coords);
        return GeoUtils.computeArea(id.toString(), p, centroid);
    }

    private static Coordinate s2PointToCoord(S2Point p) {
        final S2LatLng latLng = new S2LatLng(p);
        return new Coordinate(latLng.lngDegrees(), latLng.latDegrees());
    }
}
