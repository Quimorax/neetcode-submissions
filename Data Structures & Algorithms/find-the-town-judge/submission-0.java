class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> judgeCandidates = new HashSet<>();


        ArrayList<LinkedList<Integer>> graph = createGraph(trust, n);

        int trustsNobodyAmount = 0;
        Set<Integer> allTrustTo = new HashSet<>(graph.getFirst());

        for (int i = 1; i < n; i++) {
            LinkedList<Integer> trustTo = graph.get(i);
            if (trustTo.isEmpty()) {
                trustsNobodyAmount++;
                if (trustsNobodyAmount > 1) {
                    return -1;
                }
            }

            if (!trustTo.isEmpty()) {
                allTrustTo.retainAll(trustTo);
            }
            if (allTrustTo.isEmpty()) {
                return -1;
            }
        }
        if (allTrustTo.size() != 1) {
            return -1;
        }
        return allTrustTo.iterator().next() + 1;
    }

    public ArrayList<LinkedList<Integer>> createGraph(int[][] nodePairs, int nodesAmount) {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodesAmount; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] pair : nodePairs) {
            int from = pair[0] - 1;
            int to   = pair[1] - 1;

            graph.get(from).add(to);
        }
        return graph;
    }
}