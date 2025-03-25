class WordDictionary {
    static class Node {
        Node[] children = new Node[26];
        boolean eow; 
        public Node() {
            Arrays.fill(children, null);
            eow = false;
        }
    }

    public static Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public static boolean helper(String word, int index, Node root) {
        if (index == word.length()) {
            return root.eow; 
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node childNode : root.children) {
                if (childNode != null && helper(word, index + 1, childNode)) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.children[ch - 'a'] == null) {
                return false;
            }
            return helper(word, index + 1, root.children[ch - 'a']);
        }
    }
}
