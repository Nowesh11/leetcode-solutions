import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long) arr[a[0]] * arr[b[1]],
                (long) arr[b[0]] * arr[a[1]]
            )
        );

        // push arr[0]/arr[j]
        for (int j = 1; j < n; j++) {
            pq.offer(new int[]{0, j});
        }

        while (--k > 0) {
            int[] cur = pq.poll();

            int i = cur[0];
            int j = cur[1];

            if (i + 1 < j) {
                pq.offer(new int[]{i + 1, j});
            }
        }

        int[] ans = pq.poll();

        return new int[]{
            arr[ans[0]],
            arr[ans[1]]
        };
    }
}
