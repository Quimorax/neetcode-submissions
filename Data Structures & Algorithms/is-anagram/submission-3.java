class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> symbolsCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            symbolsCount.put(charS, symbolsCount.getOrDefault(charS, 0) + 1);
            symbolsCount.put(charT, symbolsCount.getOrDefault(charT, 0) - 1);
        }

        for (int count : symbolsCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
