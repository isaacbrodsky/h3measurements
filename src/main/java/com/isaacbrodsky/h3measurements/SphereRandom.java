package com.isaacbrodsky.h3measurements;

import java.io.IOException;

import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.isaacbrodsky.h3measurements.h3.H3Provider;
import com.isaacbrodsky.h3measurements.s2.S2Provider;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.LatLng;

/**
 * Provides DGGS indexes chosen by indexing random points on the sphere.
 */
public class SphereRandom implements H3Provider, S2Provider {
    private final H3Core h3;
    
    public SphereRandom() throws IOException {
        this(H3Core.newInstance());)
    }

    public SphereRandom(H3Core h3) {
        this.h3 = h3;
    }

    /**
     * Random coordinate on the sphere, algorithm is from WolframAlpha.
     * http://mathworld.wolfram.com/SpherePointPicking.html
     */
    public static LatLng random() {
        double u = Math.random();
        double v = Math.random();

        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);

        return new LatLng(Math.toDegrees(theta), Math.toDegrees(phi));
    }

    @Override
    public long h3Index(int res) {
        LatLng latLng = random();
        return h3.latLngToCell(latLng.lat, latLng.lng, res);
    }

    @Override
    public S2CellId s2Index(int level) {
        LatLng latLng = random();
        S2CellId id = S2CellId
                .fromLatLng(S2LatLng.fromDegrees(latLng.lat, latLng.lng))
                .parent(level);
        return id;
    }
}
