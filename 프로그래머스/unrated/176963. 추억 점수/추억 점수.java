import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];

        Map<String, Integer> nameAndScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameAndScore.put(name[i], yearning[i]);
        }
        System.out.println("name and score = " + nameAndScore); // todo

//        Set set = nameAndScore.entrySet();
//        Iterator it = set.iterator();

        for (int i = 0; i < photos.length; i++) {
            List<String> photoList = Arrays.asList(photos[i]);
            int nostalgiaScore = 0;

            for (int j = 0; j < name.length; j++) {
                String nm = name[j];
                if (photoList.contains(nm)) {
                    nostalgiaScore += nameAndScore.get(nm);
                }
            }

            /*
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String nm = (String) e.getKey();

                if (photoList.contains(nm)) {
                    nostalgiaScore += (Integer) e.getValue();
                }
            }
             */

            answer[i] = nostalgiaScore;
        }
            
        return answer;
    }
}