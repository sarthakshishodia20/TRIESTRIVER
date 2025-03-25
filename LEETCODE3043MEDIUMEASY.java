class Solution {     
    static class Node {         
        Node[] children = new Node[10];         
        public Node() {             
            Arrays.fill(children, null);         
        }     
    }     

    public static Node root = new Node();  

    public static void insert(int num) {         
        String numStr = Integer.toString(num); 
        Node curr = root;         
        for (int level = 0; level < numStr.length(); level++) {             
            int idx = numStr.charAt(level) - '0';             
            if (curr.children[idx] == null) {                 
                curr.children[idx] = new Node();             
            }             
            curr = curr.children[idx];         
        }     
    }     

    public static int maxLength(int num) {         
        String numcheck = Integer.toString(num);
        int len = 0;         
        Node curr = root;         
        for (int i = 0; i < numcheck.length(); i++) { 
            int idx = numcheck.charAt(i) - '0';             
            if (curr.children[idx] != null) {                 
                curr = curr.children[idx];                 
                len++;             
            } else {                 
                break;             
            }         
        }         
        return len;     
    }     

    public int longestCommonPrefix(int[] arr1, int[] arr2) {         
        root = new Node();
        for (int ele : arr1) {             
            insert(ele);         
        }         
        int maxLen = 0;         
        for (int i = 0; i < arr2.length; i++) {             
            maxLen = Math.max(maxLen, maxLength(arr2[i]));
        }        
        return maxLen;     
    } 
}
