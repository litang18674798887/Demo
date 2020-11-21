package com.li.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * 特性要求：
 * 1.必须要有顺序之分，一区分最近使用的和很久没有使用的数据排序
 * 2.写和读操作一次搞定
 * 3.如果容量满了要删除最不常用的数据，每次新访问还要把新的数据插入到队头
 * <p>
 * <p>
 * LRU 的算法核心是哈希链表
 * HashMap + 双向链表
 */
public class LRUCache {

    // map 负责查找，构建一个虚拟的双向链表，它里面安装的就是一个node节点，作为载体

    // 构造一个node节点作为数据载体
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    static class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        // 构造方法
        public DoubleLinkedList() {
            head = new Node<K, V>();
            tail = new Node<K, V>();
            head.next = tail;
            tail.pre = head;
        }

        // 添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        public Node getLast() {
            return tail.pre;
        }
    }


    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;


    public LRUCache(int capacity) {

        this.cacheSize = capacity;
        map = new HashMap<Integer, Node<Integer, Integer>>();
        doubleLinkedList = new DoubleLinkedList<Integer, Integer>();
    }

    int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == cacheSize) {
                Node<Integer, Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);

            }
            // 新增
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);

        }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);


        lruCache.put(4, 4);
        int i = lruCache.get(3);

        System.out.println(lruCache.map.keySet());
    }

}
