package org.graph;

import java.util.*;

public class DijkstraSearch extends Search {
    public DijkstraSearch(WeightedGraph graph, String start, String end) {
        super(graph, start, end);
    }

    @Override
    public List<Vertex> findPath() {
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> previousVertex = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(
            Comparator.comparingInt(distances::get)
        );


        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(previousVertex);
            }

            for (Map.Entry<Vertex, Integer> neighbor : current.getNeighbors().entrySet()) {
                Vertex next = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDistance = distances.get(current) + weight;

                if (newDistance < distances.get(next)) {
                    distances.put(next, newDistance);
                    previousVertex.put(next, current);
                    queue.remove(next);
                    queue.offer(next);
                }
            }
        }

        return Collections.emptyList();
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