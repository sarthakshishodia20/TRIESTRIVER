class Solution {
    static class Node {
        Node[] children = new Node[2]; 
        public Node() {
            children[0] = null;
            children[1] = null;
        }
    }
    public static Node root;
    public static void insert(int num) {
        Node curr = root;
        for (int level = 31; level >= 0; level--) {
            int bit = (num >> level) & 1;//isse bit pta pd rhi hai kon si bit daalni hai 
            if (curr.children[bit] == null) {
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
        }
    }
    public static int findMaxXor(int num) {
        Node curr = root;
        int maxXor = 0;
        for (int level = 31; level >= 0; level--) {
            int bit = (num >> level) & 1;// isse bit nikal rhe hai
            int opposite = 1 - bit;// check kr rhe hai agr trie ke andr opposite bit hia toh uss trf chlo kyuki same ka ans 0 hi aaega xor m isliye koi fayda nahi hai jane ke liye
            if (curr.children[opposite] != null) { 
                maxXor |= (1 << level); 
                curr = curr.children[opposite];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        root = new Node();
        for (int ele : nums) {
            insert(ele);
        }

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXor(num));
        }
        return maxResult;
    }
}
