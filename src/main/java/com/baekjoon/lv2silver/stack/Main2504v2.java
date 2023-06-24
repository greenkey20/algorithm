package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2023.6.24(토) 23h40 ~ 2023.6.26(일) 6h25 (약 1.5시간 작업) v1 test result1 = 42

/**
 * 부트캠프 section2 학습 내용 참고해서 트리 자료구조 구현해서 사용하고자 함
 */
class Pair {
    // 멤버 변수
    private String value;
    private ArrayList<Pair> children;
    private int sum;

    // 생성자
    public Pair() {
        this.value = null;
        this.children = null;
        this.sum = 0;
    }

    public Pair(String data) {
        this.value = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Pair> getChildrenNodes() {
        return children;
    }

    public void addChildNode(Pair node) {
        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(node);
    }

    public int getChildrenSize() {
        return children.size();
    }

    public void addSum(int temp) {
        sum += temp;
    }

    public int getSum() {
        return sum;
    }

    public void setSumToZero() {
        sum = 0;
    }
}

public class Main2504v2 {
    private static Pair rootNode = new Pair();
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ps = br.readLine();

        // 문제 해결 로직
        int result = solution(ps);

        // 결과 출력
        System.out.print(result);
    }

    public static int solution(String ps) {
        int result = 0;
        int temp = 1;

        for (int i = 0; i < ps.length(); i++) {
            char thisCh = ps.charAt(i);
//            char nextCh = ps.charAt(i + 1);

            if (thisCh == '(' || thisCh == '[') { // 금번 확인하는 문자가 여는 괄호인 경우
                rootNode.addChildNode(new Pair(String.valueOf(thisCh)));
                stack.push(thisCh);

            } else { // 금번 확인하는 문자가 닫는 괄호인 경우
                char top = stack.peek();

//                if (rootNode.getChildrenSize() == 0) {
//                    result += temp;
//                    temp = 1;
//                }

                if (top == '(' && thisCh == ')') {
                    stack.pop();
//                    rootNode.getChildrenNodes().get(rootNode.getChildrenSize() - 1).setValue("()");

                    if (rootNode.getChildrenSize() > 1) {
                        rootNode.getChildrenNodes().remove(rootNode.getChildrenSize() - 1);
                        temp *= 2;
                    }

                    if (rootNode.getChildrenSize() == 1) {
                        if (stack.size() > 0) {
                            rootNode.addSum(temp);
                            result = rootNode.getSum();
                            temp = 1;
                        } else {
                            result += rootNode.getSum() * 2;
                            temp = 1;
//                            rootNode.setSumToZero();
                            rootNode.getChildrenNodes().remove(0);
                        }
                    }
                } else if (top == '[' && thisCh == ']') {
                    stack.pop();

                    if (rootNode.getChildrenSize() > 1) {
                        rootNode.getChildrenNodes().remove(rootNode.getChildrenSize() - 1);
                        temp *= 3;
                    }

                    if (rootNode.getChildrenSize() == 1) {
                        if (stack.size() > 0) {
                            rootNode.addSum(temp);
                            result = rootNode.getSum();
                            temp = 1;
                        } else {
                            result += rootNode.getSum() * 3;
                            temp = 1;
//                            rootNode.setSumToZero();
                            rootNode.getChildrenNodes().remove(0);
                        }
                    }
                }
            }
        }

        if (!stack.isEmpty()) result = 0;

        return result;
    }
}
