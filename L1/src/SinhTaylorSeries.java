public class SinhTaylorSeries  {
    public static double calculation(int k, double x) {
        int i = 1;
        double member = 0;
        double result = 0;
        do {
            result += member;
            member = Math.pow(x, i) / factorial(i);
            i += 2;
        } while(Math.pow(10, -k) <= Math.abs(member));
        return result;
    }

    private static long factorial(int n) {
        if (n == 0)
        {
            return 1;
        }
        return n * factorial(n-1);
    }
}