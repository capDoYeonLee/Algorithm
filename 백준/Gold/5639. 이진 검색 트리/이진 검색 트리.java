import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    static Node root;
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        if ((line = br.readLine()) != null) {
            root = new Node(Integer.parseInt(line));
        }

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            insert(root, Integer.parseInt(line));
        }

        postOrder(root);

    }


    public static void insert(Node node, int value) {
//        if (head.value > arr[nextNode]) {
//            Node newHead = new Node(arr[nextNode], null, null);
//            head.left = newHead;
//            makeTree(newHead, nextNode + 1);
//        }
//        if (head.value < arr[nextNode]) {
//            Node newHead = new Node(arr[nextNode], null, null);
//            head.right = newHead;
//            makeTree(newHead, nextNode+1);
//        }

        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else{
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public static void postOrder(Node node) {
        if (node == null) { 
            return;
        }
        postOrder(node.left); 
        postOrder(node.right); 
        System.out.println(node.value);
    }


}