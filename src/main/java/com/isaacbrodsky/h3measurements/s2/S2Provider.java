package com.isaacbrodsky.h3measurements.s2;

import com.google.common.geometry.S2CellId;

public interface S2Provider {
    S2CellId s2Index(int level);
}
