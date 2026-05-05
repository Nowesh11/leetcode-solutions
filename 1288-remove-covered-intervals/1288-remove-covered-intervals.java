class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int remaining = intervals.length;
        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (s2 >= s1 && e2 <= e1) {
                remaining--; // covered
            } else {
                s1 = s2;
                e1 = e2;
            }
        }

        return remaining;
    }
}