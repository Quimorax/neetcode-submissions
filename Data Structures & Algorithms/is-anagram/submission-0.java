class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSymbols = s.toCharArray();
        char[] tSymbols = t.toCharArray();
        
        Arrays.sort(sSymbols);
        Arrays.sort(tSymbols);
        
        return Arrays.equals(sSymbols, tSymbols);
    }
}
