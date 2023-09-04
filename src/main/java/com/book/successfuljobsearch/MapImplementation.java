package com.book.successfuljobsearch;

import java.util.ArrayList;
import java.util.List;

// 2023.8.31(목) 18h40
/**
 * key와 값으로 구성되는 Map을 제공하는 프로그램을 작성하시오.
 * 코드 내부에는 Java에서 제공하는 Map을 사용하면 안 되며, 기본 메서드 put(), get(), size()만 작성하면 됩니다.
 */
public class MapImplementation {
    // 멤버변수
    private String key;
    private String value;
    public static List<MapImplementation> mapImplementations = new ArrayList<>();

    // 생성자
    public MapImplementation() {
    }

    public MapImplementation(String key, String value) {
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

    public List<MapImplementation> getImplementMaps() {
        return mapImplementations;
    }

    public void setImplementMaps(List<MapImplementation> mapImplementations) {
        MapImplementation.mapImplementations = mapImplementations;
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        return "MapImplementation{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // Map의 메서드/기능 구현
    public void put(String key, String value) {
        MapImplementation mapImplementation = new MapImplementation(key, value);

        if (MapImplementation.mapImplementations.size() == 0) {
            MapImplementation.mapImplementations = new ArrayList<>();
            MapImplementation.mapImplementations.add(mapImplementation);
        } else {
            MapImplementation.mapImplementations.add(mapImplementation);
        }
    }

    public static String get(String key) {
        String value = null;

        for (MapImplementation mapImplementation : MapImplementation.mapImplementations) {
            if (key.equals(mapImplementation.getKey())) {
                value = mapImplementation.getValue();
            }
        }

        return value;
    }

    public static int size() {
        return MapImplementation.mapImplementations.size();
    }
}
