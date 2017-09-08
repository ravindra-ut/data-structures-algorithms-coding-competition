class PalindromeList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        // now slow points to mid element
        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}