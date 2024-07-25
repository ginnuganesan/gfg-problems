/* PROBLEM DESCRIPTION

Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatenating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Examples:

Input: n = 5, arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: Given numbers are  {"3", "30", "34", "5", "9"}, the arrangement "9534330" gives the largest value.
Input: n = 4, arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation: Given numbers are {"54", "546", "548", "60"}, the arrangement "6054854654" gives the largest value.
Expected Time Complexity: O(n*log(n) ).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ n ≤ 105
0 ≤ arr[i] ≤ 1018
The sum of all the elements of the array is greater than 0.

*/

//Solution

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        Comparator<String> comp = (a,b) -> (b + a).compareTo(a + b);
        Arrays.sort(arr, comp);
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder out = new StringBuilder();
        for(String str: arr) {
            out.append(str);
        }
        
        return out.toString();
    }
}
