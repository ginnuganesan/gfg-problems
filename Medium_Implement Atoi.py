''' PROBLEM DESCRIPTION

Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

Cases for atoi() conversion:

Skip any leading whitespaces.
Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
Examples:

Input: s = "-123"
Output: -123
Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
Input: s = "  -"
Output: 0
Explanation: No digits are present, therefore the returned answer is 0.
Input: s = " 1231231231311133"
Output: 2147483647
Explanation: The converted number will be greater than 231 – 1, therefore print 231 – 1 = 2147483647.
Input: s = "-999999999999"
Output: -2147483648
Explanation: The converted number is smaller than -231, therefore print -231 = -2147483648.
Input: s = "  -0012gfg4"
Output: -12
Explanation: Nothing is read after -12 as a non-digit character ‘g’ was encountered.
Constraints:
1 ≤ |s| ≤ 15

'''

#Solution

class Solution:
    def myAtoi(self, s):
        # Code here
        s = s.strip()
        if(s == "" or s == "+" or s == "-" or
            s[0].isalpha() or 
            s[0] == '.' or
            (len(s) > 1 and ((s[0] == '-' or s[0] == '+') and s[1].isalpha())) or
            s.startswith("+-") or s.startswith("-+") or
            s.find("+ ") >= 0 or s.find("- ") >= 0):
            return 0
        out = ""
        num = 0
        for i in range(len(s)):
            if(i > 0 and not(s[i].isdigit())):
                break
            else:
                out += s[i]
        if out == "+" or out == "-":
            return num
        if out.startswith("-"):
            num = -1 * int(out[1:])
        elif out.startswith("+"):
            num = int(out[1:].strip())
        else:
            num = int(out)

        if num >= 2147483648:
            num = 2147483647
        elif num < -2147483648:
            num = -2147483648
        return num
