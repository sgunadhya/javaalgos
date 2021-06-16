package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimitiveTypesTest {
    @Test
    public void testParityInteger() {
        int s = 0b10111;
        assertFalse(PrimitiveTypes.isOddParity(s));
        int sOdd = 0b10110;
        assertTrue(PrimitiveTypes.isOddParity(sOdd));
    }

    @Test
    public void testSwapBitsAtPosition() {
        int s = 0b10101;
        int r = 0b00111;
        assertTrue(Integer.compare(PrimitiveTypes.swapBits(s, 1, 4), r) == 0);
    }

}