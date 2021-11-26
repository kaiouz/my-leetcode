package p1286;

class CombinationIterator {

    private int[] p;

    private String characters;

    private boolean init;

    private char[] sb;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        sb = new char[combinationLength];
        p = new int[combinationLength];
    }

    public String next() {
        if (!init) {
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
                sb[i] = characters.charAt(i);
            }
            init = true;
        } else {
            for (int i = p.length - 1; i >=0; i--) {
                if (p[i] < characters.length() - p.length + i) {
                    int next = p[i] + 1;
                    for (int j = i; j < p.length; j++) {
                        p[j] = next++;
                        sb[j] = characters.charAt(p[j]);
                    }
                    break;
                }
            }
        }

        return new String(sb);
    }

    public boolean hasNext() {
        return !init || p[0] < characters.length() - p.length;
    }


    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
