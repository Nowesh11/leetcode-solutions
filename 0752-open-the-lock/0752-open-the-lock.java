class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (dead.contains("0000")) return -1;

        queue.offer("0000");
        visited.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return level;
                }

                for (int j = 0; j < 4; j++) {

                    char c = current.charAt(j);

                    String s1 = current.substring(0, j) +
                            (c == '9' ? '0' : (char)(c + 1)) +
                            current.substring(j + 1);

                    String s2 = current.substring(0, j) +
                            (c == '0' ? '9' : (char)(c - 1)) +
                            current.substring(j + 1);

                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        visited.add(s1);
                        queue.offer(s1);
                    }

                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        visited.add(s2);
                        queue.offer(s2);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}