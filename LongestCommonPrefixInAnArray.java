/* PROBLEM DESCRIPTION

Given an array of N strings, find the longest common prefix among all strings present in the array.


Example 1:

Input:
N = 4
arr[] = {geeksforgeeks, geeks, geek,
         geezer}
Output: gee
Explanation: "gee" is the longest common
prefix in all the given strings.
Example 2:

Input: 
N = 2
arr[] = {hello, world}
Output: -1
Explanation: There's no common prefix
in the given strings.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonPrefix() which takes the string array arr[] and its size N as inputs and returns the longest common prefix common in all the strings in the array. If there's no prefix common in all the strings, return "-1".


Expected Time Complexity: O(N*min(|arri|)).
Expected Auxiliary Space: O(min(|arri|)) for result.


Constraints:
1 ≤ N ≤ 103

*/

//Solution

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        String first = arr[0];
        int count = 0;
        for(int i = 0; i < first.length(); i++) {
            int internalCounter = 0;
            for(int j = 1; j < arr.length; j++) {
                if(i < arr[j].length()) {
                    if(first.charAt(i) == arr[j].charAt(i)) {
                        internalCounter++;
                    } else {
                        if(count == 0)
                            return "-1";
                        return first.substring(0, count);
                    }
                } else {
                    if(count == 0)
                        return "-1";
                    return first.substring(0, count);
                }
                
            }
            if(internalCounter == n-1) {
                count++;
            }
            
        }
        if(count == 0)
            return "-1";
        return first.substring(0, count);
    }
}
