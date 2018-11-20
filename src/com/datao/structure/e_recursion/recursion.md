### Solution

#### 解决LeetCode 203号问题
    问题连接： https://leetcode-cn.com/problems/remove-linked-list-elements/description/
    
    问题描述：
    删除链表中等于给定值 val 的所有节点。
    示例:
    
    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5


- removeElements1 常规循环判断删除
- removeElements2 加入虚拟头部，循环判断
- removeElements3

### 递归
- 本质上，将原来的问题，转化为更小的同一问题

### 链表与递归
- 链表天然的递归性
- 栈的应用
    - 程序调用的系统栈
    - 递归调用的代价；函数调用 + 系统栈空间
    - 递归嵌套数量级很大时会出现内存不够
