''' PROBLEM DESCRIPTION

Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

Examples:

Input : s = "2911285"
Output : true
Explanation: 2911285 / 13 = 223945, which is a whole number with no remainder.
Input : s = "27"
Output : false
Explanation: 27 / 13 ≈ 2.0769..., which is not a whole number (there is a remainder).
Constraints:
1 ≤  s.size()  ≤ 10^5

'''

#Solution

class Solution:
    def divby13(self, s):
        # code here
        # formula -> rem = (rem * 10 + digit) % 13
        rem = 0
        for char in s:
            rem = (rem * 10 + int(char)) % 13
        return rem == 0
