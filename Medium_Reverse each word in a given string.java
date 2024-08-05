/* PROBLEM DESCRIPTION

Given a String. Reverse each word in it where the words are separated by dots.

Example 1:

Input:
S = "i.like.this.program.very.much"
Output: 
i.ekil.siht.margorp.yrev.hcum
Explanation: 
The words are reversed as
follows:"i" -> "i","like"->"ekil",
"this"->"siht","program" -> "margorp",
"very" -> "yrev","much" -> "hcum".
Example 2:

Input: 
S = "pqr.mno"
Output: 
rqp.onm
Explanation: 
The words are reversed as
follows:"pqr" -> "rqp" ,
"mno" -> "onm"

Your Task:
You don't need to read input or print anything. Your task is to complete the functionreverseWords()which takes the string S as input and returns the resultant string by reversing all the words separated by dots.


Expected Time Complexity:O(|S|).
Expected Auxiliary Space:O(|S|).


Constraints:
1<=|S|<=105

*/

//Solution

class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        String[] arr = Arrays.stream(S.split("\\.")).map(s -> new StringBuilder(s).reverse().toString()).toArray(String[]::new);
        StringBuilder res = new StringBuilder(String.join(".", arr));
        if(S.endsWith(".")) {
            for(int i = S.length() - 1; i >= 0; i--) {
                if(S.charAt(i) == '.') {
                    res.append(".");
                } else {
                    break;
                }
            }
        }
        return res.toString();
    }
}
