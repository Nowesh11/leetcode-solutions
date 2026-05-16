class Solution {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    Map<Integer, Integer> delayed = new HashMap<>();

    int leftSize = 0, rightSize = 0;
    int k;

    public double[] medianSlidingWindow(int[] nums, int k) {

        this.k = k;
        int n = nums.length;

        double[] res = new double[n - k + 1];

        int start = 0;

        for (int end = 0; end < n; end++) {

            add(nums[end]);

            if (end - start + 1 > k) {
                remove(nums[start]);
                start++;
            }

            if (end - start + 1 == k) {
                res[end - k + 1] = findMedian();
            }
        }

        return res;
    }

    // ---------------- ADD ----------------
    public void add(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
            leftSize++;
        } else {
            right.offer(num);
            rightSize++;
        }

        balance();
    }

    // ---------------- REMOVE ----------------
    public void remove(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= left.peek()) {
            leftSize--;
            if (num == left.peek()) prune(left);
        } else {
            rightSize--;
            if (num == right.peek()) prune(right);
        }

        balance();
    }

    // ---------------- BALANCE ----------------
    public void balance() {

        if (leftSize > rightSize + 1) {
            right.offer(left.poll());
            leftSize--;
            rightSize++;
            prune(left);
        } 
        else if (rightSize > leftSize) {
            left.offer(right.poll());
            rightSize--;
            leftSize++;
            prune(right);
        }
    }

    // ---------------- PRUNE ----------------
    public void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {

            int num = heap.poll();

            delayed.put(num, delayed.get(num) - 1);

            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }
        }
    }

    // ---------------- MEDIAN ----------------
    public double findMedian() {

        prune(left);
        prune(right);

        if (leftSize > rightSize) {
            return left.peek();
        }

        return ((long) left.peek() + (long) right.peek()) / 2.0;
    }
}