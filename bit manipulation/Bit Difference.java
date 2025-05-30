class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        String bst1 = Integer.toBinaryString(a);
        String bst2 = Integer.toBinaryString(b);
        int len1 = bst1.length();
        int len2 = bst2.length();
        if (len1 < len2) {
            bst1 = "0".repeat(len2 - len1) + bst1;
        } else if (len2 < len1) {
            bst2 = "0".repeat(len1 - len2) + bst2;
        }
        int count = 0;
        for (int i = 0; i < bst2.length(); i++) {
            if (bst1.charAt(i) != bst2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}