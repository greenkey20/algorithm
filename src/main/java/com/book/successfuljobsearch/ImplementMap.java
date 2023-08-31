package com.book.successfuljobsearch;

import java.util.ArrayList;
import java.util.List;

// 2023.8.31(목) 18h40
public class ImplementMap {
    // 멤버변수
    private String key;
    private String value;
    public static List<ImplementMap> implementMaps = new ArrayList<>();

    // 생성자
    public ImplementMap() {
    }

    public ImplementMap(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // getter + setter
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ImplementMap> getImplementMaps() {
        return implementMaps;
    }

    public void setImplementMaps(List<ImplementMap> implementMaps) {
        ImplementMap.implementMaps = implementMaps;
    }

    // toString() 오버라이딩


    @Override
    public String toString() {
        return "ImplementMap{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // Map의 메서드/기능 구현
    public void put(String key, String value) {
        ImplementMap implementMap = new ImplementMap(key, value);

        if (ImplementMap.implementMaps.size() == 0) {
            ImplementMap.implementMaps = new ArrayList<>();
            ImplementMap.implementMaps.add(implementMap);
        } else {
            ImplementMap.implementMaps.add(implementMap);
        }
    }

    public static String get(String key) {
        String value = null;

        for (ImplementMap implementMap : ImplementMap.implementMaps) {
            if (key.equals(implementMap.getKey())) {
                value = implementMap.getValue();
            }
        }

        return value;
    }

    public static int size() {
        return ImplementMap.implementMaps.size();
    }
}
