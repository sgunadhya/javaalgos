package javaalgos.adt;

import java.util.Comparator;

public interface PartitionElement<T> {
    PartitionElement<T> findRepresentative();
    boolean sameComponent(PartitionElement<T> x);
    PartitionElement<T> union(PartitionElement<T> x, Comparator<? super T> comparator);

    PartitionElement<T> union(PartitionElement<T> x);
}
