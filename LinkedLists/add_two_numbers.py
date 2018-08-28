# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        elif l2 == None:
            return l1
        else:
            head = None
            tail = None
            carry = 0
            while (l1 is not None) and (l2 is not None):
                value = (l1.val + l2.val + carry ) % 10
                carry = (l1.val + l2.val + carry) // 10
                digit = ListNode(value)
                if head is None:
                    head = digit
                    tail = digit
                else:
                    tail.next = digit
                    tail = tail.next
                l1 = l1.next
                l2 = l2.next
            
            if l1 is None:
                remaining_digits = l2
            else:
                remaining_digits = l1
                
            while remaining_digits is not None:
                value = (remaining_digits.val + carry) % 10
                carry = (remaining_digits.val + carry) // 10
                digit = ListNode(value)
                tail.next = digit
                tail = tail.next
                remaining_digits = remaining_digits.next
            
            if carry != 0:
                digit = ListNode(carry)
                tail.next = digit
                tail = tail.next
            return head
