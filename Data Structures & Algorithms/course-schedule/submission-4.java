

class Solution {
    private boolean isWithCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<LinkedList<Integer>> graph = createGraph(numCourses, prerequisites);
        boolean[] globalVisited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!globalVisited[i]) {
                boolean[] path = new boolean[numCourses];
                dfs(graph, i, path, globalVisited);
                if (isWithCycle) {
                    return false;
                }
            }
        }

        return true;
    }

    private ArrayList<LinkedList<Integer>> createGraph(int amount, int[][] nodesPairs) {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] pair : nodesPairs) {
            int from = pair[0];
            int to   = pair[1];
            graph.get(from).add(to);
        }
        return graph;
    }


    private void dfs(ArrayList<LinkedList<Integer>> graph, int vertexIndex, boolean[] path, boolean[] globalVisited) {
        if (path[vertexIndex]) {
            this.isWithCycle = true;
            return;
        }
        if (globalVisited[vertexIndex] || isWithCycle) return;

        path[vertexIndex] = true;
        globalVisited[vertexIndex] = true;
        
        for (int nextVertex : graph.get(vertexIndex)) {
            dfs(graph, nextVertex, path, globalVisited);
        }
        path[vertexIndex] = false;
    }
}