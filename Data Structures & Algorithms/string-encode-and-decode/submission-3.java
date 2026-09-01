class Solution {
    private static final char SEPARATOR = '#';

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append(SEPARATOR).append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int separatorIndex = str.indexOf(SEPARATOR, i);
            int length = Integer.parseInt(str.substring(i, separatorIndex));

            int start = separatorIndex + 1;
            int end = start + length;

            result.add(str.substring(start, end));  // exactly str substring
            i = end;
        }

        return result;
    }
}