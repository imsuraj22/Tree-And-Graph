import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     class Tuple {
        TreeNode node;
        int line;
        int level;
        public Tuple(TreeNode node, int line, int level) {
            this.node=node;
            this.line=line;
            this.level=level;
        }
    }
public class VerticalOrderTraversal {
    static public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int line = tuple.line;
            int level = tuple.level;


            if (!map.containsKey(line)) {
                map.put(line, new TreeMap < > ());
            }
            if (!map.get(line).containsKey(level)) {
                map.get(line).put(level, new PriorityQueue < > ());
            }
            map.get(line).get(level).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, line - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, line + 1, level + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList < > ();
        list = verticalTraversal(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }
}
