import java.util.Arrays;

class QuickSelect{

  public static int quickSelect(int[] arr, int start, int end, int k){
    // elements are DISTINCT!!!! assumption
    if(start >= end){
      return Integer.MAX_VALUE;
    }
    
    int mid = start + (end - start)/2;
    int pivot = arr[mid];
    int i = start, j = end;
    
    while(i<=j){
      // left index forwarding
      while(arr[i] < pivot){
        i++;
      }
      // right index backward
      while(arr[j] > pivot){
        j--;
      }
      // check left, right index not crossed
      if(i<=j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
    
    if(i - 1 == k - 1){
      return pivot;
    } else if(i - 1 > k - 1){
      return quickSelect(arr, start, i - 1, k);
    } else {
      return quickSelect(arr, i + 1, end, k);
    }
  }
  
  public static void main(String[] args) {
    for(int i=1; ; i++){
      // reset array now as we are testing here
      int[] arr = { 9, 2, 4, 7, 3, 8, 10 };
      int low = 0;
      int high = arr.length - 1;
      System.out.println(quickSelect(arr, low, high, i));
      if(i > high + 1){
        break;
      }
    }
 }
}