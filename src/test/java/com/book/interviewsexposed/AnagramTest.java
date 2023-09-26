package com.book.interviewsexposed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.book.interviewsexposed.Anagram.getAnagrams;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.9.26(화) 19h20
public class AnagramTest {

    @Test
    @DisplayName("일반적인 입력이 들어온 경우 테스트1")
    void testCase1() {
        // given
        List<String> words = Arrays.asList("AbaAeCe", "baeeAcA", "eCeAbAa", "1234", "");
        String word = "baeeACA";

        // when
        List<String> actual = getAnagrams(words, word); // ["AbaAeCe", "eCeAbAa"]

        // then
        assertThat(actual.size(), is(equalTo(2)));
        assertThat(actual.get(0), is(equalTo("AbaAeCe")));
    }
}
