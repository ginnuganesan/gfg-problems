/* PROBLEM DESCRIPTION

Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.

Input: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 

Input: mat = [[23, 28], [23, 28]]
Output:

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)

Constraints:
1 <= mat.size() <=15
1 <= mat[i][j] <=104

*/

//Solution

/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        int n = arr.length;
        Node[] a = new Node[n];
        int k = 0;
        Node mainhead = new Node(-1);
        for(int i = 0; i < n; i++) {
            Node head = new Node(-1);
            Node ptr = head;
            for(int j = 0; j < n; j++) {
                ptr.right = new Node(arr[i][j]);
                ptr = ptr.right;
                k++;
            }
            a[i] = head.right;
            if(i == 0) {
                mainhead.right = head.right;
            }
        }
        for(int i = 0; i < a.length - 1; i++) {
            Node row1 = a[i];
            Node row2 = a[i+1];
            while(row1 != null && row2 != null) {
                row1.down = row2;
                row1 = row1.right;
                row2 = row2.right;
            }
        }
        return mainhead.right;
    }
}
