public class MinMaxFinder {

    public static int setMin(int[] A, int N) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] < mini) {
                mini = A[i];
            }
        }
        return mini;
    }

    public static int setMax(int[] A, int N) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] > maxi) {
                maxi = A[i];
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] a = {15, 89, 75, 1, 45, 788, 654, 11111, 4745, 42};
        int n = a.length;

        System.out.println("Minimum element: " + setMin(a, n));
        System.out.println("Maximum element: " + setMax(a, n));
    }
}
