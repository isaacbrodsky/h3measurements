package com.isaacbrodsky.h3measurements;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.geometry.S2CellId;
import com.isaacbrodsky.h3measurements.h3.H3Provider;
import com.isaacbrodsky.h3measurements.s2.S2Provider;
import com.uber.h3core.H3Core;

/**
 * Provides DGGS indexes chosen randomly by building valid index values
 */
public class IndexRandom implements H3Provider, S2Provider {
    private final H3Core h3;
    private final Random random;

    public IndexRandom() throws IOException {
        this(H3Core.newInstance(), ThreadLocalRandom.current());
    }

    public IndexRandom(H3Core h3, Random random) {
        this.h3 = h3;
        this.random = random;
    }

    @Override
    public long h3Index(int res) {
        long modeSet = 0x1L << 0x3bL;
        long index = modeSet;
        index |= ((long) res << 0x34L);
        int baseCell = random.nextInt(122);
        long baseCellBits = ((long) baseCell << 0x2dL);
        index |= baseCellBits;
        // Check if the base cell - res 0 - is a pentagon
        long pentagonTest = modeSet | baseCellBits | 0x1fffffffffffL;
        boolean isPentagon = h3.isPentagon(pentagonTest);
        long firstNonZeroDigit = 0;
        for (int i = 1; i <= res; i++) {
            long digit;
            do {
                digit = random.nextInt(7);
                // Sample with rejection for deleted pentagon subsequence
            } while (isPentagon && firstNonZeroDigit == 0 && digit == 1);
            if (firstNonZeroDigit == 0) {
                firstNonZeroDigit = digit;
            }
            index |= digit << (long)((15 - i) * 3);
        }
        for (int i = res + 1; i <= 15; i++) {
            index |= 0b111L << (long)((15 - i) * 3);
        }
        if (!h3.isValidCell(index)) {
            throw new RuntimeException("Generated an invalid index: " + Long.toHexString(index));
        }
        return index;
    }

    @Override
    public S2CellId s2Index(int level) {
        int face = random.nextInt(6);
        // TODO: Verify
        long posBound = 0x2000000000000000L;
        long pos = random.nextLong(posBound);
        S2CellId id = S2CellId.fromFacePosLevel(face, pos, level);
        if (!id.isValid()) {
            throw new RuntimeException("Generated an invalid index: " + id);
        }
        return id;
    }
}
