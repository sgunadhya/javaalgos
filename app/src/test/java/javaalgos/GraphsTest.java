package javaalgos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class GraphsTest {
	@Test public void testGraph() {
		Graphs.Graph g = new Graphs.Graph();
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(3,2);
		g.addEdge(4,5);
		assertTrue(2 == g.neighbors(1).size());
		assertTrue(2 == g.dfs(4).size());
		assertTrue(3 == g.dfs(1).size());
		assertTrue(2 == g.bfs(4).size());
		assertTrue(3 == g.bfs(1).size());
		assertTrue(2 == g.connectedComps());

	}
}