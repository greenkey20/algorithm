package com.book.interviewsexposed;

// 2023.9.29(금) 22h55
public class ReverseLinkedList {

    /**
     * 얼핏 봐서는 원본 리스트의 복사본을 반환하는 것처럼 보이나, 실제로는 마지막 원소에 대한 참조를 반환 = 설명 이해 안 됨 >.<
     * + 아래 코드도 이해 안 됨..
     * @param original
     * @return
     * @param <T>
     */
    public static <T> LinkedListImplementationV3<T> reverseLinkedList(LinkedListImplementationV3<T> original) {
        if (original == null) {
            throw new NullPointerException("Cannot reverse a null list");
        }

        // original 다음 원소가 없는 경우 = original 리스트의 원소가 1개인 경우?
        if (original.getNext() == null) {
            return original;
        }

        LinkedListImplementationV3<T> next = original.getNext();
        original.setNext(null);

        LinkedListImplementationV3<T> reversed = reverseLinkedList(next);

        next.setNext(original);

        return reversed;
    }
}
