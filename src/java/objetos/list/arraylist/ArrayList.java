package objetos.list.arraylist;

import objetos.list.Iterator;
import objetos.list.List;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private T []array;
    private int size;
    private ArrayList<T> first;
    public ArrayList(){
        array = (T[])(new Object[INITIAL_SIZE]);
    }
    public void  addAtTail(T data) throws NotNullAllowedException {
        if(data==null){
            throw new NotNullAllowedException();
        }
        if(size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void  addAtFront(T data) throws NotNullAllowedException{
        if(data==null){
            throw new NotNullAllowedException();
        }
        if(size==array.length){
            increaseSize();
        }
        for(int i=size-1;i>=0;i--){
            array[i+1]=array[i];
        }
        array[0]= data;
        size++;
    }
    public void remove(int index) throws BadIndexException {
        if(index>size || index<0){
            throw new BadIndexException();
        }
        if(index<size) {
            array[index] = array[index + 1];
            size--;
        }
    }
    public void removeAll(){
        for(int i=0;i<size;i++){
            array[i]=null;
        }
        size=0;
    }
    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException{
        if(index<0 || index > size){
            throw new BadIndexException();
        }
        if(data==null){
            throw new NotNullAllowedException();
        }
        array[index]=data;
    }
    public T getAt(int index) throws BadIndexException{
        if(index < 0 || index >= size){
            throw new BadIndexException();
        }
        return (T)array[index];
    }
    public void removeAllWithValue(T data)throws NotNullAllowedException{
        if(data==null){
            throw new NotNullAllowedException();
        }
        for(int i=size-1;i>=0;i--){
            if(array[i].equals(data)) {
                try {
                    remove(i);
                }catch(BadIndexException ignored){
                }
            }
        }
    }

    public boolean isEmpty(){
        return size==0;
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
