/* PROBLEM DESCRIPTION

Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105

*/

//Solution

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if(head == null || head.next == null) {
            return out;
        }
        Node left = head, right = findTail(head);
        while(left.data < right.data) {
            if(left.data + right.data == target) {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(left.data);
                item.add(right.data);
                out.add(item);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return out;
    }
    
    public static Node findTail(Node head) {
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}
