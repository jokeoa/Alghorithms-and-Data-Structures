package org.graph;

import java.util.List;

public abstract class Search {
    protected final WeightedGraph graph;
    protected final Vertex start;
    protected final Vertex end;

    public Search(WeightedGraph graph, String start, String end) {
        this.graph = graph;
        this.start = graph.getVertex(start);
        this.end = graph.getVertex(end);
        
        if (this.start == null || this.end == null) {
            throw new IllegalArgumentException("Start or end vertex not found");
        }
    }

    public abstract List<Vertex> findPath();
} 