package Examples.Cache.algorithms;

public class DoublyLinkedListNode<E> {

    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;
    int accessCount;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
        this.accessCount = 1;
    }

    public E getElement() {
        return element;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void incrementAccessCount(){
        this.accessCount += 1;
    }
}
