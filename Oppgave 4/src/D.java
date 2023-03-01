public class D {
    public static void main(String[] args) {
        int n = 10;

        if (n <= 1) {
            System.out.println(n);
        }

        int prev1 = 0;
        int prev2 = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;

            System.out.println(sum);
        }
    }
}
