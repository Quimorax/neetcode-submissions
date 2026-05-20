class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = createGraph(numCourses, prerequisites);

        int n = graph.size();

        boolean[] visited     = new boolean[n];
        boolean[] currentPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (containsCycle(graph, i, visited, currentPath)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCycle(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] currentPath) {
        visited[vertex] = true;
        currentPath[vertex] = true;
        for (int nextV : graph.get(vertex)) {
            if (!visited[nextV]) {
                if (containsCycle(graph, nextV, visited, currentPath)) {
                    return true;
                }
            } else if (currentPath[nextV]) {
                return true;
            }
        }
        currentPath[vertex] = false;
        return false;
    }

    public List<List<Integer>> createGraph(int amount, int[][] pairs) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] pair : pairs) {
            int from = pair[0];
            int to   = pair[1];
            graph.get(from).add(to);
        }

        return graph;
    }
}
