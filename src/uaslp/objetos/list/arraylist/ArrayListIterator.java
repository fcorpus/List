package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator<H> implements Iterator<H> {
    private final ArrayList<H> arrayList;
    private int currentIndex;
    public ArrayListIterator(ArrayList<H> arrayList){
        this.arrayList=arrayList;
        currentIndex=0;
    }
    public boolean hasNext(){
        return currentIndex < arrayList.getSize();
    }
    public H Next(){
        H data= arrayList.getAt(currentIndex);
        currentIndex++;
        return  data;
    }
}
