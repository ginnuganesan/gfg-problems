/* PROBLEM DESCRIPTION

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457
Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 1021

*/

//Solution

/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node rev = reverse(head);
        Node revTemp = rev;
        Node out = new Node(-1);
        Node temp = out;
        int carry = 0;
        while(rev != null) {
            int sum = rev == revTemp ? rev.data + 1 + carry : rev.data + carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            rev = rev.next;
        }
        if(carry > 0) {
            temp.next = new Node(carry);
        }
        return reverse(out.next);
    }
    
    public static Node reverse(Node head) {
        Node before = null;
        Node temp = head;
        Node after = null;
        while(temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}


//Better Solution

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node rev = reverse(head);
        Node revTemp = rev;
        int carry = 1;
        while(revTemp != null) {
            revTemp.data = revTemp.data + carry;
            if(revTemp.data < 10) {
                carry = 0;
                break;
            }
            revTemp.data = 0;
            carry = 1;
            revTemp = revTemp.next;
        }
        if(carry > 0) {
            Node newNode = new Node(carry);
            head = reverse(rev);
            newNode.next = head;
            return newNode;
        }
        return reverse(rev);
    }
    
    public static Node reverse(Node head) {
        Node before = null;
        Node temp = head;
        Node after = null;
        while(temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}
