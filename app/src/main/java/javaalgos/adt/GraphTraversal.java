package javaalgos.adt;

import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        Graph<Integer, Edge<Integer>> graph = new Graph<>();
        graph.addEdge(new Edge<>(0, 1));
        graph.addEdge(new Edge<>(0, 2));
        graph.addEdge(new Edge<>(0, 3));
        graph.addEdge(new Edge<>(1, 2));
        graph.addEdge(new Edge<>(2, 3));
        graph.addEdge(new Edge<>(3, 4));
    }

    /**
     * Depth first search
     * @param graph Graph to search
     * @param start Vertex to start from
     * @param <V> Vertex type
     */
    <V> void depthFirstSearch(Graph<V, Edge<V>> graph, V start) {
        Set<V> visited = new HashSet<>();
        dfs(graph, start, visited);
    }

    /**
     * Depth first search
     * @param graph Graph to search
     * @param start Vertex to start from
     * @param visited Visited vertices
     * @param <V> Vertex type
     */
    private <V> void dfs(Graph<V, Edge<V>> graph, V start, Set<V> visited) {
        visited.add(start);
        for (Edge<V> edge : graph.getEdges(start)) {
            if (!visited.contains(edge.getTo())) {
                dfs(graph, edge.getTo(), visited);
            }
        }
    }

    /**
     * Breadth first search
     * @param graph Graph to search
     * @param start Vertex to start from
     * @param <V> Vertex type
     */
    <V>  void breadthFirstSearch(Graph<V, Edge<V>> graph, V start) {
        Set<V> visited = new HashSet<>();
        visited.add(start);
        Queue<V> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Edge<V> edge : graph.getEdges(current)) {
                if (!visited.contains(edge.getTo())) {
                    visited.add(edge.getTo());
                    queue.offer(edge.getTo());
                }
            }
        }
    }

}
