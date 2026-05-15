class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : senate.toCharArray()){
            queue.offer(c);
        }
        int toBan =0;

        while(queue.size() > Math.abs(toBan)){
            if(toBan < 0 && queue.peek() == 'R'){
                toBan++;
                queue.poll();
            }else if(toBan > 0 && queue.peek() == 'D'){
                toBan--;
                queue.poll();
            }else{
                toBan += queue.peek() == 'R'?1:-1;
                queue.offer(queue.poll());
            }
        }
        return toBan > 0 ?"Radiant":"Dire";
        
    }
}