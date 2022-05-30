package PG;

import java.util.HashMap;
import java.util.Map;

public class PG_17685 {
    class Node{
        Map<Character, Node> childNode = new HashMap<>();
        boolean endOfword;
        int count = 0;
    }

    class Trie{
        Node root = new Node();

        void insert(String str){
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
                node.count++;
            }

            node.endOfword = true;
        }
    }

    class Solution {
        public int solution(String[] words) {
            int answer = 0;

            Trie trie = new Trie();

            for (String word : words){
                trie.insert(word);
            }

            answer = search(trie.root, 0);

            return answer;
        }

        int search(Node now, int level){
            int res = 0;

            if (now.count == 1)
                return level;

            for (Node node : now.childNode.values())
                res += search(node, level + 1);

            if (now.endOfword)
                res += level;

            return res;
        }
    }
}