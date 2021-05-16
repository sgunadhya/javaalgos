package javaalgos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class LISAppTest {
	
	@Test //UVA 231
	public void testMissile() {
		int m = LISApp.maxMissilesIntercepted(new int[]{389, 207, 155, 300, 299, 170, 158, 65});
		assertTrue(m == 6);
		m = LISApp.maxMissilesIntercepted(new int[]{23, 34, 21});
		assertTrue(m == 2);
	}
}