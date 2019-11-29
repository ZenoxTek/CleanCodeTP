public class Node<T> {

    public Node<T> next;
    private T element;

    public Node(T element) {
        next = null;
        this.element = element;
    }

    public Node() {
        next = null;
    }

    public void setFinalNode() {
        this.next = null;
    }

    public void setNode(Node<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }
}
