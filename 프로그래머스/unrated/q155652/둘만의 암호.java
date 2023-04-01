import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        String sourceStr = "abcdefghijklmnopqrstuvwxyz";
        List<Character> sourceList = new ArrayList<>();

        for (int i = 0; i < sourceStr.length(); i++) {
            sourceList.add(sourceStr.charAt(i));
        }
        //System.out.println(sourceList); // todo

        for (int i = 0; i < skip.length(); i++) {
            //sourceList.remove(skip.charAt(i));
            sourceList.remove(Character.valueOf(skip.charAt(i)));
        }
        //System.out.println(sourceList); // todo

        for (int i = 0; i < s.length(); i++) {
            int cipherIndex = sourceList.indexOf(s.charAt(i));
            Character decoded = sourceList.get((cipherIndex + index) % sourceList.size());

            sb.append(decoded);
        }

        return sb.toString();
    }
}