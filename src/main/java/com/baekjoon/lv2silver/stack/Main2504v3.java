package com.baekjoon.lv2silver.stack;

// 2023.7.1(토) 10h50

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main2504v3 {
    private Stack<Character> stack = new Stack<>();
//    private TreeNode<String> tree;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parenthesisString = br.readLine();

        // 문제 해결 로직
        Main2504v3 main = new Main2504v3();
        int result = main.solution(parenthesisString);

        // 결과 출력
        System.out.print(result);
    }

    private int solution(String ps) {
        int result = 0;

        if (ps.length() % 2 == 1) return 0;

        // 2023.7.2(일) 13h15 Eddie와 이야기 나눈 뒤 다시 해봄
        TreeNode<String> tree = null;
        TreeNode<String> currentNode = null;

        for (int i = 0; i < ps.length(); i++) {
            char thisCh = ps.charAt(i);

            if (stack.isEmpty() && (thisCh == ')' || thisCh == ']')) return 0;

            if (thisCh == '(' || thisCh == '[') { // thisCh가 여는 괄호인 경우
                // 2023.7.1(토) 14h25 휴우, 여전히 레벨 다른 트리 어떻게 만들어 가야 하는지 잘 모르겠다.. 내가 무엇을 놓치고 있는 걸까?
                if (tree == null) {
                    tree = new TreeNode<String>(String.valueOf(thisCh));
                    currentNode = tree.getCurrentNode();
                } else {
                    currentNode.addChild(String.valueOf(thisCh));
                }
                // 2023.7.2(일) 13h20
//                tree = new TreeNode<String>(String.valueOf(thisCh));
//                currentNode = tree.getCurrentNode();

                stack.push(thisCh);
            } else { // thisCh가 닫는 괄호인 경우
                char top = stack.peek();

//                checkValidParenthesisString(thisCh, top);
                // 2023.7.2(일) 14h45 -> 15h45 트리 층별로 어떻게 순회하고 계산해 나가야 하는지 아직 잘 모르겠다..
                if (top == '(' && thisCh == ')') {
                    currentNode.addChild(String.valueOf(thisCh));
                    stack.pop();
                    if (!currentNode.isRoot()) {
                        currentNode = currentNode.getParent();
                    } else {
                        tree = null;
                        currentNode = null;
                    }
                }
            }
        }

        if (!stack.isEmpty()) return 0;

        return result;
    }

    private void checkValidParenthesisString(char thisCh, char top) {
        int point = 0;

        switch (thisCh) {
            case ')':
                if (top == '[') return;
                point = 2;
                break;
            case ']':
                if (top == '(') return;
                point = 3;
        }

        // 여기까지 왔다면 () 또는 [] 만들어짐
        stack.pop();
    }

    // 2023.7.1(토) 13h40
    // reference = https://github.com/gt4dev/yet-another-tree-structure.git
    class TreeNode<String> implements Iterable<TreeNode> {
        // 멤버 변수
        private String data;
        private TreeNode<String> parent;
        private List<TreeNode<String>> children;
        private TreeNode<String> currentNode; // 2023.7.2(일) 13h15 추가
        private List<TreeNode<String>> elementsIndex; // 이게 어떤 역할을 하는지 아직 잘 모르겠음

        // 생성자
        public TreeNode(String data) {
            this.data = data;
            this.children = new ArrayList<TreeNode<String>>();
            this.currentNode = this;
            this.elementsIndex = new ArrayList<TreeNode<String>>();
            this.elementsIndex.add(this);
        }

        // g/setter
        public TreeNode<String> getCurrentNode() {
            return currentNode;
        }

        public void setCurrentNode(TreeNode<String> currentNode) {
            this.currentNode = currentNode;
        }

        public TreeNode<String> getParent() {
            return parent;
        }

        public void setParent(TreeNode<String> parent) {
            this.parent = parent;
        }

        // 멤버 메서드
        public TreeNode<String> addChild(String child) {
            TreeNode<String> childNode = new TreeNode<String>(child);
            childNode.parent = this;
            this.children.add(childNode);
            this.currentNode = childNode;
            return childNode;
        }

        public boolean isRoot() {
            return parent == null;
        }

        public boolean isLeaf() {
            return children.size() == 0;
        }

        public int getLevel() {
            if (this.isRoot()) {
                return 0;
            } else {
                return parent.getLevel() + 1;
            }
        }

        @Override
        public Iterator<TreeNode> iterator() {
            return null;
        }
    }
}
