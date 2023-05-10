package javaalgos.adt;

public class Edge<V> {
    V from;
    V to;

    public Edge(V from, V to) {
        this.from = from;
        this.to = to;
    }

    public V getFrom() {
        return from;
    }

    public V getTo() {
        return to;
    }

}
