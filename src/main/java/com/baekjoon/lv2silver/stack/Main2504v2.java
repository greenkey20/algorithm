package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2023.6.24(토) 23h40 ~ 2023.6.26(일) 6h25 (약 1.5시간 작업) v1 test result1 = 42
// 2023.6.27(화) 22h5 ~ 22h55 v2 일단 입/출력 예제 2개에 대해서는 테스트 통과

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
    private static Pair rootNode = null;
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
        int total = 0;

        for (int i = 0; i < ps.length(); i++) {
            char thisCh = ps.charAt(i);
            System.out.println("현재 순회 문자 thisCh = " + thisCh);
//            char nextCh = ps.charAt(i + 1);

            if (thisCh == '(' || thisCh == '[') { // 금번 확인하는 문자가 여는 괄호인 경우
                if (rootNode == null) {
                    rootNode = new Pair();
                } else {
                    rootNode.addChildNode(new Pair(String.valueOf(thisCh)));
                }
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
                    } else if (rootNode.getChildrenSize() <= 1) {
                        if (stack.size() > 0) {
                            temp *= 2;
                            rootNode.addSum(temp);
                            result = rootNode.getSum();
                            temp = 1;
                            rootNode.getChildrenNodes().remove(0);
                        } else {
                            result = rootNode.getSum() * 2;
                            temp = 1;
//                            rootNode.setSumToZero();
                            rootNode = null;
                        }
                    }
                } else if (top == '[' && thisCh == ']') {
                    stack.pop();

                    if (rootNode.getChildrenNodes() != null) {
                        if (rootNode.getChildrenSize() > 1) {
                            rootNode.getChildrenNodes().remove(rootNode.getChildrenSize() - 1);
                            temp *= 3;
                        } else if (rootNode.getChildrenSize() <= 1) {
                            if (stack.size() > 0) {
                                temp *= 3;
                                rootNode.addSum(temp);
                                result = rootNode.getSum();
                                temp = 1;
                                rootNode.getChildrenNodes().remove(0);
                            } else {
                                result = rootNode.getSum() * 3;
                                temp = 1;
//                            rootNode.setSumToZero();
                                rootNode = null;
                            }
                        }
                    } else {
                        temp *= 3;
                        rootNode.addSum(temp);
                        result += rootNode.getSum();
                    }
                }
            }

            if (stack.isEmpty()) {
                total += result;
            }

            System.out.println("stack = " + stack);
            System.out.println("temp = " + temp);
            System.out.println("result = " + result);
            if (rootNode != null) {
                System.out.println("rootnode는 null 아님");
                System.out.println("rootNode의 멤버변수 sum = " + rootNode.getSum());
                System.out.println("rootNode의 자식노드(들) = " + rootNode.getChildrenNodes());
            }
            System.out.println("-----------------------------");
        }

        if (!stack.isEmpty()) total = 0;

        return total;
    }
}
