//package com.book.interviewsexposed;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.mockito.Mockito;
//
//// 2023.8.30(수) 16h30 -> 테스트 소스여야 mockito import되는 것 같다
//@ExtendWith(MockitoExtension.class)
//public class GameTestWithMock {
//    private final Game gameUnderTest;
//    private final HighScoreService mockHighScoreService;
//
//    public GameTestWithMock() {
//        final List<String> firstHighScoreList = Arrays.asList(
//                "Alice",
//                "Bob",
//                "Charlie",
//                "Dave",
//                "Elisa"
//        );
//
//        final List<String> secondHighScoreList = Arrays.asList(
//                "Fred",
//                "George",
//                "Helen",
//                "Ian",
//                "Jane"
//        );
//
//        this.mockHighScoreService = mock(HighScoreService.class);
//        Mockito.when(mockHighScoreService.getTopFivePlayers())
//                .thenReturn(firstHighScoreList)
//                .thenReturn(secondHighScoreList);
//
//        this.gameUnderTest = new Game(mockHighScoreService);
//    }
//
//    @Test
//    public void highScoreDisplayTest() {
//        final String firstExpectedPlayerList = "1. Alice\n2. Bob\n3. Charlie\n4. Dave\n5. Elisa\n";
//        final String secondExpectedPlayerList = "1. Alice\n2. Bob\n3. Charlie\n4. Dave\n5. Elisa\n";
//
//        final String firstCall = gameUnderTest.displayHighScores();
//        final String secondCall = gameUnderTest.displayHighScores();
//
//        assertEquals(firstExpectedPlayerList, firstCall);
//        assertEquals(secondExpectedPlayerList, secondCall);
//
//        verify(mockHighScoreService, times(2)).getTopFivePlayer();
//    }
//}
