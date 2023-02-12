package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public void addAtTail(String data) {
        Node node =new Node();
        node.data = data;
        node.previous = tail;
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
    public void addAtFront(String data){
        Node node = new Node();
        node.data =data;
        node.next = head;
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
    public void remove(int index){
        Node currentNode = head;
        for(int currentIndex = 0; currentIndex < index; currentIndex++){
            currentNode=currentNode.next;
        }
        size--;
    }
    public void removeAll(){
        for(Node currentNode = tail ; currentNode != null; currentNode = currentNode.previous){
            currentNode=null;
            size--;
        }
    }
    public void setAt(int index, String data){
        Node currentNode = head;
        LinkedListIterator iterator= null;
        do{
            currentNode=currentNode.next;
        }while(iterator.Next()!=data);
    }
    public String getAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        Node currentNode = head;
        for(int currentIndex = 0 ; currentIndex < index; currentIndex++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }
    public void removeAllWithValue(String data){
        LinkedListIterator iterator = null;
        Node currentNode=head;
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
    public LinkedListIterator getIterator(){
        return new LinkedListIterator(head);
    }
}
