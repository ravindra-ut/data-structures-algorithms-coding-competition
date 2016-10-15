import java.util.*;

// Running median for sliding window
public class ShortestReach {

 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int query = sc.nextInt();
   int cost = 6;
   for(int i = 0; i < query; i++){
     int n = sc.nextInt();
     int e = sc.nextInt();
     boolean[] visited = new boolean[n+1];
     int[] distance = new int[n+1];
     final HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(n);
     for(int j=0; j < e; j++){
       int v1 = sc.nextInt();
       int v2 = sc.nextInt();
       if(!graph.containsKey(v1)){
         graph.put(v1, new ArrayList<Integer>());
       }
       if(!graph.containsKey(v2)){
         graph.put(v2, new ArrayList<Integer>());
       }
       graph.get(v1).add(v2);
       graph.get(v2).add(v1);
     }
     int start = sc.nextInt();
     distance[start] = 0;
     visited[start] = true;
     LinkedList<Integer> q = new LinkedList<Integer>();
     q.addLast(start);
     while(!q.isEmpty()){
       int source = q.removeFirst();
       List<Integer> neighbours = graph.get(source);
       if(neighbours==null){
         continue;
       }
       for(int k = 0; k < neighbours.size(); k++){
         int neighbour = neighbours.get(k);
         if(visited[neighbour] != true){
           q.addLast(neighbour);
           // mark node as visited
           // update distance
           visited[neighbour] = true;
           distance[neighbour] = distance[source] + cost;
         }
       }
     }
     for(int k=1; k <=n; k++){
       if(k != start){
         if(distance[k] > 0){
           System.out.print(distance[k] + " ");
         } else {
           System.out.print("-1 ");
         }
       }
     }
     System.out.println();
   }
 }
}