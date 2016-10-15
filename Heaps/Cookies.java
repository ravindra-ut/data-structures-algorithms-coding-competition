import java.util.*;

// Running median for sliding window
public class Cookies {
 
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int sweet_th = sc.nextInt();
   Cookies ck = new Cookies();
   int val;
   // build a minheap if val < sweet_th
   PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
   boolean crossed_th = false;
   for(int i = 0; i < n; i++){
     val = sc.nextInt();
     if(val < sweet_th){
       minHeap.offer(val);
     } else {
       crossed_th = true;
     }
   }
   int k1 = 0, k2 = 0, k3 = 0;
   int process_count = 0;
   boolean last = false;
   while(minHeap.size()!=0){
     k1 = minHeap.remove();
     if(minHeap.size()!=0){
       k2 = minHeap.remove();
     } else {
       last = true;
       break;
     }
     k3 = k1 + 2 * k2;
     if(k3 < sweet_th){
       minHeap.offer(k3);
     } else {
       crossed_th = true;
     }
     process_count += 1;
   }
   if(last){
     if(crossed_th){
       // mixes last one with some greater sweetness cookie
       process_count += 1;
     } else {
       process_count = -1;
     }
   }
   System.out.println(process_count);
 }
}