class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        int n = deck.length;
        int[] res = new int[n];
        for(int i =0;i<n;i++){
            q.offer(i);
        }
        Arrays.sort(deck);

        for(int card : deck){

            int idx = q.poll();
            res[idx] = card;

            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return res;
        
    }
}