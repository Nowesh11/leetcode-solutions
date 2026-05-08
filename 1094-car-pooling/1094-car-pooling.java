import java.util.*;

class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        List<List<Integer>> list = new ArrayList<>();

        int n = trips.length;

        int curr = 0;

        for(int i = 0; i < n; i++) {

            // pickup
            list.add(Arrays.asList(trips[i][1], 1, trips[i][0]));

            // drop
            list.add(Arrays.asList(trips[i][2], 0, trips[i][0]));
        }

        list.sort((a,b) -> {

            if(!a.get(0).equals(b.get(0))){
                return a.get(0) - b.get(0);
            }

            return a.get(1) - b.get(1);
        });

        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).get(1) == 1) {
                curr += list.get(i).get(2);
            }
            else {
                curr -= list.get(i).get(2);
            }

            if(curr > capacity) return false;
        }

        return true;
    }
}