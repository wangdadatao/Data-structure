package com.datao.structure.n_hash;


import java.util.TreeMap;

public class TaoHashTable<K, V> {
    private TreeMap<K, V>[] hashTable;

    //容量
    private int M;

    //长度
    private int size;

    public TaoHashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }


    public TaoHashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * 增加
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V result = null;
        if (map.containsKey(key)) {
            result = map.remove(key);
            size--;
        }
        return result;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " 不存在！");
        }

        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }

}
