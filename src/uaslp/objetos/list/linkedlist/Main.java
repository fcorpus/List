package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.arraylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        lista.addAtTail(  "algo" );
        System.out.println(lista.getSize());
        lista.addAtTail( "hola");
        lista.addAtTail("adios");
        lista.addAtFront("queso");
        System.out.println("new size: "+ lista.getSize());
        System.out.println(lista.getAt(2));
        lista.setAt(2,"new 2");
        System.out.println(lista.getAt(2));
        lista.remove(2);
        System.out.println("size after removing "+lista.getSize());
        lista.removeAll();
        System.out.println("size after removing all "+lista.getSize());
    }
}