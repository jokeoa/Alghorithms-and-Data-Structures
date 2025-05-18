package org.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private final String label;
    private final Map<Vertex, Integer> neighbors;

    public Vertex(String label) {
        this.label = label;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(Vertex neighbor, int weight) {
        neighbors.put(neighbor, weight);
    }

    public Map<Vertex, Integer> getNeighbors() {
        return neighbors;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
} 