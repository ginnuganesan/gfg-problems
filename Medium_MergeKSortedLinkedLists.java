/* PROBLEM DESCRIPTION

Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.
Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
Your Task:
The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 103

*/

//Solution

/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        Node merge = new Node(-1);
        Node out = merge;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            Node temp = arr[i];
            while(temp != null) {
                list.add(temp.data);
                temp = temp.next;
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            out.next = new Node(list.get(i));
            out = out.next;
        }
        return merge.next;
    }
}
