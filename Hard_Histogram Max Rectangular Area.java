/* PROBLEM DESCRIPTION

You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

*/

//Solution

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        
        //to solve this problem we need to find right small and left small
        //indices of each histogram element and subract them which becomes the
        //width and the current element value becomes the height
        //i.e [rightSmall - leftSmall + 1] * currentElem = area
        
        //First find all left small indices of each element using 
        //NEXT GREATER ELEMENT logic
        ///https://github.com/ginnuganesan/gfg-problems/blob/main/Medium_Next%20Greater%20Element.java
        int[] leftSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            leftSmall[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            
            stack.push(i);
        }
        
        //Clear the stack after finding left small indices
        stack.clear();
        
        //then find right small indices using a small tweak in above logic
        int[] rightSmall = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            rightSmall[i] = stack.isEmpty() ? n-1 : stack.peek() - 1;
            
            stack.push(i);
        }
        
        //Now apply the area of triangle formula as mentioned above
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, ((rightSmall[i] - leftSmall[i] + 1) * arr[i]));
        }
        
        return maxArea;
    }
}
