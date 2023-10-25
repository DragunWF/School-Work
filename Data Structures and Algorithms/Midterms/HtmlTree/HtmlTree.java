import javax.swing.*;
import javax.swing.tree.*;
import java.util.Collections;
import java.util.ArrayList;

public class HtmlTree extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode root;

    public HtmlTree() {
        // Initiation
        addNodes();
        this.tree = new JTree(root);
        this.add(this.tree);

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
        display("Parent Nodes", Collections.list(root.children()));
        // Parent Nodes
        // Siblings
        // One-level subtrees
        // Nodes per level
        display("Depth", root.getDepth());
        // Degree of each one-level subtree
        display("Breadth-First", Collections.list(root.breadthFirstEnumeration()));
        display("Preorder", Collections.list(root.preorderEnumeration()));
        display("Postorder", Collections.list(root.postorderEnumeration()));
    }

    private void displayParents() {
        
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