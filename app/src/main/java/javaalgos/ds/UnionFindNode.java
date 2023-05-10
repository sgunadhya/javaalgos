package javaalgos.ds;

import javaalgos.adt.PartitionElement;

import java.util.Comparator;

public class UnionFindNode<T extends Comparable<T>> implements PartitionElement<T> {
    UnionFindNode<T> parentNode;
    int rank;
    T data;

    public UnionFindNode(T data) {
        this.data = data;
        this.parentNode = this;
        this.rank = 0;
    }

    @Override
    public PartitionElement<T> findRepresentative() {
        if(this != this.parentNode) {
            return this.parentNode.findRepresentative();
        }else {
            return this.parentNode;
        }
    }

    @Override
    public boolean sameComponent(PartitionElement<T> x) {
        return x != null && x.findRepresentative() == this.findRepresentative();
    }

    @Override
    public PartitionElement<T> union(PartitionElement<T> x, Comparator<? super T> comparator) {
        if(x == null) {
            return this;
        }
        UnionFindNode<T> xRep = (UnionFindNode<T>) x.findRepresentative();
        UnionFindNode<T> thisRep = (UnionFindNode<T>) this.findRepresentative();
        if(xRep == thisRep) {
            return thisRep;
        }
        if(comparator.compare(xRep.data, thisRep.data) < 0) {
            xRep.parentNode = thisRep;
            return thisRep;
        }else {
            thisRep.parentNode = xRep;
            return xRep;
        }
    }

    @Override
    public PartitionElement<T> union(PartitionElement<T> x) {
        return union(x, Comparator.naturalOrder()) ;
    }

    @Override
    public String toString() {
        return String.format("UnionFindNode{data=%s}", data);
    }
}
