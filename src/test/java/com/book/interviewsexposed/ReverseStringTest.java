package com.book.interviewsexposed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.interviewsexposed.ReverseString.inPlaceReverseString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.9.28(목) 21h10
public class ReverseStringTest {

    @Test
    @DisplayName("일반적인 입력이 들어온 경우 테스트1")
    void testCase1() {
        // given
        String s = "abcd e";

        // when
//        String actual = reverseString(s);
        String actual = inPlaceReverseString(s);

        // then
        System.out.println("actual = " + actual); // 테스트 결과는 시스템적으로 (못)통과하는지 확인해야 하는 바, 이렇게 출력문 쓰지 말기(테스트 결과 찍히는 것 보고 있을 수 없으니까)
        assertThat(actual, is(equalTo("e dcba")));
    }
}
