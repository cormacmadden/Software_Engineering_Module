
// Java Program for Lowest Common Ancestor in a Binary Tree 
// A O(n) solution to find LCA of two given values n1 and n2 
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import org.junit.Test; 

  
public class LCA  
{ 
    // A Binary Tree node 
    class Node { 
        int data; 
        Node left, right; 
  
        Node(int value) { 
            data = value; 
            left = right = null; 
        } 
    }

    public static class DagNode {
        int value;
        ArrayList<DagNode> edges;

        DagNode(int value) {
            this.value = value;
            edges = new ArrayList<>();
        }

        DagNode(int value, ArrayList<DagNode> edges) {
            this.value = value;
            this.edges = edges;
        }
    }
  
    Node root; 
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    // Finds the path from root node to given root of the tree. 
    int findLCA(int n1, int n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
        // System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    }

    public DagNode findLCADAG(DagNode head, DagNode nodeOne, DagNode nodeTwo) {
        DagNode LCA = null;
        ArrayList<DagNode> nodes = new ArrayList<>();
        addNodesToListDAG(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()];
        for (int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false;
        for (int i = 0; i < nodes.size(); i++) {
            if (checkIfAncestorDAG(nodes.get(i), nodeOne, nodeTwo)) {
                isAncestor[i] = true;
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (isAncestor[i])
                LCA = nodes.get(i);
        }
        return LCA;
    }

    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private boolean findPath(Node root, int n, List<Integer> path) {
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size() - 1);

        return false;
    }

    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne) {
        if (node == null)
            return false;
        if (node == nodeOne)
            return true;
        else {
            for (int i = 0; i < node.edges.size(); i++) {
                if (checkIfAncestorDAG(node.edges.get(i), nodeOne)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne, DagNode nodeTwo) {
        if (checkIfAncestorDAG(node, nodeOne) && checkIfAncestorDAG(node, nodeTwo))
            return true;
        return false;
    }

    public static void addNodesToListDAG(ArrayList<DagNode> nodes, DagNode root) {
        if (root != null) {
            LinkedList<DagNode> queue = new LinkedList<>();
            queue.add(root);
            DagNode cur;
            while (queue.size() != 0) {
                cur = queue.get(0);
                for (int i = 0; i < cur.edges.size(); i++) {
                    queue.add(cur.edges.get(i));
                }
                nodes.add(cur);
                queue.remove(0);
            }
        }
    }

    public static void main(String[] args) {

    }

    @Test
    public void findLCATest() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        assertEquals(2, tree.findLCA(4, 5));
        assertEquals(1, tree.findLCA(4, 6));
        assertEquals(1, tree.findLCA(3, 4));
        assertEquals(2, tree.findLCA(2, 4));
    }

    @Test
    public void testNullInputsDAG() {
        LCA lca = new LCA();
        assertEquals(lca.findLCADAG(null, null, null), null); // Two null inputs
        LCA.DagNode test = new LCA.DagNode(5);
        assertEquals(lca.findLCADAG(null, null, test), null); // First input null
        assertEquals(lca.findLCADAG(null, test, null), null); // Second input null
    }

    @Test
    public void smallInputDAG() {
        LCA lca = new LCA();
        LCA.DagNode head = new LCA.DagNode(1);
        LCA.DagNode nodeTwo = new LCA.DagNode(2);
        LCA.DagNode nodeThree = new LCA.DagNode(3);
        LCA.DagNode nodeFour = new LCA.DagNode(4);
        head.edges.add(nodeTwo);
        head.edges.add(nodeThree);
        head.edges.add(nodeFour);
        assertEquals(head, lca.findLCADAG(head, nodeTwo, nodeFour));
    }

} 
// Some code is written by Sreenivasulu Rayanki. 
