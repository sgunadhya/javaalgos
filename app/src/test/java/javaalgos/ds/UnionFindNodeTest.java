package javaalgos.ds;

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



}