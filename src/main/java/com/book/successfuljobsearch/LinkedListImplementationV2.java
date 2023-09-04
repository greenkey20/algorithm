package com.book.successfuljobsearch;

import java.util.ArrayList;
import java.util.List;

// 2023.9.5(화) 1h10
public class LinkedListImplementationV2<Node> {
    private int size;
    private List<Node> linkedList = new ArrayList<>();

    public void addFirst(String data) {
        Node prevNode = null;
        Node nextNode = null;

        if (size > 0) {
            nextNode = linkedList.get(0);
        }

//        Node thisNode = new Node(prevNode, nextNode, data); // Type parameter 'Node' cannot be instantiated directly
        Node thisNode = (Node) new Object();
        linkedList.add(0, thisNode);
    }
}

//class Node {
//
//}
