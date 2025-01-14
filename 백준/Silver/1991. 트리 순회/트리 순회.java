import java.util.HashMap;
import java.util.Scanner;

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

    public Node makeNode(Node left, String data, Node right) {
        Node node = new Node(data);
        node.left = left;
        node.right = right;
        return node;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + "");
            inOrder(node.right);
        }
    }
    
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + "");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + "");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 수
        sc.nextLine(); // 버퍼 비우기

        // 노드를 저장할 맵
        HashMap<String, Node> map = new HashMap<>();

        // 트리 초기화
        Tree tree = new Tree();

        // 입력 처리
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String parent = input[0];
            String left = input[1];
            String right = input[2];

            // 부모 노드 생성/조회
            map.putIfAbsent(parent, new Node(parent));
            Node parentNode = map.get(parent);

            // 왼쪽 자식 노드 생성
            if (!left.equals(".")) {
                map.putIfAbsent(left, new Node(left));
                parentNode.left = map.get(left);
            }

            // 오른쪽 자식 노드 생성
            if (!right.equals(".")) {
                map.putIfAbsent(right, new Node(right));
                parentNode.right = map.get(right);
            }

            // 루트 설정
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
