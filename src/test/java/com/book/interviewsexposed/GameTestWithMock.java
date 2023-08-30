package com.book.interviewsexposed;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// 2023.8.30(수) 17h20 -> 테스트 소스여야 mockito import되는 것 같다

/**
 * mock 이용해 Game 클래스 테스트
 */
public class GameTestWithMock {
    private final Game gameUnderTest;
    private final HighScoreService mockHighScoreService;

    public GameTestWithMock() {
        final List<String> firstHighScoreList = Arrays.asList(
                "Alice",
                "Bob",
                "Charlie",
                "Dave",
                "Elisa"
        );

        final List<String> secondHighScoreList = Arrays.asList(
                "Fred",
                "George",
                "Helen",
                "Ian",
                "Jane"
        );

        // HighScoreService 인터페이스 구현 없이도 최소한 주어진 테스트에서는 잘 작동함
        this.mockHighScoreService = mock(HighScoreService.class);
        Mockito.when(mockHighScoreService.getTopFivePlayers())
                .thenReturn(firstHighScoreList)
                .thenReturn(secondHighScoreList);

        this.gameUnderTest = new Game(mockHighScoreService);
    }

    @Test
    public void highScoreDisplayTest() {
        final String firstExpectedPlayerList = "1. Alice\n2. Bob\n3. Charlie\n4. Dave\n5. Elisa\n";
        final String secondExpectedPlayerList = "1. Fred\n2. George\n3. Helen\n4. Ian\n5. Jane\n";

        final String firstCall = gameUnderTest.displayHighScores();
        final String secondCall = gameUnderTest.displayHighScores();

        assertEquals(firstExpectedPlayerList, firstCall);
        assertEquals(secondExpectedPlayerList, secondCall);

        // 테스트는 mock에 있는 getTopFivePlayers() 메서드가 2번 호출될 것으로 예상함
        verify(mockHighScoreService, times(2)).getTopFivePlayers();
    }

}