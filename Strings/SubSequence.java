public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int pattern_len = s.length();
        for(int i = 0; i < t.length(); i++){
            if(j == pattern_len) break;
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
        }
        return j == pattern_len;
    }
}