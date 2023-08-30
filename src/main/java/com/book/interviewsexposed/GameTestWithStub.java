package com.book.interviewsexposed;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.8.30(수) 16h20

/**
 * stub을 이용한 Game 클래스 테스트
 */
public class GameTestWithStub {
    private static class StubHighScoreService implements HighScoreService {

        @Override
        public List<String> getTopFivePlayers() {
            return Arrays.asList(
                    "Alice",
                    "Bob",
                    "Charlie",
                    "Dave",
                    "Elisa"
            );
        }

        @Override
        public boolean saveHighScore(int score, String playerName) {
            throw new UnsupportedOperationException("saveHighScore not implemented for this test");
        }
    }

    @Test
    public void HighScoreDisplayTest() {
        final String expectedPlayerList = "1. Alice\n2. Bob\n3. Charlie\n4. Dave\n5. Elisa\n";

        final HighScoreService stubbedHighScoreService = new StubHighScoreService();
        final Game gameUnderTest = new Game(stubbedHighScoreService);

        assertEquals(expectedPlayerList, gameUnderTest.displayHighScores());
    }
}
