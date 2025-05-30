package greedy;
import java.util.ArrayList;
import java.util.List;
public class Maximum_equal_sum_of_three_stacks {
    public static int maxSum(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Manually summing the elements of s1
        for (int i = 0; i < s1.size(); i++) {
            sum1 += s1.get(i);
        }

        // Manually summing the elements of s2
        for (int i = 0; i < s2.size(); i++) {
            sum2 += s2.get(i);
        }

        // Manually summing the elements of s3
        for (int i = 0; i < s3.size(); i++) {
            sum3 += s3.get(i);
        }

        int top1 = 0, top2 = 0, top3 = 0;

        while (true) {
            if (top1 == s1.size() || top2 == s2.size() || top3 == s3.size())
                return 0;

            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= s1.get(top1++);
            else if (sum2 >= sum1 && sum2 >= sum3)
                sum2 -= s2.get(top2++);
            else
                sum3 -= s3.get(top3++);
        }
    }

    public static void main(String[] args) {
        List<Integer> s1 = new ArrayList<>();
        s1.add(3);
        s1.add(2);
        s1.add(1);
        s1.add(1);
        s1.add(1);

        List<Integer> s2 = new ArrayList<>();
        s2.add(4);
        s2.add(3);
        s2.add(2);

        List<Integer> s3 = new ArrayList<>();
        s3.add(1);
        s3.add(1);
        s3.add(4);
        s3.add(1);

        System.out.println(maxSum(s1, s2, s3));
    }
}
