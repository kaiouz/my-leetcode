package p1333;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(restaurant -> {
                   return restaurant[3] <= maxPrice
                           && restaurant[4] < maxDistance
                           && (veganFriendly == 0 || restaurant[2] == 1);
                })
                .sorted((a, b) -> {
                   int rating = Integer.compare(b[1], a[1]);
                   if (rating == 0) {
                       return Integer.compare(b[0], a[0]);
                   }
                   return rating;
                })
                .map(restaurant -> restaurant[0])
                .collect(Collectors.toList());
    }


}
