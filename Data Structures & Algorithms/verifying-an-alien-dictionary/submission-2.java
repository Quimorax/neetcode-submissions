class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        final int alphabetLength = 26;
        int[] alphabetIndexes = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alphabetIndexes[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isPairSorted(words[i], words[i + 1], alphabetIndexes)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPairSorted(String w1, String w2, int[] order) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            int index1 = order[w1.charAt(i) - 'a'];
            int index2 = order[w2.charAt(i) - 'a'];

            if (index1 > index2) {
                return false;
            }
            if (index1 < index2) {
                return true;
            }
        }

        if (w1.length() > w2.length()) {
            return false;
        }
        return true;
    }
}