import java.util.*;

public class MergeTwoSortedArrays{

  // List A assumed to bigger and containing enough spaces
  // to accomodate B.
  public static void mergeTwoSortedArrays(List<Integer> A, int m, 
                                          List<Integer> B, int n) {
    int a = m - 1, b = n - 1, writeIdx = m + n - 1;
    while (a >= 0 && b >= 0) {
      if( A.get(a) > B.get(b)) {
        A.set(writeIdx, A.get(a));
        a--;
      } else {
        A.set(writeIdx, B.get(b));
        b--;
      }
      writeIdx--;
    }
    while (b >= 0) {
      A.set(writeIdx , B.get(b));
      b--;
    }
  }
}