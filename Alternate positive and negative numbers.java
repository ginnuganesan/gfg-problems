/* PROBLEM DESCRIPTION

Given an unsorted array arr containing both positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with a positive number and 0 (zero) should be considered a positive element.

Examples:

Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
Output: 9 -2 4 -1 5 -5 0 -3 2
Explanation: Positive elements : [9,4,5,0,2]
Negative elements : [-2,-1,-5,-3]
As we need to maintain the relative order of postive elements and negative elements we will pick each element from the positive and negative and will store them. If any of the positive and negative numbersare completed. we will continue with the remaining signed elements.
The output is 9,-2,4,-1,5,-5,0,-3,2.
Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: 5 -5 2 -2 4 -8 7 1 8 0
Explanation : Positive elements : [5,2,4,7,1,8,0]
Negative elements : [-5,-2,-8]
The output is 5, -5, 2, -2, 4, -8, 7, 1, 8, 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 107
-106 ≤ arr[i] ≤ 107

*/

//Solution

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(Integer num: arr) {
            if(num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        int posL = positive.size();
        int negL = negative.size();
        int i = 0, j = 0, k = 0;
        while(i < posL || j < negL) {
            if(i < posL) {
                arr.set(k, positive.get(i));
                k++;
                i++;
            }
            if(j < negL) {
                arr.set(k, negative.get(j));
                k++;   
                j++;
            }
        }
    }
}
