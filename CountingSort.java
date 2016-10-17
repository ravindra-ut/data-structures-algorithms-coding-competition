import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[100];
        for(int i=0; i < 100; i++){
            count[i] = 0;
        }
        int val;
        for(int i=0; i<n; i++){
            val = sc.nextInt();
            count[val] += 1;
        }
        int[] arr = new int[n];
        int i=0;
        int j=0;
        while(i<n){
            if(count[j] > 0){
                arr[i] = j;
                i++;
                count[j] -= 1;
            } else {
                j++;
            }
        }
        for(int k=0; k<n; k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }
}