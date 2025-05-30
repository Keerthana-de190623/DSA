
// Java program to rearrange array in alternating
// Java program to copy set bits in a given
// range [l, r] from y to x.

class GFG{

// Copy set bits in range [l, r] from y to x.
// Note that x is passed by reference and modified
// by this function.
static int copySetBits(int x, int y,
                 int l, int r)
{
   // l and r must be between 1 to 32
   // (assuming ints are stored using
   //  32 bits)
   if (l < 1 || r > 32)
      return x;

   // Traverse in given range
   for (int i = l; i <= r; i++)
   {
       // Find a mask (A number whose
       // only set bit is at i'th position)
       int mask = 1 << (i-1);

       // If i'th bit is set in y, set i'th
       // bit in x also.
       if ((y & mask)!=0)
          x = x | mask;
   }
   
   return x;
}

// Driver code
public static void main(String[] args)
{
   int x = 10, y = 13, l = 1, r = 32;
  x = copySetBits(x, y, l, r);
   System.out.print("Modified x is " +  x);
} 
}

// This code is contributed by umadevi9616