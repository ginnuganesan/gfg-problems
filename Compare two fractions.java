/* PROBLEM DESCRIPTION

You are given a string str containing two fractions a/b and c/d, compare them and return the greater. If they are equal, then return "equal".

Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )). 

Examples

Input: str = "5/6, 11/45"
Output: 5/6
Explanation: 5/6=0.8333 and 11/45=0.2444, So 5/6 is greater fraction.
Input: str = "8/1, 8/1"
Output: equal
Explanation: We can see that both the fractions are same, so we'll return a string "equal".
Input: str = "10/17, 9/10"
Output: 9/10
Explanation: 10/17 = 0.588 & 9/10 = 0.9, so the greater fraction is "9/10".
Expected Time Complexity: O(len|str|)
Expected Auxiliary Space: O(1)

Constraints:
0<=a,c<=103
1<=b,d<=103

*/

//Solution

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] arr = str.split(", ");
        String[] arr0 = arr[0].split("/");
        String[] arr1 = arr[1].split("/");
        float arr0quo = Float.parseFloat(arr0[0]) / Float.parseFloat(arr0[1]);
        float arr1quo = Float.parseFloat(arr1[0]) / Float.parseFloat(arr1[1]);
        if(arr0quo > arr1quo) return arr[0];
        else if(arr0quo < arr1quo) return arr[1];
        return "equal";
    }
}
