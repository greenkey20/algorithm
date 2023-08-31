package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.8.31(목) 18h55
public class ImplementMapTest {
    // test 메서드를 통해 내가 만들고 싶은 것 = Map 형태의 자료 구조
    // e.g. [["토미", "컴퓨터 구조"], ["판다", "이산수학"], ["미피", "데이터베이스시스템"], ["트롬", "이산수학"], ["해피", "Java"], ["유베", "C++"]]

    public static void main(String[] args) {

    }

//    @BeforeEach
    void beforeEachTest() {
    }

    @Test
    @DisplayName("put(), get(), size() 메서드 테스트")
    void testCase1() {
        // given + when
        ImplementMap implementMap1 = new ImplementMap();
        implementMap1.put("토미", "컴퓨터 구조");

        ImplementMap implementMap2 = new ImplementMap();
        implementMap1.put("판다", "이산수학");

        ImplementMap implementMap3 = new ImplementMap();
        implementMap3.put("트롬", "이산수학");

        // then
//        System.out.println("implementMap이 멤버변수로 가지고 있는 implementMaps = " + implementMap.getImplementMaps());
        System.out.println("Static implementMaps = " + ImplementMap.implementMaps); // 주소 값 [com.book.successfuljobsearch.ImplementMap@32910148] 출력됨

        for (ImplementMap im : ImplementMap.implementMaps) {
            System.out.println(im.toString());
        }

        // put() 메서드의 기능 + size() 메서드의 기능 테스트
        assertThat(ImplementMap.implementMaps.size(), is(equalTo(3)));

        // get() 메서드 테스트
//        String value1 = ImplementMap.implementMaps.get("토미");
    }
}
