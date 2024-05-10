/* PROBLEM DESCRIPTION

Given two linked lists, your task is to complete the function makeUnion(), that returns the union list of two linked lists. This union list should include all the distinct elements only and it should be sorted in ascending order.

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 
1 2 3 4 6 8 9
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output. 
Example 2:

Input:
L1 = 1->5->1->2->2->5
L2 = 4->5->6->7->1
Output: 
1 2 4 5 6 7
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output.
Your Task:
The task is to complete the function makeUnion() which makes the union of the given two lists and returns the head of the new list.

Expected Time Complexity: O((N+M)*Log(N+M))
Expected Auxiliary Space: O(N+M)

Constraints:
1<=N,M<=104

*/

//Solution

/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Set<Integer> set = new TreeSet<>();
	    Node a = head1;
	    Node b = head2;
	    while(a != null) {
	        set.add(a.data);
	        a = a.next;
	    }
	    while(b != null) {
	        set.add(b.data);
	        b = b.next;
	    }
	    List<Integer> list = new ArrayList<Integer>();
	    list.addAll(set);
	    Node out = new Node(-1);
	    Node c = out;
	    for(int i = 0; i < list.size(); i++) {
	        c.next = new Node(list.get(i));
	        c = c.next;
	    }
	    return out.next;
	}
}
