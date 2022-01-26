package javaalgos.ds;

import javaalgos.adt.PartitionElement;

public class UnionFindNode<T> implements PartitionElement<T> {
    private UnionFindNode<T> parentNode;
    private int rank;
    private T data;

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
        return null;
    }

    @Override
    public String toString() {
        return String.format("UnionFindNode{data=%s}", data);
    }

    public UnionFindNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(UnionFindNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
