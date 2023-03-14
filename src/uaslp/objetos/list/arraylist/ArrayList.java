package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private T []array;
    private int size;
    private ArrayList<T> first;
    public ArrayList(){
        array = (T[])(new Object[INITIAL_SIZE]);
    }
    public void  addAtTail(T data){
        if(size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void  addAtFront(T data){
        if(size==array.length){
            increaseSize();
        }
        for(int i=size-1;i>=0;i--){
            array[i+1]=array[i];
        }
        array[0]= data;
        size++;
    }
    public void remove(int index) {
        if(index<size) {
            array[index] = array[index + 1];
            array[index + 1] = null;
            size--;
        }else{
            if(index==size) {
                array[index]=null;
                size--;
            }
        }
    }
    public void removeAll(){
        for(int i=0;i<size;i++){
            array[i]=null;
        }
        size=0;
    }
    public void setAt(int index, T data){
        array[index]=data;
    }
    public T getAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return (T)array[index];
    }
    public void removeAllWithValue(T data){
        int auxiliarySize=size;
        for(int i=0;i<auxiliarySize;i++){
            if(array[i].equals(data)) {
                array[i] = array[i+1];
                size--;
            }
        }
    }

    public int getSize() {
        return size;
    }
    private void increaseSize(){
         T[]newArray = (T[])(new Object[array.length * 2]);
         System.arraycopy(array,0,newArray,0,array.length);
         /*for(int i =0; i<array.length;i++){
            newArray[i]=array[i];
        }*/
        array = newArray;
    }
    public Iterator<T> getIterator(){return  new ArrayListIterator<>(this);}
}
