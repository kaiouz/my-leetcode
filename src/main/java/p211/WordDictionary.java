package p211;

class WordDictionary {

    Word root = new Word();

    public WordDictionary() {
    }

    public void addWord(String word) {
        root.add(word, 0);
    }


    public boolean search(String word) {
        return root.search(word, 0);
    }

    static class Word {
        boolean end;
        Word[] children = new Word[26];

        public void add(String word, int i) {
            if (i == word.length()) {
                end = true;
                return;
            }

            int index = word.charAt(i) - 'a';
            if (children[index] == null) {
                children[index] = new Word();
            }
            children[index].add(word, i + 1);
        }

        public boolean search(String pattern, int i) {
            if (i == pattern.length() && end) {
                return true;
            }

            char c = pattern.charAt(i);
            if (c == '.') {
                for (Word w : children) {
                    if (w != null && w.search(pattern, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                return children[index] != null && children[index].search(pattern, i + 1);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
