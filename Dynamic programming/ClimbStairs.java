public class ClimbStairs {
    public int climbStairs(int n) {
      if(n == 0){
        return 0;
      }else if(n == 1){
        return 1;
      } else if(n == 2) {
        return 2;
      } else {
        int result = 0;
        int f1 = 1;
        int f2 = 2;
        for(int i=3; i<=n; i++){
          result = f1 + f2;
          f1 = f2;
          f2 = result;
        }
        return result;
      }
    }
}