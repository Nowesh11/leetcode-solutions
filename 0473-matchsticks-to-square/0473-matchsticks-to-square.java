class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int stick : matchsticks)
            sum += stick;

        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        Arrays.sort(matchsticks);

        reverse(matchsticks);

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks,
                              int index,
                              int[] sides,
                              int target) {


        if (index == matchsticks.length) {

            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[index];


        for (int i = 0; i < 4; i++) {

            if (sides[i] + stick > target)
                continue;


            sides[i] += stick;


            if (backtrack(matchsticks, index + 1, sides, target))
                return true;


            sides[i] -= stick;
        }

        return false;
    }

    private void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}