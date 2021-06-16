package javaalgos;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.*;

public class StacksTest {

    @Test
    public void testReversePolishNotation() {
        String expression = "3,4,+,2,*,1,+";
        int r = Stacks.evaluateReversePolishExpression(expression);
        assertTrue("r should be 15 not :" + r, Integer.compare(r, 15) == 0);
    }

    @Test
    public void testWellFormedString() {
        String notWellFormed = "[()[]{()()";
        String wellFormed = "[()[]|()()|]";
        assertFalse(Stacks.isWellFormed(notWellFormed));
        assertTrue(Stacks.isWellFormed(wellFormed));
    }

    @Test
    public void testNormalizePathNames() {
        Map<String, String> tests = new HashMap<>();
        tests.put("/home/", "/home");
        tests.put("/a/./b/../../c/", "/c");
        tests.put("/../../../../../a", "/a");
        tests.put("/a/./b/./c/./d/", "/a/b/c/d");
        for (Map.Entry<String, String> t : tests.entrySet()) {
            assertEquals(Stacks.normalizePathName(t.getKey()), t.getValue());
        }
    }

    @Test
    public void testBuildingsWithSunsetView() {
        assertTrue(Stacks.buildingsWithSunsetView(new int[]{7, 4, 8, 2, 9}) == 3);
    }

    @Test
    public void testStackWithMax() {
        Stacks.StackWithMax k = new Stacks.StackWithMax();
        k.push(4);
        k.push(12);
        k.push(1);
        assertTrue(Integer.compare(k.max(), 12) == 0);
    }
}