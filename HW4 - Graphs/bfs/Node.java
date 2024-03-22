import java.util.*;

public class Node {

    private String name;
    private int value;
    private Set<Node> adjacents;

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
        this.adjacents = new HashSet<>();
    }

    public void connect(Node node) {
        if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
        this.adjacents.add(node);
        node.adjacents.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Node> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(Set<Node> adjacents) {
        this.adjacents = adjacents;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
