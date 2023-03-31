package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

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
            tail = node;
        }else{
            tail.next = node;
            node.previous=tail;
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
            head = node;
            tail = node;
        }else{
            head.previous = node;
            node.next=head;
        }
        head = node;
        size++;
    }
    public void remove(int index)throws BadIndexException {
        Node<T> currentNode = head;
        if(index<0 || index>size){
            throw new BadIndexException();
        }
        for(int currentIndex = 0; currentIndex < index; currentIndex++){
            currentNode=currentNode.next;
        }
        size--;
    }
    public void removeAll(){
        Iterator<T> iterator = getIterator();
        while(iterator.hasNext()){
            iterator.Next();
            size--;
        }
    }
    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException{
        Node<T> currentNode = head;
        Iterator<T> iterator= null;
        if(index<0 || index>size){
            throw new BadIndexException();
        }
        if(data==null){
            throw new NotNullAllowedException();
        }
        do{
            currentNode=currentNode.next;
        }while(iterator.Next()!=data);
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
        Iterator<T> iterator = null;
        Node<T> currentNode=head;
        do{
            if(iterator.Next()==data) {
                currentNode.previous=currentNode.next;
            }
        }while(iterator.hasNext());
        /*for(Node currentNode = head; currentNode!=null; currentNode=currentNode.next){
            if(currentNode.data==data){
                currentNode.data=null;
                currentNode.previous=currentNode.next;
            }
        }*/
    }

    public int getSize() {
        return size;
    }
    public Iterator<T> getIterator(){
        return new LinkedListIterator<>(head);
    }
}
