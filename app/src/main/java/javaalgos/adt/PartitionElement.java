package javaalgos.adt;

public interface PartitionElement<T> {
    PartitionElement<T> findRepresentative();
    boolean sameComponent(PartitionElement<T> x);
    PartitionElement<T> union(PartitionElement<T> x);
}
