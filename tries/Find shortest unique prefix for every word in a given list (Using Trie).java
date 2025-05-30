// Java program to find shortest unique 
// prefix for every word in a given list

import java.util.*;

class GfG {
    
    static String[] findPrefixes(String[] arr) {
        int n = arr.length;
        
        // Create root node of Trie
        Node root = new Node('*');
        
        // Insert all words into the Trie
        for(int i = 0; i < n; i++) {
            root.insert(arr[i]);
        }
        
        // Array to store result prefixes
        String[] result = new String[n];
        
        // Find minimum unique prefix for each word
        for(int i = 0; i < n; i++) {
            String word = arr[i];
            
            // Get ending index of minimum prefix
            int endIndex = root.findPrefix(word);
            
            // Add substring from start to endIndex to result
            result[i] = word.substring(0, endIndex + 1);
        }
        
        // Free up the trie space.
        root.deleteTrie(root);
        
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};
        String[] ans = findPrefixes(arr);
        for (String val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

class Node {
    private Node[] children;
    private int freq;
    private char ch;

    Node(char x) {
        freq = 0;
        ch = x;
        children = new Node[26];
    }

    // Insert a word into the Trie
    void insert(String word) {
        Node curr = this;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
            curr.freq++;
        }
    }

    // Find the ending index of minimum 
    // unique prefix for given word
    int findPrefix(String word) {
        Node curr = this;
        for(int i = 0; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            // If frequency is 1, we found the unique prefix
            if(curr.freq == 1) {
                return i;
            }
        }
        return word.length() - 1;
    }
    
    void deleteTrie(Node root) {
        if (root == null) return;
        
        for (int i = 0; i < 26; i++) {
            deleteTrie(root.children[i]);
            root.children[i] = null;
        }
    }
}