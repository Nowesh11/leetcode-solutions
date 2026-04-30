class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            int n = w.length();

            // generate ALL prefix+suffix combinations
            for(int p = 1; p <= n; p++){
                for(int s = 1; s <= n; s++){
                    String key = w.substring(0, p)  // prefix
                               + "#"                // separator
                               + w.substring(n - s);// suffix
                    map.put(key, i); // overwrite = largest index
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "#" + suff, -1);
    }
}