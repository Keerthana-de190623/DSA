// Java implementation of Trie and Word Break
import java.util.*;

class TNode {
    TNode[] child;
    boolean isEndOfWord;

    TNode() {
        child = new TNode[26];
        isEndOfWord = false;
    }
}

public class WordBreak {
    static final int ALPHABET_SIZE = 26;

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
    static void insert(TNode root, String key) {
        TNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TNode();

            pCrawl = pCrawl.child[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if string can be segmented into
    // space separated words, otherwise returns false
    static boolean wordBreak(String str, TNode root) {
        int n = str.length();
        if (n == 0)
            return true;

        boolean[] dp = new boolean[n + 1];

        // dp[i] is true if str[0..i-1] can be segmented
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            TNode curr = root;

            for (int j = i - 1; j >= 0; j--) {
                int index = str.charAt(j) - 'a';

                if (curr.child[index] == null)
                    break;

                curr = curr.child[index];

                // If str[j..i-1] is a word and dp[j] is true
                if (curr.isEndOfWord && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String[] dictionary = {
            "mobile", "samsung", "sam", "sung", "ma",
            "mango", "icecream", "and", "go", "i",
            "like", "ice", "cream"
        };

        TNode root = new TNode();

        // Construct trie
        for (String word : dictionary)
            insert(root, word);

        System.out.println(wordBreak("ilikesamsung", root) ? "Yes" : "No");
        System.out.println(wordBreak("iiiiiiii", root) ? "Yes" : "No");
        System.out.println(wordBreak("", root) ? "Yes" : "No");
        System.out.println(wordBreak("ilikelikeimangoiii", root) ? "Yes" : "No");
        System.out.println(wordBreak("samsungandmango", root) ? "Yes" : "No");
        System.out.println(wordBreak("samsungandmangok", root) ? "Yes" : "No");
    }
}