package uaslp.objetos.list;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.arraylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        List lista1 = new LinkedList();
        List lista2 = new ArrayList();
        System.out.println("------------------------------\n LinkedList:\n");
        lista1.addAtTail("A");
        lista1.addAtTail("B");
        lista1.addAtTail("C");
        lista1.addAtTail("D");
        lista1.addAtFront("Abecedario:");
        System.out.println("size: "+ lista1.getSize());
        printList(lista1);
        System.out.println("------------------------------\n ArrayList:\n");
        lista2.addAtTail(  "F" );
        lista2.addAtTail( "G");
        lista2.addAtTail("H");
        lista2.addAtFront("E");
        System.out.println("size: "+ lista2.getSize());
        printList(lista2);
        System.out.println("linkedlist en la posicion 3:" + lista1.getAt(3) );
        System.out.println("arraylist en la posicion 2:" + lista1.getAt(2) );
        lista1.removeAll();
        lista2.removeAll();
        System.out.println("la linkedlist ha sido borrada por lo que su tamaño es: " + lista1.getSize());
        System.out.println("la arraylist ha sido borrada por lo que su tamaño es: " + lista2.getSize());
    }
    public static void printList(List lista){
        Iterator iterator = lista.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.Next());
        }
    }
}