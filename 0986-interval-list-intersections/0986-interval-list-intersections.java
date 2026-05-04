class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {

            int s1 = firstList[i][0], e1 = firstList[i][1];
            int s2 = secondList[j][0], e2 = secondList[j][1];

            int start = Math.max(s1, s2);
            int end = Math.min(e1, e2);

            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // IMPORTANT: move pointer of smaller END
            if (e1 < e2) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}