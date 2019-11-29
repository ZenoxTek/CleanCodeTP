public class Main {

    public static void main(String[] args) {
        TestNode node = new TestNode(2, "Coucou c'est un test");
        LinkedList<TestNode> nodes = new LinkedList<TestNode>();

        nodes.addNodeAtStartOfList(node);
        TestNode node2 = new TestNode(1, "First changed");
        nodes.addNodeAtEndOfList(node2);

        TestNode node3 = new TestNode(0, "Back to first");

        nodes.addNodeAtStartOfList(node3);

        TestNode nodeAtIndex = new TestNode(10, "I'm a node and I want to be at a specific index");


        if (nodes.addNodeAtIndex(nodeAtIndex, 1)) {
            System.out.println("It works");
        }

        if (!nodes.addNodeAtIndex(nodeAtIndex, 10)) {
            System.out.println("It doesn't works");
        }


        for (int i = 0; i < nodes.getSize(); i++) {
            if (nodes.getNodeAtIndex(i) != null)
                System.out.println(nodes.getNodeAtIndex(i).getElement().toString());
            else
                System.out.println("Null");
        }
    }
}
