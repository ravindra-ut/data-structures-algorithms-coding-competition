//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5

//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Input: [7, 6, 4, 3, 1]
//Output: 0

//In this case, no transaction is done, i.e. max profit = 0.

public class StockPrize {
    public int maxProfit(int[] prices) {
      int result = 0;
      int len = prices.length;
      if(len == 0 || len == 1){
        return result;
      }
      int min_upto_i = prices[0];
      int temp = 0;
      for(int i=1; i<len; i++){
        if(min_upto_i < prices[i]){
          temp = prices[i] - min_upto_i;
          if(temp > result){
            result = temp;
          }
        } else {
          min_upto_i = prices[i];
        }
      }
      return result;
    }
}