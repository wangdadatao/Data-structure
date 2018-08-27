package com.datao.k_union_find;

/**
 * 并查集接口
 *
 * @author datao
 */
public interface UnionFind {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);


}
