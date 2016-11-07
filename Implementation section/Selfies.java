import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Selfies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int friends = sc.nextInt();
        int frame_needed = (int)Math.pow(2, friends) - 1;
        int have_frames = sc.nextInt();
        System.out.println(Math.abs(frame_needed - have_frames));
    }
}