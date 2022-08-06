package javaalgos.adt;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface GraphComputation<V extends Vertex, E extends  Edge> {
    Set<Set<V>> connectedComponents();

    List<E> getCycle();

    List<V> topologicalOrder();

    Iterator<E> shortestPath();
}
