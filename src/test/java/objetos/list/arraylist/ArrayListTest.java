package objetos.list.arraylist;

import objetos.list.Iterator;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void whenListIsCreated_thenIsEmpty() {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 0);
        Assertions.assertTrue(isEmpty);
    }

    @Test
    public void whenListIsCreated_thenIsJustEmpty() throws NotNullAllowedException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        boolean Empty = list.isEmpty();
        //validation
        Assertions.assertTrue(Empty);
    }

    @Test
    public void whenListIsCreated_thenFirstElementInserted() throws NotNullAllowedException, BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        list.addAtFront("1");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 1);
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void whenListIsCreated_thenFirstElementInsertedNull() throws NotNullAllowedException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 0);
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void whenListIsCreated_thenFirstElementsInsertedMoreElements() throws NotNullAllowedException, BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("2");
        list.addAtFront("1");
        //execution
        list.addAtFront("0");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 3);
        Assertions.assertEquals("0", list.getAt(0));
        Assertions.assertEquals("2", list.getAt(2));
    }

    @Test
    public void whenListIsCreated_thenFirstElementsInsertedAtTail() throws NotNullAllowedException, BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        list.addAtTail("0");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 1);
        Assertions.assertEquals("0", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void whenListIsCreated_thenFirstElementInsertedMoreElementsAtTail() throws NotNullAllowedException, BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("0");
        //execution
        list.addAtTail("1");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 2);
        Assertions.assertEquals("0", list.getAt(0));
        Assertions.assertEquals("1", list.getAt(1));
    }

    @Test
    public void whenListIsCreated_thenFirstElementIsRemovedWithIndexException() throws BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(1));
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 0);
    }

    @Test
    public void whenListIsCreated_thenFirstElementIsRemoved() throws NotNullAllowedException, BadIndexException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        //execution
        list.remove(0);
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AddingTwoElements_thenAreRemove()throws  NotNullAllowedException,BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        //execution
        list.remove(1);
        list.remove(0);
        list.remove(1);
        list.remove(0);
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size,2);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_addingElementAndSettingAtIt() throws NotNullAllowedException, BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("1");
        list.addAtFront("2");
        //execution
        list.setAt(2,"22");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(list.getAt(2),"22");
        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_addingElementsAndRemovingThemAll() throws NotNullAllowedException, BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        //execution
        list.removeAll();
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_addingElementsThenRemovingThemTryingTheException() throws NotNullAllowedException, BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("0");
        list.addAtFront("0");
        //execution
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.removeAllWithValue(null));
        //list.removeAllWithValue(null);
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_addingElementsThenRemovingSpecificValues() throws NotNullAllowedException, BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("44");
        list.addAtFront("3");
        list.addAtFront("2");
        //execution
        list.removeAllWithValue("44");
        int size = list.getSize();
        //validation
        Assertions.assertEquals(size, 3);
        Assertions.assertEquals(list.getAt(2),"1");
        Assertions.assertEquals(list.getAt(1),"3");
        Assertions.assertEquals(list.getAt(0),"2");
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_SettingElementsAndExceptionComeUp() throws BadIndexException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        Assertions.assertThrows(BadIndexException.class,() -> list.setAt(1,"5"));
        //validation
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListCreated_addAtTailTryingException() throws NotNullAllowedException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        Assertions.assertThrows(NotNullAllowedException.class,() -> list.addAtTail(null));
        //validation
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListCreated_increaseSizeByAddingAtTail() throws NotNullAllowedException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        //execution
        list.addAtTail("2");
        list.addAtTail("2");
        list.addAtTail("2");
        //validation
        Assertions.assertEquals(3,list.getSize());
    }
    @Test
    public void whenListCreated_setAtTryingException() throws BadIndexException,NotNullAllowedException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("2");
        list.addAtTail("2");
        //execution
        Assertions.assertThrows(NotNullAllowedException.class,() -> list.setAt(1,null));
    }
    @Test
    public void whenListCreated_getAtTryingException() throws BadIndexException, NotNullAllowedException {
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("2");
        list.addAtTail("2");
        list.addAtTail("2");
        //execution
        Assertions.assertThrows(BadIndexException.class,() -> list.getAt(3));
        //validation
        Assertions.assertEquals(3,list.getSize());
    }
    @Test
    public void tryingIterator() throws NotNullAllowedException{
        //initialization
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("2");
        list.addAtTail("2");
        list.addAtTail("2");
        list.addAtTail("2");
        //execution
        Iterator<String> iterator = list.getIterator();
        while (iterator.hasNext()) {
            iterator.Next();
        }
        //validation
        Assertions.assertEquals(null,iterator.Next());
    }
}
