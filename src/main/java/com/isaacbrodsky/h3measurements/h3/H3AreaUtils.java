package com.isaacbrodsky.h3measurements.h3;

import com.isaacbrodsky.h3measurements.GeoUtils;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import java.util.List;
import java.util.stream.Collectors;

public class H3AreaUtils {

    public static Measure computeArea(H3Core h3Core, GeometryFactory factory, long index) {
        final List<GeoCoord> coords = h3Core.h3ToGeoBoundary(index);
        // Convert to closed loop
        coords.add(coords.get(0));
        final Coordinate centroid = geoCoordToCoord(h3Core.h3ToGeo(index));

        final Polygon p = factory.createPolygon(
                coords.stream()
                        .map(H3AreaUtils::geoCoordToCoord)
                        .collect(Collectors.toList())
                        .toArray(new Coordinate[0])
        );
        return GeoUtils.computeArea(h3Core.h3ToString(index), p, centroid);
    }

    public static Measure computeLength(H3Core h3Core, GeometryFactory factory, List<GeoCoord> coords, long index) {
        // Coords for the edge are accepted as parameters so the caller can decide which edge
        final Coordinate centroid = geoCoordToCoord(h3Core.h3ToGeo(index));

        final LineString edge = factory.createLineString(
                coords.stream()
                        .map(H3AreaUtils::geoCoordToCoord)
                        .collect(Collectors.toList())
                        .toArray(new Coordinate[0])
        );
        return GeoUtils.computeLength(h3Core.h3ToString(index), edge, centroid);
    }

    private static Coordinate geoCoordToCoord(GeoCoord c) {
        return new Coordinate(c.lng, c.lat);
    }
}
