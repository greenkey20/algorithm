package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 2023.9.4(월) 12h35
public class LinkedListImplementationTest {
    /* edge cases
    1. 처음/현재 linkedList가 비어있는 경우
    2. 처음 linkedList의 원소가 1개인 경우
    3. 처음 linkedList의 원소가 2개인 경우
     */

    @Test
    @DisplayName("처음 linkedList가 비어있는 경우 테스트")
    void testCase1() {
        LinkedListImplementation node = new LinkedListImplementation();
        node.addFirst("1번째 원소");

//        linkedList.getFirst();
    }
}
