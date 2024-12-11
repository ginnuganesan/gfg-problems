''' PROBLEM DESCRIPTION

Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a so that it contains the first n elements and modify b so that it contains the last m elements.

Examples:

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 5 10 12 18 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.
Constraints:
1 <= a.size(), b.size() <= 105
0 <= a[i], b[i] <= 107

'''

#Java Solution

'''
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        long k = n+m;
        long[] merge = new long[(int)k];
    
        long n1Pos, n2Pos, merPos;
        n1Pos = n2Pos = merPos = 0;
        while (n1Pos < n && n2Pos < m) {
            if(arr1[(int)n1Pos] < arr2[(int)n2Pos]) {
                merge[(int)merPos] = arr1[(int)n1Pos];
                merPos++;
                n1Pos++;
            } else {
                merge[(int)merPos] = arr2[(int)n2Pos];
                merPos++;
                n2Pos++;
            }
        }
        while (n1Pos < n) {
            merge[(int)merPos] = arr1[(int)n1Pos];
            merPos++;
            n1Pos++;
        }
        while (n2Pos < m) {
            merge[(int)merPos] = arr2[(int)n2Pos];
            merPos++;
            n2Pos++;
        }
        for(int i = 0; i < k; i++) {
            if(i < n) {
                arr1[i] = merge[i];
            } else {
                arr2[i-n] = merge[i];
            } 
        }
    }
}
'''

#Python Solution

class Solution:
    def mergeArrays(self, a, b):
        # code here
        m, n = len(a), len(b)
        i, j = m - 1, 0
        
        while i >= 0 and j < n:
            if a[i] > b[j]:
                a[i], b[j] = b[j], a[i]
                i -= 1
                j += 1
            else:
                break
        
        a.sort()
        b.sort()
