import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    public TestNode testNode;

    @Before
    public void setUp() throws Exception {
        testNode = new TestNode(1, "Coucou je suis un test");
    }

    @Test
    public void getSize() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();

        assertEquals(0, nodes.getSize());

        nodes.addNodeAtStartOfList(testNode);

        assertEquals(1, nodes.getSize());
    }

    @Test
    public void addNodeAtEndOfList() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();

        nodes.addNodeAtEndOfList(testNode);

        assertEquals(1, nodes.getNodeAtIndex(0).getElement().testInt);

        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");

        nodes.addNodeAtEndOfList(testNodeTwo);

        nodes.addNodeAtEndOfList(testNode);
        nodes.addNodeAtEndOfList(testNode);

        assertEquals(2, nodes.getNodeAtIndex(1).getElement().testInt);
    }

    @Test
    public void addNodeAtStartOfList() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();

        nodes.addNodeAtStartOfList(testNode);

        assertEquals(1, nodes.getNodeAtIndex(0).getElement().testInt);

        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");

        nodes.addNodeAtStartOfList(testNodeTwo);

        assertEquals(2, nodes.getNodeAtIndex(0).getElement().testInt);
    }

    @Test
    public void addNodeAtIndex() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();

        assertTrue(nodes.addNodeAtIndex(testNode, 0));

        assertEquals(1, nodes.getNodeAtIndex(0).getElement().testInt);

        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");

        assertFalse(nodes.addNodeAtIndex(testNode, 10));

        nodes.addNodeAtStartOfList(testNodeTwo);
        nodes.addNodeAtStartOfList(testNodeTwo);

        assertTrue(nodes.addNodeAtIndex(testNode, 2));
        assertEquals(4, nodes.getSize());
    }

    @Test
    public void deleteNodeAtIndex() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");
        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNodeTwo);

        assertTrue(nodes.deleteNodeAtIndex(1));
        assertEquals(1, nodes.getSize());
        assertFalse(nodes.deleteNodeAtIndex(1));
        assertTrue(nodes.deleteNodeAtIndex(0));
        assertEquals(0, nodes.getSize());
        assertFalse(nodes.deleteNodeAtIndex(0));
    }

    @Test
    public void deleteNode() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");
        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNode);
        assertTrue(nodes.deleteNode(testNode));
        assertEquals(1, nodes.getSize());
        assertTrue(nodes.deleteNode(testNode));
        assertFalse(nodes.deleteNode(testNode));
        assertEquals(0, nodes.getSize());
    }

    @Test
    public void getNodeAtIndex() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un test");

        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNodeTwo);

        assertEquals(2, nodes.getNodeAtIndex(0).getElement().testInt);
        assertEquals(1, nodes.getNodeAtIndex(1).getElement().testInt);
        Node<TestNode> head = nodes.getNodeAtIndex(-1);
        assertNull(nodes.getNodeAtIndex(10));
    }

    @Test
    public void getIndexFromNode() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un");
        TestNode testNodeThree = new TestNode(3, "Coucou je suis un test");

        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNodeTwo);

        assertEquals(0, nodes.getIndexFromNode(testNodeTwo));
        assertEquals(1, nodes.getIndexFromNode(testNode));
        assertEquals(-1, nodes.getIndexFromNode(testNodeThree));
    }

    @Test
    public void getFirstNode() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un");
        assertNull(nodes.getFirstNode());
        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNodeTwo);
        assertEquals(2, nodes.getFirstNode().getElement().testInt);
    }

    @Test
    public void getLastNode() {
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();
        TestNode testNodeTwo = new TestNode(2, "Coucou je suis un");
        assertNull(nodes.getLastNode());
        nodes.addNodeAtStartOfList(testNode);
        nodes.addNodeAtStartOfList(testNodeTwo);
        assertEquals(1, nodes.getLastNode().getElement().testInt);
    }
}