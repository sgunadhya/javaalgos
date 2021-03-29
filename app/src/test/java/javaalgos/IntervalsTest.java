package javaalgos;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class IntervalsTest {
	@Test public void testIntervalTree() {
		List<Intervals.Interval> l = new ArrayList<>();
		l.add(new Intervals.Interval(1914, 1918));
		l.add(new Intervals.Interval(1939, 1945));
		l.add(new Intervals.Interval(1920, 1925));
		l.add(new Intervals.Interval(1930, 1935));
		l.add(new Intervals.Interval(1901, 1950));
		l.add(new Intervals.Interval(1876, 1950));
		
		
		Intervals.IntervalTree t = new Intervals.IntervalTree(l);
		List<Intervals.Interval> r = t.findIntervals(1910);
		assert(2 == r.size());
	}
	
	@Test public void testMergeIntervals() {
		Set<Intervals.Interval> l = new HashSet<>();
		l.add(new Intervals.Interval(1914, 1918));
		l.add(new Intervals.Interval(1939, 1945));
		l.add(new Intervals.Interval(1920, 1925));
		l.add(new Intervals.Interval(1930, 1935));
		l.add(new Intervals.Interval(1901, 1950));
		l.add(new Intervals.Interval(1876, 1950));
		l.add(new Intervals.Interval(2000, 2003));
		List<Intervals.Interval> r = Intervals.union(l);
		assert(2 == r.size());
	}
}