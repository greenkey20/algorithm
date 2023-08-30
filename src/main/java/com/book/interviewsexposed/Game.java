package com.book.interviewsexposed;

import java.util.List;

// 2023.8.30(수) 16h15

/**
 * HighScoreService 인터페이스에 의존성을 갖는 Game 클래스 만들기
 */
public class Game {
    private final HighScoreService highScoreService;

    public Game(HighScoreService highScoreService) {
        this.highScoreService = highScoreService;
    }

    public String displayHighScores() {
        final List<String> topFivePlayers = highScoreService.getTopFivePlayers();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < topFivePlayers.size(); i++) {
            String player = topFivePlayers.get(i);
            sb.append(String.format("%d. %s%n", i + 1, player));
        }

        return sb.toString();
    }
}
