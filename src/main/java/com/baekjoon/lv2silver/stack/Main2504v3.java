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
    private TreeNode<String> tree;

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

        for (int i = 0; i < ps.length(); i++) {
            char thisCh = ps.charAt(i);

            if (stack.isEmpty() && (thisCh == ')' || thisCh == ']')) return 0;

            if (thisCh == '(' || thisCh == '[') { // thisCh가 여는 괄호인 경우
                // 2023.7.1(토) 14h25 휴우, 여전히 레벨 다른 트리 어떻게 만들어 가야 하는지 잘 모르겠다.. 내가 무엇을 놓치고 있는 걸까?
                if (tree == null) {
                    tree = new TreeNode<String>(String.valueOf(thisCh));
                } else {
                    tree.addChild(String.valueOf(thisCh));
                }

                stack.push(thisCh);
            } else { // thisCh가 닫는 괄호인 경우
                char top = stack.peek();

                checkValidParenthesisString(thisCh, top);

            }
        }

        return result;
    }

    private void checkValidParenthesisString(char thisCh, char top) {
        int point = 0;

        switch (thisCh) {
            case ')' :
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
        public String data;
        public TreeNode<String> parent;
        public List<TreeNode<String>> children;

        public boolean isRoot() {
            return parent == null;
        }

        public boolean isLeaf() {
            return children.size() == 0;
        }

        private List<TreeNode<String>> elementsIndex; // 이게 어떤 역할을 하는지 아직 잘 모르겠음

        public TreeNode(String data) {
            this.data = data;
            this.children = new ArrayList<TreeNode<String>>();
            this.elementsIndex = new ArrayList<TreeNode<String>>();
            this.elementsIndex.add(this);
        }

        public TreeNode<String> addChild(String child) {
            TreeNode<String> childNode = new TreeNode<String>(child);
            childNode.parent = this;
            this.children.add(childNode);
            return childNode;
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
