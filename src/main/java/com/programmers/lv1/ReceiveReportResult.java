package com.programmers.lv1;

import java.util.*;

public class ReceiveReportResult {
    // 2023.2.13(월) 18h20 -> 19h35 v1 작성 = class cast exception 발생
    public static int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];

        // step1) 신고 내역 set = 신고 내역 중 중복 제거
        Set<String> reportsAsSet = new HashSet<>();

        for (String report : reports) {
            reportsAsSet.add(report);
        }

        // step2) reportsAsSet에 담긴 문자열을 하나하나 꺼내어
        // " "로 split한 결과(String[])를
        // 별도의 배열 또는 list에 담기
//        String[][] reportsAsArray = new String[reportsAsSet.size()][];
        List<String[]> reportsAsList = new ArrayList<>();

        Iterator<String> it1 = reportsAsSet.iterator();
        while (it1.hasNext()) {
            reportsAsList.add(it1.next().split(" "));
        }
        // 현재까지 reportsAsList = [{"muzi", "frodo"}, {"apache", "frodo"}, ...]
        System.out.println(reportsAsList); // todo

        // step3) 각 유저가 몇 번씩 신고되었는지 파악 = id_list의 각 유저가 reportedAsList의 각 원소의 두번째 String으로써 각 몇 번씩 나오는지 count
        Map<String, Integer> reportedCountMap = new HashMap<>();
        for (int i = 0; i < reportsAsList.size(); i++) {
            String reported = reportsAsList.get(i)[1];

            if (!reportedCountMap.containsKey(reported)) {
                reportedCountMap.put(reported, 1);
            } else {
                int count = reportedCountMap.get(reported);
                reportedCountMap.put(reported, count++);
            }
        }
        System.out.println(reportedCountMap); // todo

        // step4) k번 이상 신고된 유저들을 정지된 ID list에 추가
        List<String> suspendedIdList = new ArrayList<>();
        Iterator it2 = reportedCountMap.keySet().iterator();
        while (it2.hasNext()) {
            Map.Entry e = (Map.Entry) it2.next(); // 2023.2.13(월) 19h35 v1 = class cast exception 발생
            if ((Integer) e.getValue() >= k) {
                suspendedIdList.add((String) e.getKey());
            }
        }
        System.out.println(suspendedIdList); // todo

        // step5) reporter를 key, reported(s)의 list를 value로 갖는 map을 만듦
        Map<String, List<String>> reporterAndReportedListMap = new HashMap<>();

        for (int i = 0; i < reportsAsList.size(); i++) {
            String reporter = reportsAsList.get(i)[0];
            String reported = reportsAsList.get(i)[1];

            if (!reporterAndReportedListMap.containsKey(reporter)) {
                reporterAndReportedListMap.put(reporter, new ArrayList<>());
            }

            reporterAndReportedListMap.get(reporter).add(reported);
        }
        System.out.println(reporterAndReportedListMap); // todo

        // step6) reporterAndReportedListMap의 key별로 value list에 suspendedId를 몇 개나 가지고 있는지 count
        Map<String, Integer> reporterAndSuspendedIdCountMap = new HashMap<>();
        Iterator it3 = reporterAndReportedListMap.keySet().iterator();
        while (it3.hasNext()) {
            Map.Entry e = (Map.Entry) it3.next();

            for (int i = 0; i < suspendedIdList.size(); i++) {
                String suspendedId = suspendedIdList.get(i);

                if (((List<String>) e.getValue()).contains(suspendedId)) {
                    String reporter = (String) e.getKey();

                    if (!reporterAndSuspendedIdCountMap.containsKey(reporter)) {
                        reporterAndSuspendedIdCountMap.put(reporter, 1);
                    } else {
                        int count = reporterAndSuspendedIdCountMap.get(reporter);
                        reporterAndSuspendedIdCountMap.put(reporter, count++);
                    }
                }
            }
        }
        System.out.println(reporterAndSuspendedIdCountMap); // todo

        // step7) answer[] 준비
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            answer[i] = reporterAndSuspendedIdCountMap.get(id);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }
}
