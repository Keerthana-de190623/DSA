class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a key into the Trie
    public void insert(String key) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isLeaf = true;
    }

    // Search a key in the Trie
    public boolean search(String key) {
        if (key == null || key.isEmpty()) return false;
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isLeaf;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    // Delete a word from the Trie
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode curr, String word, int index) {
        if (curr == null) return false;

        if (index == word.length()) {
            if (!curr.isLeaf) return false;
            curr.isLeaf = false;
            return isEmpty(curr);
        }

        char c = word.charAt(index);
        int idx = c - 'a';
        TrieNode child = curr.children[idx];
        boolean shouldDelete = delete(child, word, index + 1);

        if (shouldDelete) {
            curr.children[idx] = null;
            return !curr.isLeaf && isEmpty(curr);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

    // Main method to test the Trie
    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] insertWords = {"and", "ant", "do", "dad"};
        for (String word : insertWords) {
            trie.insert(word);
        }

        String[] searchWords = {"do", "gee", "bat"};
        for (String word : searchWords) {
            System.out.print(trie.search(word) + " ");
        }
        System.out.println();

        String[] prefixWords = {"ge", "ba", "do", "de"};
        for (String prefix : prefixWords) {
            System.out.print(trie.isPrefix(prefix) + " ");
        }
        System.out.println();

        System.out.println("Deleting 'do'...");
        trie.delete("do");
        System.out.println("Search 'do': " + trie.search("do"));       // false
        System.out.println("Prefix 'do': " + trie.isPrefix("do"));     // false (if no other "do*" words)
    }
}
