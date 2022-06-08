package PG;

import java.util.PriorityQueue;

public class PG_42892 {
    class Solution {
        Node root;
        int[][] answer = {};
        int i = 0;

        private class Node implements Comparable<Node> {
            private Node left;
            private Node right;
            int value;
            int x;
            int y;

            public Node(int x, int y, int value) {
                this.x = x;
                this.y = y;
                this.value = value;
                this.left = null;
                this.right = null;
            }

            public Node getLeft() {
                return left;
            }

            public void setLeft(Node left) {
                this.left = left;
            }

            public Node getRight() {
                return right;
            }

            public void setRight(Node right) {
                this.right = right;
            }

            @Override
            public int compareTo(Node o) {
                if (this.y == o.y) {
                    return this.x - o.x;
                } else {
                    return o.y - this.y;
                }
            }
        }
        void insert(int x, int y, int value){
            Node newNode = new Node(x ,y, value);

            if(root == null){
                root = newNode;
                return;
            }
            Node currentNode = root;
            Node parent;
            while (true){
                parent = currentNode;
                if(x < currentNode.x){
                    currentNode = currentNode.getLeft();
                    if(currentNode==null){
                        parent.setLeft(newNode);
                        return;
                    }
                }else {
                    currentNode = currentNode.getRight();
                    if(currentNode==null){
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }

        void preorder(Node root) {
            if (root != null) {
                answer[0][i++] = root.value;
                preorder(root.left);
                preorder(root.right);
            }
        }

        void postorder(Node root){
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                answer[1][i++] = root.value;
            }
        }
        public int[][] solution(int[][] nodeinfo) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            answer = new int[2][nodeinfo.length];

            i = 1;
            for(int[] node : nodeinfo){
                priorityQueue.add(new Node(node[0], node[1], i++));
            }

            while (!priorityQueue.isEmpty()) {
                Node now = priorityQueue.poll();
                insert(now.x, now.y, now.value);
            }

            i = 0;
            preorder(root);

            i = 0;
            postorder(root);

            return answer;
        }
    }
}


