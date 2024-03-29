package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.book.successfuljobsearch.ShuffleCards.shuffleCards;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// 2023.8.28(월) 14h20
public class ShuffleCardsTest {

    @Test
    @DisplayName("n이 2 이상의 정수로 입력된 정상 케이스 테스트")
    void testCase1() {
        // given
        int n = 5;

        // when
        int[] result1 = shuffleCards(n);
        int[] result2 = shuffleCards(n);

        // then
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));

        // 해당 프로그램이 제대로 동작한다면 프로그램을 첫번째 실행시켰을 때와 두번째 실행시켰을 때 첫번째 원소가 다를 확률이 99%임 vs 같을 확률은 0.1 * 0.1 = 0.01 = 1% -> 아래와 같이 테스트 케이스를 짜고, 테스트가 실패하는 경우 다른 원소들을 확인하기 위해 위와 같이 print문을 추가했음
//        assertThat(result1[0], is(equalTo(result2[0])));
        assertNotEquals(result1[0], result2[0]);

        // result1 및 result2의 두번째 원소들이 같은지도 확인
        assertNotEquals(result1[1], result2[1]);
    }

    @Test
    @DisplayName("n이 2 미만의 정수로 입력된 케이스 테스트")
    void testCase2() {
        // given
        int n = 1;

        // when
//        shuffleCards(n);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> shuffleCards(n));
    }


}
