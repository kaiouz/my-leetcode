package p911;

import java.util.Arrays;

class TopVotedCandidate {

    private int[] candidates;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        candidates = new int[persons.length];
        this.times = times;

        int[] votes = new int[persons.length + 1];
        int maxPerson = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (++votes[persons[i]] >= votes[maxPerson]) {
                maxPerson = persons[i];
            }
            candidates[i] = maxPerson;
        }
    }

    public int q(int t) {
        int index = Arrays.binarySearch(times, t);
        if (index < 0) {
            index = -index - 1;
            index--;
        }
        return candidates[index];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
