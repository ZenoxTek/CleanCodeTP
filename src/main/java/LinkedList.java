public class LinkedList<T> {

    private Node<T> head = null;
    private int numberOfElements;

    public LinkedList() {
        numberOfElements = 0;
        head = new Node<T>();
        head.next = null;
    }

    public int getSize() {
        return numberOfElements;
    }

    public void addNodeAtEndOfList(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isListEmpty()) {
            addNodeOnEmptyList(newNode);
            return;
        }
        Node<T> temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.setFinalNode();
        temp.setNode(newNode);
        increaseNumberOfElements();
    }

    private void increaseNumberOfElements() {
        numberOfElements++;
    }

    private void decreaseNumberOfElements() {
        numberOfElements--;
    }

    public void addNodeAtStartOfList(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isListEmpty()) {
            addNodeOnEmptyList(newNode);
            return;
        }
        newNode.setNode(head.next);
        head.setNode(newNode);
        increaseNumberOfElements();
    }

    private void addNodeOnEmptyList(Node<T> node) {
        node.setFinalNode();
        head.setNode(node);
        increaseNumberOfElements();
    }

    public boolean addNodeAtIndex(T element, int index) {
        if (index == 0) {
            addNodeAtStartOfList(element);
            return true;
        }
        if (!isIndexInRange(index)) {
            return false;
        }
        Node<T> nodeAtIndex = getNodeAtIndex(index);
        Node<T> nodeBeforeIndex = getNodeAtIndex(index - 1);
        Node<T> newNode = new Node<T>(element);
        newNode.setNode(nodeAtIndex);
        nodeBeforeIndex.setNode(newNode);
        increaseNumberOfElements();
        return true;
    }

    public boolean deleteNodeAtIndex(int index) {
        if (isListEmpty()) {
            return false;
        }
        if (!isIndexInRange(index)) {
            return false;
        }
        Node<T> nodeBeforeDeletedOne = getNodeAtIndex(index - 1);
        if (nodeBeforeDeletedOne.next != null)
            nodeBeforeDeletedOne.setNode(nodeBeforeDeletedOne.next.next);
        decreaseNumberOfElements();
        return true;
    }

    public boolean deleteNode(T element) {
        int index = getIndexFromNode(element);
        if (index != -1) {
            if (isIndexInRange(index)) {
                deleteNodeAtIndex(index);
                return true;
            }
        }
        return false;
    }

    public Node<T> getNodeAtIndex(int index) {
        if (index == -1)
            return head;
        Node<T> temp = head.next;
        for (int i = 0; i < index; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

    public int getIndexFromNode(T element) {
        if (element == null)
            return -1;
        Node<T> temp = head.next;
        int i = 0;
        while (temp != null) {
            if (temp.getElement().equals(element))
                return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public Node<T> getFirstNode() {
        if (isListEmpty())
            return null;
        return head.next;
    }

    public Node<T> getLastNode() {
        if (isListEmpty())
            return null;
        Node<T> temp = head;
        int i = 0;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    private boolean isListEmpty() {
        return head.next == null;
    }

    private boolean isIndexInRange(int index) {
        if (index == -1)
            return true;
        Node<T> temp = head.next;
        for (int i = 0; i <= index; i++) {
            if (temp == null)
                return false;
            temp = temp.next;
        }
        return true;
    }
}
