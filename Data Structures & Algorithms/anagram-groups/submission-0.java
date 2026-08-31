class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str: strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sortedStr = new String(characters);

            if (anagramGroups.containsKey(sortedStr)) {
                anagramGroups.get(sortedStr).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                anagramGroups.put(sortedStr, anagrams);
            }
        }

        return new ArrayList<>(anagramGroups.values());
     }
}