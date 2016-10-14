import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedFib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t1 = sc.nextLong();
        long t2 = sc.nextLong();
        long n = sc.nextLong();
        BigInteger T1 = BigInteger.valueOf(t1);
        BigInteger T2 = BigInteger.valueOf(t2);
        BigInteger Result = T1;
        for(int i=3; i<=n; i++){
          Result = T1;
          T1 = T2;
          T2 = T2.multiply(T2);
          Result = Result.add(T2);
          T2 = Result;
        }
        if(n==1){
          Result = T1;
        } else if(n==2){
          Result = T2;
        }
        System.out.println(Result);
    }
}