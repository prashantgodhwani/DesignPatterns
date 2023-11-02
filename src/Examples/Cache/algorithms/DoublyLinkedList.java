package Examples.Cache.algorithms;

public class DoublyLinkedList<E> {

    private DoublyLinkedListNode<E> head;

    private DoublyLinkedListNode<E> tail;

    private int size;

    public DoublyLinkedList(){
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    public DoublyLinkedListNode<E> add(DoublyLinkedListNode<E> newNode){
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
        return newNode;
    }

    public DoublyLinkedListNode<E> add(E key){
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(key);
        return add(newNode);
    }

    public int getSize(){
        return size;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (head.next != tail) {
            return head.next;
        }

        return null;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (tail.prev != head) {
            return tail.prev;
        }

        return null;
    }

    public void detach(DoublyLinkedListNode<E> node) {
        if(node != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }
}
