class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int i =0;i<stones.length;i++){
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int next = first - second;

            if(next != 0)maxHeap.offer(next);
        }
        return maxHeap.size() == 0?0:maxHeap.peek();
        
    }
}