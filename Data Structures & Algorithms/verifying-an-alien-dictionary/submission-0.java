class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (!isPairSorted(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPairSorted(String w1, String w2, String order) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            int index1 = order.indexOf(w1.charAt(i));
            int index2 = order.indexOf(w2.charAt(i));

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