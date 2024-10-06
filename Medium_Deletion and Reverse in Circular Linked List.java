/* PROBLEM DESCRIPTION

Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.

Note: You don't have to print anything, just return head of the modified list in each function.

Examples:

Input: Linked List: 2->5->7->8->10, key = 8

Output: 10->7->5->2 

Explanation:
After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10. Now, reversing this list will result in 10, 7, 5, 2.
Input: Linked List: 1->7->8->10, key = 8

Output: 10->7->1

Explanation: 
After deleting 8 from the given circular linked list, it has elements as 1, 7,10. Now, reversing this list will result in 10, 7, 1.
Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

Constraints:
2 <= number of nodes, key  <= 105
1 <= node -> data <= 105

*/

//Solution

/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        Node curr = head;
        Node prev = null;
        Node after = null;
        do {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        } while (curr != head);
        head.next = prev;
        head = prev;
        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
        if(head == null || (head.next == head && head.data == key)) {
            return null;
        }
        
        Node temp = head;
        Node prev = null;
        Node tail = head;
        do {
            tail = temp;
            temp = temp.next;
        } while (temp != head);
        prev = tail;
        temp = head;
        if(temp.data == key) {
            tail.next = head.next;
            head = head.next;
            return head;
        }
        
        while (temp != tail && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        
        if (temp.data == key) {
            prev.next = temp.next;
            if (temp == tail) {
                tail = prev;
            }
        }
        return head;
    }
}
