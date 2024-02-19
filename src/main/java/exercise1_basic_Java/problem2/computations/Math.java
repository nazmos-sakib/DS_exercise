package exercise1_basic_Java.problem2.computations;

public class Math {
    public static int numberOfDivisors(int n){
        int numberOfDivisors = 0;
        for (int i = 1; i <= n; i++){
            if (n%i == 0){
                numberOfDivisors++;
            }
        }
        return numberOfDivisors;
    }

    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static boolean isPowerOfTwo(int n){
       if ( n < 1) return false;
       else if (n == 1) return true;
       else if (n % 2 != 0) return false;
       return isPowerOfTwo((n/2));
    }

    public static void main(String[] args){
        int n = 1;
        while (isPowerOfTwo(gcd(numberOfDivisors(n), numberOfDivisors(n * n * n)))){
            n++;
        }
        System.out.println(n);
    }
}
