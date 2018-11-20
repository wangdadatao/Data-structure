package com.datao.structure.g_set_map;

public interface TaoSet<E> {

    void add(E e);

    void remove(E e);

    boolean comtains(E e);

    int getSize();

    boolean isEmpty();

}
