import java.util.Arrays;

class QuickSort{

  public static void quickSort(int[] arr, int start, int end){
    if(start >= end){
      return;
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
    // recursively sort
    if(start < j){
      quickSort(arr, start, j);
    }
    if(i < end){
      quickSort(arr, i, end);
    }
  }
  
  public static void main(String[] args) {
    int[] arr = { 9, 2, 4, 7, 3, 7, 10 };
    System.out.println(Arrays.toString(arr));
 
    int low = 0;
    int high = arr.length - 1;
    quickSort(arr, low, high);
    System.out.println(Arrays.toString(arr));
 }
}