import java.util.PriorityQueue;

class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();  // Remove smallest
            }
        }

        return minHeap.peek();  // Top of the heap is the k-th largest
    }
}
