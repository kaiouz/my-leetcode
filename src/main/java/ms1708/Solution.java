package ms1708;

import java.util.Arrays;

class Solution {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        Person[] persons = new Person[height.length];
        for (int i = 0; i < height.length; i++) {
            persons[i] = new Person(height[i], weight[i]);
        }
        Arrays.sort(persons, (o1, o2) -> {
            if (o1.height == o2.height) {
                return o2.weight - o1.weight;
            } else {
                return o1.height - o2.height;
            }
        });

        int len = 1;
        int[] end = new int[persons.length + 1];
        end[len] = persons[0].weight;

        for (int i = 1; i < persons.length; i++) {
            int insert = Arrays.binarySearch(end, 1, 1 + len, persons[i].weight);
            if (insert < 0) {
                insert = -insert - 1;
            }
            end[insert] = persons[i].weight;
            if (insert > len) {
                len = insert;
            }
        }

        return len;
    }

    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bestSeqAtIndex(new int[]{2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181},
                new int[]{5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594}));
    }
}
