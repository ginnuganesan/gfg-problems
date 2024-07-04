/* PROBLEM DESCRIPTION

Given a Linked List of size n, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
For more clarity have a look at the printList() function in the driver code.

 

Examples:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.)
Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.)
Note : In the output section of the above examples the -> represents the bottom pointer.

Expected Time Complexity: O(n * n * m)
Expected Auxiliary Space: O(n)

Constraints:
0 <= n <= 50
1 <= mi <= 20
1 <= Element of linked list <= 103

*/

//Solution

/*Node class  used in the program
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    Node flatten(Node root) {
        // Your code here
        if(root == null || root.next == null) {
            return root;
        }
        
        Node mergedHead = flatten(root.next);
        return mergeLists(root, mergedHead);
    }
    
    Node mergeLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node ptr = dummy;
        
        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                ptr.bottom = list1;
                list1 = list1.bottom;
            } else {
                ptr.bottom = list2;
                list2 = list2.bottom;
            }
            ptr.next = null;
            ptr = ptr.bottom;
        }
        
        if(list1 != null) {
            ptr.bottom = list1;
        } else {
            ptr.bottom = list2;
        }
        
        return dummy.bottom;
    }
}
