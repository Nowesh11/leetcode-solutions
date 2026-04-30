class WordFilter {
    Map<String,Integer> map = new HashMap<>();
    

    public WordFilter(String[] words) {
        
        int n = words.length;

        for(int i =0;i<n;i++){
            int m =words[i].length();

            for(int p=1;p<=m;p++){
                for(int s=1;s<=m;s++){

                    String key =words[i].substring(0,p)+ "#" +words[i].substring(m-s);
                    map.put(key,i);
                }
            }
        }

        

        
    }
    
    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "#" + suff,-1);
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */