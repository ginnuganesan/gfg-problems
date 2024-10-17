/* PROBLEM DESCRIPTION

Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
Note: 

The sublist should be in the order with respect to the original list.
Your have to return an array containing the both sub-linked lists.
Examples:

Input: LinkedList = 0->1->0->1->0->1
Output: 0->0->0 , 1->1->1
Explanation: After forming two sublists of the given list as required, we have two lists as: 0->0->0 and 1->1->1.

Input: LinkedList = 2->5->8->9->6
Output: 2->8->6 , 5->9
Explanation: After forming two sublists of the given list as required, we have two lists as: 2->8->6 and 5->9.
Input: LinkedList: 7 
Output: 7 , <empty linked list>
Constraints:
1 <= number of nodes <= 100
1 <= node -> data <= 104

*/

//Solution

/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node[] out = new Node[2];
        if(head != null && head.next == null) {
            out[0] = head;
            out[1] = null;
            return out;
        }
        Node temp = head;
        Node sub1 = new Node(-1);
        Node temp1 = sub1;
        Node sub2 = new Node(-1);
        Node temp2 = sub2;
        while(temp != null && temp.next != null) {
            temp1.next = temp;
            temp1 = temp1.next;
            temp2.next = temp.next;
            temp2 = temp2.next;
            temp = temp.next.next;
        }
        if(temp != null) {
            temp1.next = temp;
            temp1 = temp1.next;
        }
        if(temp1 != null) {
            temp1.next = null;
        }
        if(temp2 != null) {
            temp2.next = null;
        }
        out[0] = sub1.next;
        out[1] = sub2.next;
        return out;
    }
}
