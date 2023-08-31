package com.book.successfuljobsearch;

import java.util.ArrayList;
import java.util.List;

// 2023.8.31(목) 19h30
public class ImplementMapV2 {
    // 멤버 변수
    public class Element {
        private String key;
        private String value;

        public Element(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static List<Element> map = new ArrayList<>();

    // Map의 메서드/기능 구현
    public void put(String key, String value) {
        Element element = new Element(key, value);

        if (map.size() == 0) {
            List<Element> map = new ArrayList<>();

            map.add(element);
        } else {
            map.add(element);
        }
    }

    public String get(String key) {
        String value = null;




        return value;
    }

    public int size() {
        return map.size();
    }
}
