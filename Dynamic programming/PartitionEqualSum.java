// can given array be divided into equal sum of two subsets
class PartitionEqualSum {
 
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean findPartition (int arr[], int n)
    {
        int sum = 0;
        int i, j;
 
        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum%2 != 0)
            return false;
 
        boolean part[][]=new boolean[sum/2+1][n+1];
 
        // initialize top row as true
        // 0 sum is possible with all subsets by {} empty set
        for (i = 0; i <= n; i++)
            part[0][i] = true;
 
        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;
 
        // Fill the partition table in botton up manner
        // i denotes the partial sum
        // j denotes the number of elements available
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                // if partial sum was possible from fewer
                // element subsets j - 1, it will be possible for j element subset
                part[i][j] = part[i][j-1];
                // partial sum is greater than current element
                // and sum is not possible check whether partial sum i - current element(j)
                // is possible without jth element.
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                                 part[i - arr[j-1]][j-1];
            }
        }
 
        return part[sum/2][n];
    }
}