import java.util.* ;
import java.io.*; 

public class Solution {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; 
        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false; 
            }
            curr = curr.children[idx];
        }
        return curr.eow; 
    }

    public static boolean wordBreakHelper(String str) {
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) { 
            if (search(str.substring(0, i)) && wordBreakHelper(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static Boolean wordBreak(String[] arr, int n, String target) {
        for (int i = 0; i < n; i++) {
            insert(arr[i]);
        }
        return wordBreakHelper(target);
    }
}
