package objetos.list.linkedlist;

import objetos.list.Iterator;

public class LinkedListIterator<K> implements Iterator<K> {
    private  Node<K> currentNode;
    LinkedListIterator(Node<K> head){
        currentNode = head;
    }
    public boolean hasNext(){
        return currentNode!=null;
    }
    public K Next(){
        K data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
    public Node<K> getCurrentNode() {
        return currentNode;
    }
}
