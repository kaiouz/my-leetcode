package p677;

class MapSum {

    private Item root;

    public MapSum() {
        root = new Item();
    }

    public void insert(String key, int val) {
        root.insert(key, val, 0);
    }

    public int sum(String prefix) {
        return root.sum(prefix, 0);
    }

    static class Item {
        Item[] children = new Item[26];
        int sum;
        int end;

        public int insert(String key, int val, int index) {
            sum += val;

            if (index == key.length()) {
                if (end > 0) {
                    sum -= end;
                    int prevEnd = end;
                    end = val;
                    return prevEnd;
                } else {
                    end = val;
                    return 0;
                }
            }

            int i = key.charAt(index) - 'a';
            if (children[i] == null) {
                children[i] = new Item();
            }
            int ret = children[i].insert(key, val, index+1);
            sum -= ret;

            return ret;
        }

        public int sum(String prefix, int index) {
            if (index == prefix.length()) {
                return sum;
            }

            int i = prefix.charAt(index) - 'a';
            if (children[i] == null) {
                return 0;
            }

            return children[i].sum(prefix, index+1);
        }
    }


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
