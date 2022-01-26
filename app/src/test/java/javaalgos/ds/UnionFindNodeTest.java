package javaalgos.ds;

import javaalgos.adt.PartitionElement;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class UnionFindNodeTest extends TestCase {

    UnionFindNode<Integer> unionFindNode;

    @Before
    public void setUp() {
        unionFindNode = new UnionFindNode<>(23);
    }

    @Test
    public void testRootNodeShouldBeRepresentative() {
        assertSame(this.unionFindNode.findRepresentative(), this.unionFindNode);
    }

    @Test
    public void testSameNodeShouldBelongToSameComponet() {
        assertTrue(this.unionFindNode.sameComponent(this.unionFindNode));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testUnionShouldThrowAnExceptionIfItIsNotMergedWithAnInstanceOfUnionFind() {

        PartitionElement<Integer> element = new PartitionElement<>() {
            @Override
            public PartitionElement<Integer> findRepresentative() {
                return null;
            }

            @Override
            public boolean sameComponent(PartitionElement<Integer> x) {
                return false;
            }

            @Override
            public PartitionElement<Integer> union(PartitionElement<Integer> x) {
                return null;
            }
        };
        this.unionFindNode.union(element);
    }


}