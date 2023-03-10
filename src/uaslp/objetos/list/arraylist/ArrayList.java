package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList implements List {
    private static final int INITIAL_SIZE = 2;
    private String []array;
    private int size;
    public ArrayList(){
        array = new String[INITIAL_SIZE];
    }
    public void  addAtTail(String data){
        if(size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void  addAtFront(String data){
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
        }else{
            if(index==size) {
                array[index]=null;
            }
        }
        size--;
    }
    public void removeAll(){
        for(int i=0;i<size;i++){
            array[i]=null;
        }
        size=0;
    }
    public void setAt(int index, String data){
        array[index]=data;
    }
    public String getAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return array[index];
    }
    public void removeAllWithValue(String data){
        int auxiliarySize=size;
        for(int i=0;i<auxiliarySize;i++){
            if(array[i]==data) {
                array[i] = array[i+1];
                size--;
            }
        }
    }

    public int getSize() {
        return size;
    }
    private void increaseSize(){
        String []newArray = new String[array.length * 2];
        for(int i =0; i<array.length;i++){
            newArray[i]=array[i];
        }
        array = newArray;
    }
    public Iterator getIterator(){return  new ArrayListIterator(this);}
}
