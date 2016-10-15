import java.util.*;

// Running median for sliding window
public class RunningMedian {
 PriorityQueue<Integer> minHeap;
 PriorityQueue<Integer> maxHeap;

 public void medianSlidingWindow(int[] nums, int k) {
   if (nums == null || nums.length == 0 || k <= 0) {
     return;
   }
   minHeap = new PriorityQueue<Integer>();
   maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
      public int compare(Integer x, Integer y){
       return y - x;
      }
   });
   maxHeap.offer(nums[0]);

   for (int i = 1; i < k; i++) {
     add(nums[i]);
   }
     
   double median = this.median();
   int current_spend = 0;
   int notification = 0;
   for (int i = k; i < nums.length; i++) {
     current_spend = nums[i];
     if(current_spend >= (2 * median)){
       notification += 1;
     }
     add(current_spend);
     remove(nums[i - k]);
     median = this.median();
   }
   System.out.println(notification);
 }

 public void add(int val) {
   int preMedian = maxHeap.peek();
   if (val > preMedian) {
     minHeap.offer(val);
   } else {
     maxHeap.offer(val);
   }
   balance();
 }

 public void remove(int val) {
   int preMedian = maxHeap.peek();
   if (val > preMedian) {
     minHeap.remove(val);
   } else {
     maxHeap.remove(val);
   }
   balance();
 }

 public void balance() {
   if (maxHeap.size() > minHeap.size() + 1) {
     minHeap.offer(maxHeap.poll());
   } else if (maxHeap.size() < minHeap.size()) {
     maxHeap.offer(minHeap.poll());
   }
 }
 
 public double median(){
   int maxSize = maxHeap.size();
   int minSize = minHeap.size();
   double median;
   if(maxSize == minSize){
     median = (maxHeap.peek() + minHeap.peek()) / 2.0;
   } else if(maxSize > minSize){
     median = maxHeap.peek();
   } else {
     median = minHeap.peek();
   }
   return median;
 }
 
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int k = sc.nextInt();
   int[] arr = new int[n];
   for(int i = 0; i < n; i++){
     arr[i] = sc.nextInt();
   }
   RunningMedian rm = new RunningMedian();
   rm.medianSlidingWindow(arr, k);
 }
}