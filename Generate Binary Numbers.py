''' PROBLEM DESCRIPTION

Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 4
Output: ["1", "10", "11", "100"]
Explanation: Binary numbers from 1 to 4 are 1, 10, 11 and 100.
Input: n = 6
Output: ["1", "10", "11", "100", "101", "110"]
Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.
Constraints:
1 ≤ n ≤ 10^6

'''

#Solution

class Solution:
    def generateBinary(self, n):
        # code here
        res = []
        for i in range (1, n+1):
            res.append(self.getBinary(i))
        return res
        
    def getBinary(self, num):
        binary = []
        while num > 1:
            binary.append(str(num % 2))
            num = num // 2
        binary.append(str(num))
        binary.reverse()
        return ''.join(binary)
