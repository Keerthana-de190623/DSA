//Calculate square of a number without using *, / and pow()


// Java Simple solution to calculate
// square without using * and pow()

class GFG {

    public static int square(int n)
    {

        // handle negative input
        if (n < 0)
            n = -n;

        // Initialize result
        int res = n;

        // Add n to res n-1 times
        for (int i = 1; i < n; i++)
            res += n;

        return res;
    }

    // Driver code
    public static void main(String[] args)
    {

        for (int n = 1; n <= 5; n++)
            System.out.println("n = " + n
                               + ", n^2 = " + square(n));
    }
}

// This code is contributed by sunnysingh