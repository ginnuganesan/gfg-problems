/* PROBLEM DESCRIPTION

https://www.geeksforgeeks.org/problems/juggler-sequence3930/1

Juggler Sequence is a series of integers in which the first term starts with a positive integer number a and the remaining terms are generated from the immediate previous term using the below recurrence relation:

Juggler Formula

Given a number n, find the Juggler Sequence for this number as the first term of the sequence until it becomes 1.


Example 1:

Input: n = 9
Output: 9 27 140 11 36 6 2 1
Explaination: We start with 9 and use 
above formula to get next terms.
 

Example 2:

Input: n = 6
Output: 6 2 1
Explaination: 
[61/2] = 2. 
[21/2] = 1.
 

Your Task:
You do not need to read input or print anything. Your Task is to complete the function jugglerSequence() which takes n as the input parameter and returns a list of integers denoting the generated sequence.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

 

Constraints:
1 ≤ n ≤ 100

*/

//Solution

class Solution {
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> out = new ArrayList<>();
        out.add(n);
        while(n != 1) {
            if(n % 2 == 0) {
                n = (long)Math.sqrt(n);
            } else {
                n = (long)(n * Math.sqrt(n));
            }
            out.add(n);
        }
        return out;
    }
}
