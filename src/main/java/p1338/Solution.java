package p1338;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

  public int minSetSize(int[] arr) {

    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : arr) {
      freq.compute(n, (k, v) -> v == null ? 1 : v + 1);
    }

    List<Integer> times = freq.values().stream()
            .sorted((o1, o2) -> Integer.compare(o2, o1))
            .collect(Collectors.toList());

    int ans = 0;
    int sum = 0;

    for (int time : times) {
      sum += time;
      ans++;
      if (sum * 2 >= arr.length) {
        break;
      }
    }

    return ans;
  }


}
