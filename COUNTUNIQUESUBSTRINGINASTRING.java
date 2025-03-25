import java.util.ArrayList;

public class Solution 
{
    static class Node {
        Node[] children = new Node[26];
        boolean eow;
        
        public Node() {
            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }
    
    public static Node root;

    public static void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countNodesInATrie(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                count += countNodesInATrie(root.children[i]);
            }
        }
        return count + 1;
    }
    
    public static int countDistinctSubstrings(String s) {
        root = new Node();
        for(int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            insert(suffix);
        }
        return countNodesInATrie(root);
    }

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println("Distinct Substrings Count: " + countDistinctSubstrings(s));
    }
}
