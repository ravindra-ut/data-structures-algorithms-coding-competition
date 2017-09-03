class FirstUniqChar {
  public int firstUniqChar(String s) {
    int[] count = new int[26];
    for(int i=0; i<s.length(); i++){
        int index = s.charAt(i) - 'a';
        if(count[index] == 0){
            count[index] = -(i + 1);
        } else if(count[index] < 0){
            count[index] = 2; // repeating character
        }
    }
    int minIndex = 0;
    for(int i=0; i<26; i++){
        if(count[i] < 0){
            int currentIndex = Math.abs(count[i]);
            if(minIndex == 0 || minIndex > currentIndex){
                minIndex = currentIndex;
            }
        }
    }
    return (minIndex - 1);
  }
}