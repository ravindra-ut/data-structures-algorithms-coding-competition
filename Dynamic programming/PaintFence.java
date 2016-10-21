/*Paint Fence

There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
*/

public class PaintFence{
  // n = number of posts
  // k = number of colors
  // only two neighboring fences can have same color
  public static int paintFence(int n, int k){
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return k;
    }
    int[] same = new int[n + 1];
    int[] diff = new int[n + 1];
    same[2] = k;
    diff[2] = k * (k - 1);
    
    for(int i=3; i<=n; i++){
      // same[3] = diff[2]
      same[i] = diff[i - 1];
      // diff[i] = (k - 1) * total[i - 1]
      //         = (k - 1) * (same[i - 1] + diff [ i - 1])
      diff[i] = (k - 1) * (same[i-1] + diff [ i - 1]);
    }
    return same[n] + diff[n];
  }
}