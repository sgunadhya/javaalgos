package javaalgos.adt;

public abstract class Graph<V extends Vertex, E extends Edge> implements GraphIterator<V, E>, GraphComputation<V, E> {
    public abstract void addEdge(E edge);
    public abstract void removeEdge(E edge);
    public abstract void addVertex(V vertex);
    public abstract void removeVertex(V vertex);
    public abstract boolean containsEdge(V vertex, V dest);
}
