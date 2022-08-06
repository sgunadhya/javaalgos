package javaalgos.adt;

import java.util.Iterator;

public interface GraphIterator<V extends Vertex, E extends Edge> {
    Iterator<E> edgesFrom(V vertex);

    Iterator<E> edgesTo(V vertex);

    Iterator<V> vertices();
}
