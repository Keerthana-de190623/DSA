class GfG {
    
    // Function to divide a by b and
    // return floor value of the result
    static long divide(long a, long b) {
        if(a == 0)
            return 0;

        // The sign will be negative only if sign of 
        // divisor and dividend are different
        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

        // Convert divisor and dividend to positive numbers
        a = Math.abs(a);
        b = Math.abs(b);

        // Initialize the quotient
        long quotient = 0;

        // Perform repeated subtraction till dividend
        // is greater than divisor
        while (a >= b) {
            a -= b;
            ++quotient;
        }
        return quotient * sign;
    }

    public static void main(String[] args) {
        long a = 43, b = -8;
        System.out.println(divide(a, b));

    }
}