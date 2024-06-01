/* PROBLEM DESCRIPTION

Given a doubly linked list and a position. The task is to delete a node from given position (position starts from 1) in a doubly linked list.

Example 1:

Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.
Example 2:

Input:
LinkedList = 1 <--> 5 <--> 2 <--> 9  
x = 1
Output: 5 2 9
Your Task:
The task is to complete the function deleteNode() which should delete the node at given position and return the head of the linkedlist.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
2 <= size of the linked list(n) <= 105
1 <= x <= n
1 <= node.data <= 109

*/

//Solution

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	// Your code here
	    Node xthNode = head;
	    int pos = 0;
	    while(xthNode != null) {
	        pos++;
	        if(pos == x) {
	            break;
	        }
	        xthNode = xthNode.next;
	    }
	    Node prev = xthNode.prev;
	    Node next = xthNode.next;
	    if(next == null) {
	        prev.next = null;
	        xthNode.prev = null;
	    } else if (prev == null) {
	        xthNode.next = null;
	        next.prev = null;
	        head = next;
	    } else {
	        prev.next = next;
	        next.prev = prev;
	        xthNode.prev = null;
	        xthNode.next = null;
	    }
	    return head;
    }
}
