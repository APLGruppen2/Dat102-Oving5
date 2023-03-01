public class B {
    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++){
            System.out.println(sum(n));
        }
    }

    public static int sum(int n){
            if (n == 0) {
                return 2;
            } else if (n == 1) {
                return 5;
            } else {
                return ((5 * sum(n-1)) - (6 * sum(n-2)) + 2);
            }
    }

}
