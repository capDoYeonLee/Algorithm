import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data.equals(".") ? null : data;
    }
}

class Tree {
    Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, Node> nodeMap = new HashMap<>();
        Tree tree = new Tree();
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String root = input[0];
            String left = input[1];
            String right = input[2];
            
            
            nodeMap.putIfAbsent(root, new Node(root));
            Node parentNode = nodeMap.get(root);
            
            if (!left.equals(".")) {
                nodeMap.putIfAbsent(left, new Node(left));
                parentNode.left = nodeMap.get(left);
            }
            
            if (!right.equals(".")) {
                nodeMap.putIfAbsent(right, new Node(right));
                parentNode.right = nodeMap.get(right);
            }
            
            if (i == 0) {
                tree.setRoot(parentNode);
            }
        }

        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());

    }
}
