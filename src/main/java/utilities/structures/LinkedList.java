package utilities.structures;

import java.util.ArrayList;

public class LinkedList<T> extends java.util.LinkedList<T> {
    /**
     * Converts this LinkedList<T> into an Array.
     * @return  T[].
     */
    public T[] toArray() {
        return (T[]) toArrayList().toArray();
    }

    /**
     * Converts this Linked List to an Array List.
     * @return  ArrayList<T>.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>(size());
        for (int i = 0; i < size(); ++i) arrayList.set(i, get(i));
        return arrayList;
    }
}


