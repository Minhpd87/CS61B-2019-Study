public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(9));
        System.out.println(fib2(9, 0, 0, 1));
    }

    public static int fib(int n) {
        //take an integer and return n-th fibonacci
        if (n <= 1) { //this is the base case, 0 and 1
            return n;
        }
        return fib(n - 1) + fib(n - 2); //will continue to run until it reaches the base case
    }

    public static int fib2(int n, int k, int f0, int f1) {
        //return the n-th fibonacci based on the value of fibonacci number at k position
        if (n == k) {  //the base case when n = k then f0 is the answer
            return f0; //f0 is the fibo at k, f1 is the fibo at k+1
        }
        return fib2(n, k + 1, f1, f0 + f1); //continually to increase k until it equals n and give us the answer
    }
}