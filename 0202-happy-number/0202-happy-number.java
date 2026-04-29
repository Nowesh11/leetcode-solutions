class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast =n;

        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);

        return slow==1;
        
    }
    public int square(int v) {
        int sum = 0;

         while (v > 0) {
            int digit = v % 10;   // STEP 1: extract digit
            sum += digit * digit; // STEP 2: use digit
            v = v / 10;           // STEP 3: reduce number
    }

    return sum;
}   
        }
