package com.book.successfuljobsearch;

// 2023.9.4(월) 11H45

import java.util.ArrayList;
import java.util.List;

/**
 * LinkedList는 앞에 있는 값과 뒤에 있는 값이 어떤 것인지 알 수 있는 목록형 타입 중 하나입니다.
 * Java에서 제공하는 LinkedList를 사용하지 말고, 직접 작성해서 LinkedList를 구현하시오.
 * 다음의 메서드만 구현하면 됩니다.
 * add(String data)
 * getFirst()
 * getLast()
 * addFirst(String data)
 * addLast(String data)
 * <p>
 * Java의 정석에서 LinkedList 개요 읽고 옴
 */
public class LinkedListImplementation {
    // 클래스변수
    static List<LinkedListImplementation> linkedList = new ArrayList<>();

    // 멤버변수
    private LinkedListImplementation prevNode;
    private LinkedListImplementation nextNode;
    private String data;

    // 생성자
    public LinkedListImplementation() {
    }

    public LinkedListImplementation(LinkedListImplementation prevNode, LinkedListImplementation nextNode, String data) {
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.data = data;
    }

    // g/setter
    public LinkedListImplementation getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LinkedListImplementation prevNode) {
        this.prevNode = prevNode;
    }

    public LinkedListImplementation getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListImplementation nextNode) {
        this.nextNode = nextNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param index 지정된 위치에
     * @param data  data를 추가하는 메서드
     */
    public void add(int index, String data) {
        LinkedListImplementation prevNode = null;
        LinkedListImplementation nextNode = null;

        if (index == 0) {
            addFirst(data);
        } else if (index >= linkedList.size()) {
            addLast(data);
        } else {
            prevNode = linkedList.get(index - 1);
            nextNode = linkedList.get(index + 1);
            LinkedListImplementation node = new LinkedListImplementation(prevNode, nextNode, data);
            LinkedListImplementation.linkedList.add(index, node);
        }
    }

    public LinkedListImplementation getFirst() {
        if (linkedList.size() > 0) {
            return linkedList.get(0);
        } else {
            return null;
        }
    }

    public LinkedListImplementation getLast() {
        if (linkedList.size() > 0) {
            return linkedList.get(linkedList.size() - 1);
        } else {
            return null;
        }
    }

    public void addFirst(String data) {
        LinkedListImplementation prevNode = null;
        LinkedListImplementation nextNode = null;

        // linkedList가 비어있었다면, prevNode, nextNode 모두 null vs 비어있지 않았다면 nextNode는 기존 linkedList의 첫번째 원소
        if (linkedList.size() > 0) {
            nextNode = linkedList.get(0);
        }

        LinkedListImplementation node = new LinkedListImplementation(prevNode, nextNode, data);
        linkedList.add(0, node);
    }

    public void addLast(String data) {
        LinkedListImplementation prevNode = null;
        LinkedListImplementation nextNode = null;

        if (linkedList.size() > 0) {
            prevNode = linkedList.get(linkedList.size() - 1);
        }

        LinkedListImplementation node = new LinkedListImplementation(prevNode, nextNode, data);
        linkedList.add(linkedList.size(), node);
    }
}
