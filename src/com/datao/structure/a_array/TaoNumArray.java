package com.datao.structure.a_array;

/**
 * @author datao
 */
public class TaoNumArray {

    private int[] data;

    private int size;

    /**
     * 构造函数
     *
     * @param capacity 传入数组的默认容量
     */
    public TaoNumArray(int capacity) {
        this.data = new int[capacity];
        size = 0;
    }

    /**
     * 默认长度为10
     */
    public TaoNumArray() {
        this(10);
    }

    /**
     * 查询元素数量
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 查询总容量
     *
     * @return
     */
    public int getCapaticy() {
        return this.data.length;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 末尾添加元素
     *
     * @param e 新增的元素
     */
    public void addLast(int e) {
/*        if (size == getCapaticy()) {
            throw new IllegalArgumentException("AddLast failed, Array is full ");
        }

        data[size] = e;
        size++;*/
        insert(size, e);
    }

    /**
     * 首部添加元素
     *
     * @param e 新增的元素
     */
    public void addFirst(int e) {
        insert(0, e);
    }

    public void insert(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Array failed,Require index >= 0, index <= size ");
        }

        if (size == getCapaticy()) {
            throw new IllegalArgumentException("Array failed, Array is full ");
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Array: size = %d , capacity = %d --> ", size, data.length));

        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]).append(",");
        }
        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }

    /**
     * 获取数组中的某一位元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Get failed, Require index >= 0, index <= size ");
        }

        return data[index];
    }

    /**
     * 更新某个小标的元素
     *
     * @param index 下标
     * @param e     元素
     */
    public void set(int index, int e) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Set failed, Require index >= 0, index <= size ");
        }

        data[index] = e;
    }

    /**
     * 判断是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }


    /**
     * 查询某个元素的索引
     *
     * @param e 元素
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除某个索引的元素
     *
     * @param index 索引
     */
    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Remove failed, Require index >= 0, index <= size ");
        }

        int result = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        //此步骤可以省略
        data[size - 1] = 0;

        size--;

        return result;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素
     * 删除查找到的第一个元素
     *
     * @param e 要删除的元素
     * @return 要删除的元素的索引
     */
    public int removeElement(int e) {
        //查找数组中是否存在
        int index = find(e);

        if (index != -1) {
            remove(index);
        }

        return index;
    }
}
