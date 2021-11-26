package p381;


import java.util.*;

class RandomizedCollection {
    private Map<Integer, Set<Integer>> value2Index;
    private List<Integer> values;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        value2Index = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        values.add(val);
        Set<Integer> indexes = value2Index.computeIfAbsent(val, k -> new HashSet<>());
        indexes.add(values.size() - 1);
        return indexes.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Set<Integer> indexes = value2Index.get(val);
        if (indexes == null || indexes.isEmpty()) {
            return false;
        }

        int removedIndex = indexes.iterator().next();
        indexes.remove(removedIndex);

        int lastIndex = values.size() - 1;
        if (removedIndex != lastIndex) {
            Integer lastValue = values.get(lastIndex);

            Set<Integer> lastIndexes = value2Index.get(lastValue);
            lastIndexes.remove(lastIndex);
            lastIndexes.add(removedIndex);

            values.set(removedIndex, lastValue);
        }

        values.remove(lastIndex);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }


    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(0));
        System.out.println(collection.remove(0));
        System.out.println(collection.insert(-1));
        System.out.println(collection.remove(0));
        System.out.println(collection.getRandom());
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
