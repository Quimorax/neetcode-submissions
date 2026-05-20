class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = createGraph(numCourses, prerequisites);
        List<Integer> orderedCourses = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] currentPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (containsCycle(graph, i, visited, currentPath, orderedCourses)) {
                    return new int[]{};
                };
            }
        }

        int n = orderedCourses.size();
        int[] result = new int[n];
        int index = 0;
        for (int course : orderedCourses) {
            result[index] = course;
            index++;
        }

        return result;
    }

    public boolean containsCycle(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] currentPath, List<Integer> orderedCourses) {
        visited[vertex] = true;
        currentPath[vertex] = true;
        for (int nextV : graph.get(vertex)) {
            if (!visited[nextV]) {
                if (containsCycle(graph, nextV, visited, currentPath, orderedCourses)) {
                    return true;
                };
            } else if (currentPath[nextV]) {
                return true;
            }
        }
        currentPath[vertex] = false;
        orderedCourses.addFirst(vertex);
        return false;
    }

    public List<List<Integer>> createGraph(int amount, int[][] pairs) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] pair : pairs) {
            int from = pair[1];
            int to   = pair[0];
            graph.get(from).add(to);
        }

        return graph;
    }
}
