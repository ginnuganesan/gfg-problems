/* PROBLEM DESCRIPTION

Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL       
Your Task:
You don't need to read input or print anything. The task is to complete the function intersectPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.

 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

 

Constraints:
Length of Both linkedList before intersection(if any) is greater than 0.
2 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000

*/

//Solution

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
        if(head1 == null || head2 == null) {
            return -1;
        }
        
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            
            if(temp1 == temp2) {
                if(temp1 == null) {
                    return -1;
                }
                return temp1.data;
            }
            
            if(temp1 == null) {
                temp1 = head2;
            }
            if(temp2 == null) {
                temp2 = head1;
            }
        }
        return temp1.data;
	}
}
