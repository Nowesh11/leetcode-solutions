class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {

        int k = nums.size();

        // [value, listIndex, elementIndex]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int currentMax = Integer.MIN_VALUE;

        // STEP 1: add first element from each list
        for (int i = 0; i < k; i++) {

            int val = nums.get(i).get(0);

            pq.offer(new int[]{val, i, 0});

            currentMax = Math.max(currentMax, val);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        // STEP 2: process heap
        while (pq.size() == k) {

            int[] curr = pq.poll();

            int minVal = curr[0];
            int listIndex = curr[1];
            int elementIndex = curr[2];

            // update best range
            if (currentMax - minVal < end - start) {
                start = minVal;
                end = currentMax;
            }

            // move forward in same list
            if (elementIndex + 1 <
                nums.get(listIndex).size()) {

                int nextVal =
                    nums.get(listIndex).get(elementIndex + 1);

                pq.offer(new int[]{
                    nextVal,
                    listIndex,
                    elementIndex + 1
                });

                currentMax = Math.max(currentMax, nextVal);
            }
        }

        return new int[]{start, end};
    }
}