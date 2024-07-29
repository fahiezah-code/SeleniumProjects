package SDETJavaProgram;

public class Problems {

    public static void main(String[] args) {

        //System.out.println(checkOddOrEvenNumber(28));
        //System.out.println(checkIsPrimeNumber(2));
        // findFibonacci(7);
        //  swapNumber(5,7);
        // System.out.println(findFactorialNum(5));
        System.out.println(reverseNumber(109767));


    }

    //Java program to Find Odd or Even number
    public static String checkOddOrEvenNumber(int num) {
        String ans = "";
        if (num % 2 == 0) {
            ans = "This is Even Number";
        } else {
            ans = "This is Odd Number";
        }
        return ans;
    }


    //to find a Prime number
    public static boolean checkIsPrimeNumber(int num) {
        //should not be able to divide by any number except itself

        for (int i = 2; i <= num / 2; i++) { ///*** i<= num/2 ****
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //to find Fibonacci series upto a given number range
    public static void findFibonacci(int num) {
        // third value = firstValue + secondValue; till given number

        int first = 0;
        int second = 1;
        int next = 0;
        for (int i = 0; i <= num; i++) {

            System.out.println(first + " ");
            next = first + second;
            first = second;
            second = next;

        }

    }

    public static void swapNumber(int a, int b) {
        a = a + b;  // a = 5, b = 7  // 12
        b = a - b; // b = 5
        a = a - b;
        System.out.println("After swapping: a= " + a + " b= " + b);
    }

    // Input: 5!
    // Output: 5! = 5*4*3*2*1 = 120
    public static int findFactorialNum(int num) {
        int factorial = 1;
        for (int i = num; i > 0; i--) {
            factorial = factorial * i;
            System.out.print(i + "* ");
        }
        return factorial;
    }

    public static int reverseNumber(int num) {

        // 2345 --> lastDigit = 5 num%10
        // reverseNum = reverseNum * 10 + lastDigit
        // currentNum = num/10 =234
        int lastDigit = 0;
        int reverseNum = 0;
        while (num > 0) {
            lastDigit = num % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            num = num / 10;
        }
        return reverseNum;
    }

    // the sum of nth power of its digit, eg: 153 = 1^3 + 5^3 + 3^3
    public static boolean isArmStrongNumber(int num) {

        //find length of number
        int len = 0;
        int temp = num;
        int sum = 0; int originalNum = num;

        while (num > 0) { //0
            num = num / 10;  //1/10--> 0
            len++;  //3
        }

        while (temp > 0) {
            int digit = temp % 10;  //3
            sum += digit ^ len;  //
            temp = temp / 10;
        }

        return originalNum == sum;
    }

    /*
 153
 find num of length = 3
    convert 153 to digits ->  153/10
    find nth power of each digit
    add into sumValue

     */


}
