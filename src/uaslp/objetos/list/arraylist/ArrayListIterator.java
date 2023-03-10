package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator {
    private ArrayList arrayList;
    private int currentIndex=0;
    public ArrayListIterator(ArrayList arrayList){
        this.arrayList=arrayList;
    }
    public boolean hasNext(){
        return currentIndex < arrayList.getSize();
    }
    public String Next(){
        String data= arrayList.getAt(currentIndex);
        currentIndex++;
        return  data;
    }
}
