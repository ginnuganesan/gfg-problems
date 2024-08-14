/* PROBLEM DESCRIPTION

Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list.  So if the next of the previous node is null. then there is no loop.  Remove the loop from the linked list, if it is present (we mainly need to make the next of the last node null). Otherwise, keep the linked list as it is.

Note: Given an integer, pos (1 based index)  Position of the node to which the last node links back if there is a loop. If the linked list does not have any loop, then pos = 0.

The generated output will be true if your submitted code is correct, otherwise, false.

Examples:

Input: Linked list: 1->3->4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present. If you remove it successfully, the answer will be true. 
Input: Linked list: 1->8->3->4, pos = 0
Output: true
Explanation: 

The Linked list does not contains any loop. 
Input: Linked list: 1->2->3->4, pos = 1
Output: true
Explanation: The linked list looks like 

A loop is present. If you remove it successfully, the answer will be true. 
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 ≤ size of linked list ≤ 105

*/

//Solution

/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                remove(slow, head);
            }
        }
    }
    
    public static void remove(Node ptr, Node head) {
        Node ptr1 = ptr;
        Node ptr2 = ptr;
        
        int lengthOfLoop = 1;
        while(ptr2.next != ptr1) {
            ptr2 = ptr2.next;
            lengthOfLoop++;
        }
        
        ptr1 = head; ptr2 = head;
        for(int i = 0; i < lengthOfLoop; i++) {
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while(ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }
}
