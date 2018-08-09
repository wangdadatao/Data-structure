### 链表

- 动态数组
- 栈
- 队列

        - 底层依托的静态数组，靠resize解决静态数组固定容量的问题

- 链表  
   - 真正的动态数据结构
   - 最简单的动态数据结构
   - 更深入的理解引用（指针）
   - 跟家深入的理解递归
   - 辅助组成其他数据结构
   
### Linked List
- 数据粗存在“节点”(Node)中
- ![avatar](imgs/TIM截图20180809095156.png)
- 优点:真正的动态，不需要处理固定容量问题
- 缺点：丧失了随机访问的能力

### 数组和链表对比
- 数组
    - 数组最好处理索引有语意的情况
    - 最大的优点：支持快速查询
- 链表
    - 链表不适合用于索引有语意的情况
    - 最大优点：动态    
  
    
### 时间复杂度
- 添加元素
    - addLast(e)    O(n)
    - addFirst(e)   O(1)
    - add(index, e) O(n/2) = O(n)
- 删除操作
    - removeLast(e) O(n)
    - removeFirst(e)    O(1)
    - remove(index, e)  O(n/2) = O(n)
- 修改操作
    - set(index, e) O(n)
- 查找操作
    - get(index)    O(n)
    - contains(e)   O(n)
    