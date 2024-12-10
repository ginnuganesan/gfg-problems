/* PROBLEM DESCRIPTION

Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 105

*/

//Solution

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        List<int[]> out = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        out.add(new int[] {arr[0][0], arr[0][1]});
        
        for (int i = 1; i < arr.length; i++) {
            int[] last = out.get(out.size() - 1);
            int[] curr = arr[i];
            
            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else {
                out.add(curr);
            }
        }
        return out;
    }
}
