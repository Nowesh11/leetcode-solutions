import java.util.*;

class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int N = 1 << n;

        int[] sessions = new int[N];
        int[] timeUsed = new int[N];

        Arrays.fill(sessions, Integer.MAX_VALUE);

        sessions[0] = 1; // first session
        timeUsed[0] = 0;

        for (int mask = 0; mask < N; mask++) {

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0)
                    continue;

                int nextMask = mask | (1 << i);

                int nextSessions = sessions[mask];
                int nextTime;

                if (timeUsed[mask] + tasks[i] <= sessionTime) {
                    nextTime = timeUsed[mask] + tasks[i];
                } else {
                    nextSessions++;
                    nextTime = tasks[i];
                }

                if (nextSessions < sessions[nextMask] ||
                    (nextSessions == sessions[nextMask] &&
                     nextTime < timeUsed[nextMask])) {

                    sessions[nextMask] = nextSessions;
                    timeUsed[nextMask] = nextTime;
                }
            }
        }

        return sessions[N - 1];
    }
}