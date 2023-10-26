import javax.swing.*;
import javax.swing.tree.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class HtmlTree extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode root;
    private ArrayList<TreeNode> parents = new ArrayList<>();
    private ArrayList<String> siblings = new ArrayList<>();
    private ArrayList<String> oneLevelSubTrees = new ArrayList<>();
    private ArrayList<ArrayList<String>> nodesPerLevel = new ArrayList<>();
    private HashMap<String, Integer> degrees = new HashMap<>();

    public HtmlTree() {
        // Initiation
        addNodes();
        this.tree = new JTree(root);
        this.add(this.tree);

        for (int i = 0, n = root.getDepth() + 1; i < n; i++) {
            nodesPerLevel.add(new ArrayList<>());
        }
        traverse(root);

        // Window Methods
        this.setTitle("HTML Tree");
        this.setSize(300, 300);
        this.setVisible(true);
    }

    private void addNodes() {
        // Parent Nodes
        root = node("html");
        DefaultMutableTreeNode head = node("head");
        DefaultMutableTreeNode body = node("body");
        DefaultMutableTreeNode ul = node("ul");
        DefaultMutableTreeNode h2 = node("h2");
        // End of Parent Nodes

        // Add Operations
        root.add(head);
        root.add(body);
        head.add(node("meta"));
        head.add(node("title"));
        body.add(ul);
        body.add(node("h1"));
        body.add(h2);
        for (int i = 0; i < 2; i++)
            ul.add(node("li"));
        h2.add(node("a"));
        // End of Add Operations
    }

    public void enumerateTree() {
        display("Root", root.getRoot());
        display("Parent Nodes", parents);
        display("Siblings", siblings);

        System.out.println("One Level Subtrees");
        for (int i = 0, n = oneLevelSubTrees.size(); i < n; i++) {
            System.out.printf("- %s\n", oneLevelSubTrees.get(i));
        }

        System.out.println("Nodes Per Level");
        for (int i = 0, n = root.getDepth() + 1; i < n; i++) {
            display("Level " + i, nodesPerLevel.get(i));
        }

        display("Depth", root.getDepth());

        System.out.println("Degree Of Each One-Level Subtree");
        for (String key : degrees.keySet()) {
            display("Subtree " + key, degrees.get(key));
        }

        display("Breadth-First", Collections.list(root.breadthFirstEnumeration()));
        display("Preorder", Collections.list(root.preorderEnumeration()));
        display("Postorder", Collections.list(root.postorderEnumeration()));
    }

    private void traverse(DefaultMutableTreeNode node) {
        nodesPerLevel.get(node.getLevel()).add(node.toString());
        if (!node.isLeaf()) {
            ArrayList<String> currentSiblings = new ArrayList<>();
            String[] oneLevelSubtree = new String[node.getChildCount() + 1]; // +1 because it includes the parent
            oneLevelSubtree[0] = node.toString() + "-";
            parents.add(node);
            degrees.put(node.toString(), node.getChildCount());

            for (int i = 0, n = node.getChildCount(); i < n; i++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
                if (n > 1) {
                    currentSiblings.add(child.toString());
                }
                oneLevelSubtree[i + 1] = child.toString();
                if (i + 2 != n + 1) { // i + 2 and n + 1 to match with oneLevelSubtree array
                    oneLevelSubtree[i + 1] += "/";
                }
                traverse((DefaultMutableTreeNode) child);
            }

            oneLevelSubTrees.add(String.join("", oneLevelSubtree));
            siblings.add(String.join("-", currentSiblings));
        }
    }

    private static void display(String title, Object value) {
        System.out.printf("%s: %s\n", title, value);
    }

    private static DefaultMutableTreeNode node(String name) {
        return new DefaultMutableTreeNode(name);
    }

    public static void main(String[] args) {
        new HtmlTree().enumerateTree();
    }
}