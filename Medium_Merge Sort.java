/* PROBLEM DESCRIPTION

Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
Example 1:

Input:
N = 5
arr[] = {4 1 3 9 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10 9 8 7 6 5 4 3 2 1}
Output:
1 2 3 4 5 6 7 8 9 10

Your Task:
You don't need to take the input or print anything. Your task is to complete the function merge() which takes arr[], l, m, r as its input parameters and modifies arr[] in-place such that it is sorted from position l to position r, and function mergeSort() which uses merge() to sort the array in ascending order using merge sort algorithm.

Expected Time Complexity: O(nlogn) 
Expected Auxiliary Space: O(n)

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105

*/

//Solution

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         List<Integer> temp = new ArrayList<>();
         int left = l, right = m+1;
         
         //compare left and right pointer and add to temp list
         while(left <= m && right <= r) {
             if(arr[left] <= arr[right]) {
                 temp.add(arr[left]);
                 left++;
             } else {
                 temp.add(arr[right]);
                 right++;
             }
         }
         
         //add any remaining elements in left array to temp directly
         //without comparison
         while(left <= m) {
             temp.add(arr[left]);
             left++;
         }
         
         //add any remaining elements in right array to temp directly
         //without comparison
         while(right <= r) {
             temp.add(arr[right]);
             right++;
         }
         
         //assign the sorted elements in temp to main array in their indices
         for(int i = l; i <= r; i++) {
             arr[i] = temp.get(i-l);
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l >= r) {
            return;
        }
        
        //find mid index
        int mid = (l+r)/2;
        
        mergeSort(arr, l, mid); //left half
        mergeSort(arr, mid+1, r); //right half
        
        merge(arr, l, mid, r); //merge the divided halves after sorting
    }
}
