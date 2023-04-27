package objetos.list.linkedlist;

import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
public class LinkedListTest {
    @Test
    public void whenListIsCreated_thenItIsEmpty(){
        //initialization
        LinkedList<String> list = new LinkedList<>();
        //execution
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();
        //validation
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0, size);
    }
    @Test
    public void whenListIsCreated_thenAddAtTail() throws BadIndexException, NotNullAllowedException {
        //initialization
        LinkedList<String> list = new LinkedList<>();
        //execution
        list.addAtTail("0");
        //validation
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("0", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenAListHasAnElement_addAtTail() throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("0");
        //execution
        list.addAtTail("1");
        //validation
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertEquals("0",list.getAt(0));
    }
    @Test
    public void whenListIsCreated_addAtFront() throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        //execution
        list.addAtFront("0");
        //validation
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("0",list.getAt(0));
    }
    @Test
    public void whenAListHasAnElement_addAtFront() throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        //execution
        list.addAtFront("0");
        //validation
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertEquals("0",list.getAt(0));
    }
    @Test
    public void whenListIsCreated_addAtFrontValueTryingException() throws BadIndexException, NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        //execution
        Assertions.assertThrows(NotNullAllowedException.class,()-> list.addAtFront(null));
        //validation
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_removeTryingException(){
        //initialization
        LinkedList<String> list = new LinkedList<>();
        //execution
        Assertions.assertThrows(BadIndexException.class,() -> list.remove(3));
        //validation
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListHasElements_removeTryingException() throws NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtFront("0");
        //execution
        Assertions.assertThrows(BadIndexException.class,() -> list.remove(3));
        //validation
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListWithElement_removeElement() throws BadIndexException, NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("23");
        //execution
        list.remove(0);
        //validation
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListWithElements_removeOne() throws NotNullAllowedException, BadIndexException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("33");
        list.addAtFront("22");
        list.addAtFront("11");
        //execution
        list.remove(1);
        //validation
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("33",list.getAt(1));
    }
    @Test
    public void whenListWithElements_removeAll() throws BadIndexException, NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("33");
        list.addAtFront("22");
        list.addAtFront("11");
        //execution
        list.removeAll();
        //validation
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListWithElements_useGet() throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("33");
        list.addAtFront("22");
        list.addAtFront("11");
        //execution
        String got = list.getAt(1);
        //validation
        Assertions.assertEquals("22",got);
    }
    @Test
    public void whenListWithElements_useSet()throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("33");
        list.addAtFront("22");
        list.addAtFront("11");
        //execution
        list.setAt(1,"55");
        //validation
        Assertions.assertEquals("55",list.getAt(1));
    }
    @Test
    public void whenListWithElements_removeAllWithValue() throws BadIndexException,NotNullAllowedException{
        //initialization
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("33");
        list.addAtFront("33");
        list.addAtFront("33");
        list.addAtFront("33");
        list.addAtFront("33");
        list.addAtFront("11");
        //execution
        list.removeAllWithValue("33");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(1,size);
        Assertions.assertFalse(list.isEmpty());
    }

}
