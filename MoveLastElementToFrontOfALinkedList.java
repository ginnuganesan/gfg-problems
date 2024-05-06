/* PROBLEM DESCRIPTION

You are given the head of a Linked List. You have to move the last element to the front of the Linked List and return the list.

 

Example 1:

Input:
N = 5
List = {2,5,6,2,1}
Output:
{1,2,5,6,2}
Explanation:
In the given linked list, the last element is 1,
after moving the last element to the front the
linked list will be {1,2,5,6,2}.
 

Example 2:

Input:
N = 1
List = {2}
Output:
{2}
Explanation:
Here 2 is the only element so, the linked list
will remain the same.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function moveToFront() which takes the address of the head of the linked list and returns the modified linked list.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
0 <= Elements of List <= 109
Sum of N over all test cases doesn't exceeds 106

*/

//Solution

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node moveToFront(Node head) {
        // code here
        Node temp = head;
        Node tail = null;
        Node secLast = null;
        while(temp != null) {
            if(temp.next == null) {
                tail = temp;
            }
            if(temp.next != null && temp.next.next == null) {
                secLast = temp;   
            }
            temp = temp.next;
        }
        if(head == tail) {
            return head;
        }
        Node newNode = new Node(tail.data);
        newNode.next = head;
        head = newNode;
        secLast.next = null;
        return head;
    }
}
