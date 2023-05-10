package javaalgos.adt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph<V, E extends Edge<V>>{
    private final Map<V, Collection<E>> adjacencyList = new HashMap<>();

    /**
     * Adds an edge to the graph.
     * @param edge Edge to add
     */
    public void addEdge(E edge) {
        adjacencyList.computeIfAbsent(edge.getFrom(), k -> new ArrayList<>()).add(edge);
    }

    /**
     * Returns the edges connected to the given vertex.
     * @param vertex Vertex to get edges for
     * @return edges connected to the given vertex
     */
    public Collection<E> getEdges(V vertex) {
        return adjacencyList.get(vertex);
    }

    /**
     * Returns the vertices in the graph.
     * @return vertices in the graph
     */
    public Collection<V> getVertices() {
        return adjacencyList.keySet();
    }

}

