package org.newoffshore.ui.model;

public class NodeData {
    public final NodeType type;
    public final String label;
    public final String country;

    public NodeData(NodeType type, String label, String country) {
        this.type = type;
        this.label = label;
        this.country = country;
    }

    @Override public String toString() { return label; }
}