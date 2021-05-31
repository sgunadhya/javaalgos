package javaalgos;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class StacksTest {
	
	@Test public void testReversePolishNotation() {
		String expression = "3,4,+,2,*,1,+";
		int r = Stacks.evaluateReversePolishExpression(expression);
		assertTrue(Integer.compare(r, 7) == 0);
	}
}