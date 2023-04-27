package objetos.list.linkedlist;

import objetos.list.Iterator;
import objetos.list.List;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size=0;
    public void addAtTail(T data) throws NotNullAllowedException {
        Node<T> node =new Node<>();
        node.data = data;
        node.previous = tail;
        if(data==null){
            throw new NotNullAllowedException();
        }
        if(head == null){
            head = node;
            //tail = node;
        }else{
            tail.next = node;
            //node.previous=tail;
        }
        tail = node;
        size++;
    }
    public void addAtFront(T data) throws NotNullAllowedException{
        Node<T> node = new Node<>();
        node.data =data;
        node.next = head;
        if(data==null){
            throw new NotNullAllowedException();
        }
        if(head == null){
            //head = node;
            tail = node;
        }else{
            head.previous = node;
            //node.next=head;
        }
        head = node;
        size++;
    }
    public void remove(int index)throws BadIndexException {
        //Node<T> currentNode = head;
        if(index<0 || index>size){
            throw new BadIndexException();
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;
        while(iterator.hasNext() && current_index != index) {
            iterator.Next();
            current_index++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;
    }
    public void removeAll(){
        Iterator<T> iterator = getIterator();
        while(iterator.hasNext()){
            iterator.Next();
            head= head.next;
        }
        head=null;
        size=0;
    }
    public void setAt(int index, T data){
        if(index>size||index<0){
            return;
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;
        while(iterator.hasNext() && current_index != index) {
            iterator.Next();
            current_index++;
        }
        iterator.getCurrentNode().data = data;
    }
    public T getAt(int index) throws BadIndexException{
        if(index < 0 || index >= size){
            throw new BadIndexException();
        }
        Node<T> currentNode = head;
        for(int currentIndex = 0 ; currentIndex < index; currentIndex++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }
    public void removeAllWithValue(T data){
        //checar valores
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            if(temp.data.equals(data)){
                deleteNode(temp);
                size--;
            }
            iterator.Next();
        }
    }
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    private void deleteNode(Node<T> node) {
        if(node == null) {
            return;
        }
        if(head == node && tail == node){
            head = null;
            tail = null;
            return;
        }
        if(head == node) {
            head = head.next;
            head.previous = null;
            return;
        }
        if(tail == node) {
            tail = tail.previous;
            tail.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public int getSize() {
        return size;
    }
    public Iterator<T> getIterator(){
        return new LinkedListIterator<>(head);
    }
}
