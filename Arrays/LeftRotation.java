import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        if(r>n){
            r = r % n;
        }
        int[] arr = new int[n];
        int[] rotate = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            int ri = i - r;
            if(ri < 0){
                ri = ri + n;
            }
            rotate[ri] = arr[i];
        }
        for(int i=0; i<n; i++){
            System.out.printf("%d ", rotate[i]);
        }
    }
}