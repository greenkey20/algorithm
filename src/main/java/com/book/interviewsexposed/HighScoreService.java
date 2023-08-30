package com.book.interviewsexposed;

import java.util.List;

// 2023.8.30(수) 16h15
public interface HighScoreService {
    List<String> getTopFivePlayers();

    boolean saveHighScore(int score, String playerName);
}
