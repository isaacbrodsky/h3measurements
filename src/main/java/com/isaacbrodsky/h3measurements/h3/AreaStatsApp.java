package com.isaacbrodsky.h3measurements.h3;

import com.isaacbrodsky.h3measurements.GeoUtils;
import com.uber.h3core.H3Core;
import org.geotools.measure.Measure;
import org.locationtech.jts.geom.GeometryFactory;

import java.util.Scanner;

/**
 * Calculate the area and other descriptors of specific H3 cells.
 */
public class AreaStatsApp {
    public static void main(String[] args) {
        try {
            final GeometryFactory factory = new GeometryFactory();
            final H3Core h3Core = H3Core.newInstance();

            try (Scanner in = new Scanner(System.in)) {
                while (in.hasNextLine()) {
                    final String l = in.nextLine();

                    final long index = h3Core.stringToH3(l);

                    final Measure area = H3AreaUtils.computeArea(h3Core, factory, index);

                    System.out.println(h3Core.h3ToString(index));
                    System.out.println("center: " + h3Core.cellToLatLng(index));
                    System.out.println("area: " + area);
                    System.out.println("area in km2: "
                            + (GeoUtils.m2ToKm2(area.doubleValue())));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
