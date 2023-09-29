package com.book.interviewsexposed;

// 2023.9.29(금) 22h55

/**
 * 통상적인 연결 리스트의 클래스 정의(책 참고)
 * @param <T>
 */
public class LinkedListImplementationV3<T> {
    private T element;
    private LinkedListImplementationV3<T> next;

    public LinkedListImplementationV3(T element, LinkedListImplementationV3<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public LinkedListImplementationV3<T> getNext() {
        return next;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(LinkedListImplementationV3<T> next) {
        this.next = next;
    }
}
