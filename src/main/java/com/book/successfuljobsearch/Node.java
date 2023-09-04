package com.book.successfuljobsearch;

// 2023.9.5(화) 1h25
public class Node {
    private LinkedListImplementation prevNode;
    private LinkedListImplementation nextNode;
    private String data;

    public Node() {
    }

    public Node(LinkedListImplementation prevNode, LinkedListImplementation nextNode, String data) {
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.data = data;
    }

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
}
