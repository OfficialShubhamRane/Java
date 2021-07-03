package AlgoMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

class SubtreeWithMaxAvg {

    public static class Node<T> {

        public T val;
        public List<Node<T>> children;
        public Node(T val) {
            this(val, new ArrayList<>());
        }
        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    private float maxAvg = -Float.MAX_VALUE;
    private Node<Integer> maxRoot;
    // -> (sum, num_nodes)

    private Map.Entry<Integer, Integer> dfs(Node<Integer> node) {

        int s = node.val;
        int n = 1;

        for (Node<Integer> c : node.children) {
            Map.Entry<Integer, Integer> e = dfs(c);
            s += e.getKey();
            n += e.getValue();
        }
        float avg = (float)s / n;
        if (avg > maxAvg) {
            maxAvg = avg;
            maxRoot = node;
        }
        return Map.entry(s, n);
    }

    public static int subtreeMaxAvg(Node<Integer> root) {

        // WRITE YOUR BRILLIANT CODE HERE

        SubtreeWithMaxAvg sol = new SubtreeWithMaxAvg();
        sol.dfs(root);
        return sol.maxRoot.val;
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();

        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static void main(String[] args) {
        //Driver Code
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
        scanner.close();
        int res = subtreeMaxAvg(root);
        System.out.println(res);
    }
}