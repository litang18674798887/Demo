package com.li.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : litang
 * @date : Create in 2020/11/21
 * @Description
 *
 *   LinkedHashMap 这种映射非常适合构建LRU缓存
 *   This kind of map is well-suited to building LRU caches
 */
public class LinkedHashMapImpl<K,V> extends LinkedHashMap<K,V> {

    // 缓存坑位
    private int capacity;

    public LinkedHashMapImpl(int capacity) {

        /**
         * Constructs an empty <tt>LinkedHashMap</tt> instance with the
         * specified initial capacity, load factor and ordering mode.
         *
         * @param  initialCapacity the initial capacity
         * @param  loadFactor      the load factor
         * @param  accessOrder     the ordering mode - <tt>true</tt> for
         *         access-order, <tt>false</tt> for insertion-order
         * @throws IllegalArgumentException if the initial capacity is negative
         *         or the load factor is nonpositive
         */
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        return super.size() > capacity;
    }

    public static void main(String[] args) {

        LinkedHashMapImpl linkedHashMap = new LinkedHashMapImpl(3);
        linkedHashMap.put(1,"a");
        linkedHashMap.put(2,"a");
        linkedHashMap.put(3,"a");
        System.out.println(linkedHashMap.keySet());

        linkedHashMap.put(4,"d");
        System.out.println(linkedHashMap.keySet());
    }
}
