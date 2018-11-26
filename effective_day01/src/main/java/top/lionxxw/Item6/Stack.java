package top.lionxxw.Item6;// Can you spot the "memory leak"?

import java.util.*;

/**
 * 第六点：消除过期的对象引用
 * can you spot the "memory leak"? 你能发现内存泄漏吗？
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        // 修复理念：一旦对象引用已经过期，只需清空这些引用即可。
        elements[size] = null;  // Eliminate obsolete reference 淘汰过时的引用
        return result;
    }

    /*public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        *//**
     * 为什么是这里会发生内存泄漏呢？
     * 如果一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被当成垃圾回收，即使使用栈的程序不再引用
     * 这些对象，它们也不会被回收。这是因为，栈内部维护着对这些对象的过期引用（obsolete reference）。所谓的
     * 过期引用，是指永远也不会再被解除的引用。
     * 在本例中，凡是在elements数组的“活动部分（active portion）”之外的任何引用都是过期的。活动部分是指elements
     * 中下标小于size的那些元素。
     *//*
        return elements[--size]; // 存在内存泄漏
    }
*/
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
