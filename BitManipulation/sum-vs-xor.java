import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumVsXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long zeroCount = 0;
        // n ^ i == n + i,
        // xor operator is bit addition operator without carrying to next bit.
        while(n != 0){
            if((n&1) == 0){
                zeroCount += 1;
            }
            n = n >> 1;
        }
        System.out.println((long)Math.pow(2, zeroCount));
    }
}