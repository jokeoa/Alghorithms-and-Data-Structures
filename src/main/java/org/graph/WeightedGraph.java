package org.graph;

import java.util.*;

public class WeightedGraph {
    private final Map<String, Vertex> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        vertices.putIfAbsent(label, new Vertex(label));
    }

    public void addEdge(String from, String to, int weight) {
        Vertex fromVertex = vertices.get(from);
        Vertex toVertex = vertices.get(to);
        
        if (fromVertex == null || toVertex == null) {
            throw new IllegalArgumentException("Vertex not found");
        }
        
        fromVertex.addNeighbor(toVertex, weight);
        toVertex.addNeighbor(fromVertex, weight); // For undirected graph
    }

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }

    public Collection<Vertex> getVertices() {
        return vertices.values();
    }
} 