class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean found1 =false;
        boolean found2 = false;
        boolean found3 = false;

        for(int[] t : triplets){

            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
                continue;
            }

            if(t[0] == target[0])found1 = true;
            if(t[1] == target[1])found2 = true;
            if(t[2] == target[2])found3 = true;
        }
        return found1 && found2 && found3;
        
    }
}