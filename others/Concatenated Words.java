class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> memo = new HashMap<>(); // For memoization
        
        for (String word : words) {
            if (isConcatenated(word, wordSet, memo)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenated(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        // If the word is already computed, return the result
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        
        // Check if the word can be split into other words
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            
            // Check if the prefix is in the set and the suffix is a word or can be split recursively
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isConcatenated(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }
        
        // Mark as false if no valid split is found
        memo.put(word, false);
        return false;
    }
}