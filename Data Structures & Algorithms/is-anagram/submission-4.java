class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] lettersCount = new char[26];  // 0 means first letter, and so on
        
        for (int i = 0; i < s.length(); i++) {
            lettersCount[s.charAt(i) - 'a']++;
            lettersCount[t.charAt(i) - 'a']--;
        }
        
        for (int count : lettersCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }

}

