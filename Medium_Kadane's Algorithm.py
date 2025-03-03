''' PROBLEM DESCRIPTION

Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.


Example 1:

Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
Example 2:

Input:
N = 4
Arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)

Your Task:
You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes Arr[] and N as input parameters and returns the sum of subarray with maximum sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107

'''

''' Java Solution

class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        // Your code here
        long maxCurrSum = 0;
        long maxTotalSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxCurrSum += arr[i];
            maxTotalSum = Math.max(maxTotalSum, maxCurrSum);
            if(maxCurrSum < 0) {
                maxCurrSum = 0;
            }
        }
        return maxTotalSum;
    }
    
}

'''
#Python Solution

class Solution:
    ##Complete this function
    #Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self,arr):
        ##Your code here
        n = len(arr)
        curr_sum = 0
        max_total_sum = -sys.maxsize - 1
        for i in range(n):
            curr_sum += arr[i]
            max_total_sum = max(max_total_sum, curr_sum)
            if curr_sum < 0:
                curr_sum = 0
        return max_total_sum
