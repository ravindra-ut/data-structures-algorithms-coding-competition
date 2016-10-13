public class AddBigIntegers {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int i, j;
        int d, c=0;
        StringBuilder sb = new StringBuilder("");
        while(len1 >=0 && len2 >= 0){
            i = num1.charAt(len1) - '0';
            j = num2.charAt(len2) - '0';
            d = (i + j + c)%10;
            c = (i + j + c)/10;
            sb.append((char)(48 + d));
            len1--;
            len2--;
        }
        while(len1>=0){
            i = num1.charAt(len1) - '0';
            d = (i + c)%10;
            c = (i + c)/10;
            sb.append((char)(48 + d));
            len1--;
        }
        while(len2>=0){
            i = num2.charAt(len2) - '0';
            d = (i + c)%10;
            c = (i + c)/10;
            sb.append((char)(48 + d));
            len2--;
        }
        // most important add carry at the end
        if(c!=0){
            sb.append((char)(48 + c));
        }
        return sb.reverse().toString();
    }
}