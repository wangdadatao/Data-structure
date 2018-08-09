package com.datao.a_array;

/**
 * @author datao
 */
public class TaoArray<E> {

    private E[] data;

    private int size;

    /**
     * 构造函数
     *
     * @param capacity 传入数组的默认容量
     */
    public TaoArray(Integer capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认长度为10
     */
    public TaoArray() {
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
    public void addLast(E e) {
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
    public void addFirst(E e) {
        insert(0, e);
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Array failed,Require index >= 0, index <= size ");
        }

        if (size == getCapaticy()) {
            resize(2 * data.length);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
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
    public E get(int index) {
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
    public void set(int index, E e) {
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
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Remove failed, Require index >= 0, index <= size ");
        }

        E result = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        //不是必须，建议设为null,  loitering objects != memory leak
        data[size - 1] = null;

        size--;


        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return result;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素
     * 删除查找到的第一个元素
     *
     * @param e 要删除的元素
     * @return 要删除的元素的索引
     */
    public int removeElement(E e) {
        //查找数组中是否存在
        int index = find(e);

        if (index != -1) {
            remove(index);
        }

        return index;
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }
}
