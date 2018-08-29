class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_len = 0
        table = {}
        # two pointer method
        # left and right pointer
        # right pointer is advanced every iteration
        # left pointer is reset when a repeating character found
        # for example: abcabcbb
        #              l r
        #               l r
        #           2) abbba
        #              lr
        #                l
        #                r
        # .               l
        #                 r
        #                 l
        #                  r << here max(left, table[char] + 1) prevents setting pointer back to index 2
        left = 0
        for right, char in enumerate(s):
            if char in table:
                left = max(left, table[char] + 1)
            table[char] = right
            max_len = max(max_len, right - left + 1)
        return max_len
