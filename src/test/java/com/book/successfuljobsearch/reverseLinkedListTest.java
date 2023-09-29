package com.book.successfuljobsearch;

import com.book.interviewsexposed.LinkedListImplementationV3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.interviewsexposed.ReverseLinkedList.reverseLinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.9.29(금) 23h5
public class reverseLinkedListTest {

    @Test
    @DisplayName("책 예시 테스트")
    void testCase1() {
        LinkedListImplementationV3<String> three = new LinkedListImplementationV3<>("3", null);
        LinkedListImplementationV3<String> two = new LinkedListImplementationV3<>("2", three);
        LinkedListImplementationV3<String> one = new LinkedListImplementationV3<>("1", two);

        LinkedListImplementationV3<String> actual = reverseLinkedList(one);

        assertEquals("3", actual.getElement());
        assertEquals("2", actual.getNext().getElement());
        assertEquals("1", actual.getNext().getNext().getElement());
    }

}
