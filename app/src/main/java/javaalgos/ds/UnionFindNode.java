package javaalgos.ds;

import javaalgos.adt.PartitionElement;

public class UnionFindNode<T> implements PartitionElement<T> {
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
    public PartitionElement<T> union(PartitionElement<T> x) {
        if(!(x instanceof UnionFindNode)){
            throw new IllegalArgumentException();
        }
        UnionFindNode<T> representativeOther = (UnionFindNode<T>) x.findRepresentative();
        UnionFindNode<T> representativeThis = (UnionFindNode<T>) this.findRepresentative();
        if(representativeOther == representativeThis) {
            return representativeOther;
        }
        if(representativeOther.rank > representativeThis.rank) {
            representativeThis.parentNode = representativeOther;
            return representativeOther;
        }else{
            representativeOther.parentNode = representativeThis;
            if(representativeOther.rank == representativeThis.rank) {
                representativeThis.rank++;
            }
            return representativeThis;
        }
    }

    @Override
    public String toString() {
        return String.format("UnionFindNode{data=%s}", data);
    }
}
