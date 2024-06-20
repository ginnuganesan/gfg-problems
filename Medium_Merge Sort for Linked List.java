/* PROBLEM DESCRIPTION

Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105

*/

//Solution

/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null) {
            return head;
        }
        
        Node mid = findMiddle(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;
        
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        
        return merge(leftHead, rightHead);
    }
    
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    static Node merge(Node leftHead, Node rightHead) {
        Node merged = new Node(-1);
        Node ptr = merged;
        
        while(leftHead != null && rightHead != null) {
            if(leftHead.data <= rightHead.data) {
                ptr.next = leftHead;
                leftHead = leftHead.next;
            } else {
                ptr.next = rightHead;
                rightHead = rightHead.next;
            }
            ptr = ptr.next;
        }
        while(leftHead != null) {
            ptr.next = leftHead;
            leftHead = leftHead.next;
            ptr = ptr.next;
        }
        while(rightHead != null) {
            ptr.next = rightHead;
            rightHead = rightHead.next;
            ptr = ptr.next;
        }
        
        return merged.next;
    }
}
