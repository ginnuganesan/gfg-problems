''' PROBLEM DESCRIPTION

Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106

'''

#Solution

class Solution:
	def addBinary(self, s1, s2):
		# code here
        s1 = s1[s1.find('1'):]
        s2 = s2[s2.find('1'):]
        
        m, n = len(s1), len(s2)
        
        if m < n:
            s1, s2 = s2, s1
            n, m = m, n
        
        j = n - 1
        carry = 0
        out = []
        for i in range(m - 1, -1, -1):
            bit_sum = int(s1[i])
            
            if j >= 0:
                bit_sum += int(s2[j])
                j -= 1
                
            bit_sum += carry
            out.append(str(bit_sum % 2))
            carry = bit_sum // 2
        
        if carry > 0:
            out.append(str(carry))
        
        return ''.join(out[::-1])
