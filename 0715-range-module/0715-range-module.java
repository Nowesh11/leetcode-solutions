class RangeModule {
    List<Interval> intervals;

    public class Interval{
        int left;
        int right;

        public Interval(int left ,int right){
            this.left = left;
            this.right = right;

        }
    }

    public RangeModule() {
         intervals = new ArrayList<>();
        
    }
    
    public void addRange(int left, int right) {
        int n = intervals.size();
        List<Interval> res = new ArrayList<>();
        int i =0;
        for(;i<n;i++){
            Interval interval = intervals.get(i);

            if(left > interval.right){
                res.add(interval);
            }else if(right < interval.left){
                res.add(new Interval(left,right));
                break;
            }else{
                left = Math.min(left,interval.left);
                right = Math.max(right,interval.right);
            }
        }
        if(i==n){
            res.add(new Interval(left,right));
        }
        while(i<n){
            res.add(intervals.get(i++));
        }
        intervals = res;
        
    }
    
    public boolean queryRange(int left, int right) {

        int low =0;
        int high = intervals.size()-1;

        while(low<=high){
            int mid = (low + high)/2;
            Interval interval = intervals.get(mid);

            if(interval.left<=left && right<=interval.right)return true;
            else if(interval.left > right){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
        
    }
    
    public void removeRange(int left, int right) {
        int n = intervals.size();
        List<Interval> res = new ArrayList<>();

        for(int i =0;i<n;i++){
            Interval interval = intervals.get(i);

            if(left >= interval.right){
                res.add(interval);
            }else if(right <= interval.left){
                res.add(interval);
            }else{
                if(interval.left<left){
                    res.add(new Interval(interval.left,left));
                }
                if(interval.right>right){
                    res.add(new Interval(right,interval.right));
                }
            }
        }
        intervals=res;
        
    }
}

