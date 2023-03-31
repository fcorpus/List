package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;

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
    public H Next() {
        H data = null;
        try {
            data = arrayList.getAt(currentIndex);
        } catch (BadIndexException ignored) {
        }
        currentIndex++;
        return data;
    }
}
