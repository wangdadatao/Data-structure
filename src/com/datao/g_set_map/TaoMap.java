package com.datao.g_set_map;

public interface TaoMap<K, V> {

    void add(K k, V v);

    V remove(K k);

    boolean contains(K k);

    V get(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();

}
