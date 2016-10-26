import java.util.Scanner;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder(scanner.next());
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                str = str.delete(i-1, i+1);
                i = 0;
            }
        }
        if (str.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(str);
        }
    }
}