package main.java.com.practice.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canComplete(int numOfCourse, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
        }

        boolean[] visited = new boolean[numOfCourse];
        boolean[] pathVisited = new boolean[numOfCourse];
        for (int i = 0; i < numOfCourse; i++) {
            if(!visited[i]) {
               if( !dfs(graph, i, visited, pathVisited)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour: graph.get(node)) {
            if(pathVisited[neighbour]) return false;

            if(!visited[neighbour]) {
                if(!dfs(graph, neighbour, visited, pathVisited)) {
                    return false;
                }
            }
        }
        pathVisited[node] = false;
        return true;
    }

    static void main() {

        // Test Case 1
        int numCourses1 = 4;

        int[][] prerequisites1 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        System.out.println(
                "Test 1: " +
                        canComplete(numCourses1, prerequisites1)
        );


        // Test Case 2 - Cycle
        int numCourses2 = 2;

        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println(
                "Test 2: " +
                        canComplete(numCourses2, prerequisites2)
        );


        // Test Case 3
        int numCourses3 = 1;

        int[][] prerequisites3 = {};

        System.out.println(
                "Test 3: " +
                        canComplete(numCourses3, prerequisites3)
        );
    }
}
