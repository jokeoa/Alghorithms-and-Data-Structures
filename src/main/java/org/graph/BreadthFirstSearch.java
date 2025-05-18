package org.graph;

import java.util.*;

public class BreadthFirstSearch extends Search {
    public BreadthFirstSearch(WeightedGraph graph, String start, String end) {
        super(graph, start, end);
    }

    @Override
    public List<Vertex> findPath() {
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Vertex> previousVertex = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(previousVertex);
            }

            for (Vertex neighbor : current.getNeighbors().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previousVertex.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    private List<Vertex> reconstructPath(Map<Vertex, Vertex> previousVertex) {
        List<Vertex> path = new ArrayList<>();
        Vertex current = end;

        while (current != null) {
            path.add(0, current);
            current = previousVertex.get(current);
        }

        return path;
    }
} 