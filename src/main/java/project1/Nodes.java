package project1;

import java.util.ArrayList;

public class Nodes {

    private ArrayList<Node> nodeList = new ArrayList<Node>();

    public void addNodeToList(Node node) {
        nodeList.add(node);
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }
}
