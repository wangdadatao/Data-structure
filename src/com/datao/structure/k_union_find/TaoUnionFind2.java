package com.datao.structure.k_union_find;

/**
 * Quick Union
 *
 * @author datao
 */
public class TaoUnionFind2 implements UnionFind {

    private int[] parent;

    public TaoUnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        parent[pRoot] = qRoot;
    }

    /**
     * 从当前节点开始查询到根节点
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
