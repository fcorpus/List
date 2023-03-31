package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;


public interface List<G> {
    void  addAtTail(G data) throws NotNullAllowedException;
    void  addAtFront(G data) throws NotNullAllowedException;
    void remove(int index) throws BadIndexException;
    void removeAll();
    void setAt(int index, G data) throws BadIndexException, NotNullAllowedException;
    G getAt(int index) throws BadIndexException;
    void removeAllWithValue(G data);
    int getSize();
    Iterator<G> getIterator();
}
