package ru.sberbank;

import java.util.*;

public class CountMapClass<K> implements CountMap<K> {

    HashMap<K,Integer> map = new HashMap<>();

    @Override
    public void add(K key) {
        if (map.containsKey(key)) {
            Integer counter = map.get(key);
            map.put(key, counter+1);
        } else {
            map.put(key, 1);
        }
    }

    @Override
    public int getCount(K key) {
        return map.get(key);
    }

    @Override
    public int remove(K key) {
        Integer counter = map.get(key);
        map.remove(key);
        return counter;
    }

    @Override
    public int size() {
//        Set<K> keys = map.keySet();
//        int count = 0;
//        for (K key : keys) {
//            if (map.get(key) != null) {
//                count +=1;
//            }
//        }
//        return count;
        return map.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        Set<K> keys = source.toMap().keySet();
        for (K key : keys) {
            if (map.containsKey(key)) {
                Integer counter = map.get(key);
                Integer sour = (Integer) source.toMap().get(key);
                map.put(key, counter + sour);
            } else {
                Integer sour = (Integer) source.toMap().get(key);
                map.put(key, sour);
            }
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(map);
    }
}
