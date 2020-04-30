
/**
 * 
 * Client code to test the performance of AVL tree insertion against 
 * BST insertion.
 * 
 * @author Matthew Scaccia
 * @email scaccimj202@potsdam.edu
 * course: CIS303
 * @since 4/29/2020
 * assignment: 5b AVL Tree Balancing
 * @due 5/1/2020
 */

public class AVLClient {
    public static void main (String [] args) {
        
        // Here we construct a BST and then print it for sanity testing
        BSTNode bstroot = new BSTNode(10);
        bstroot = bstroot.insert(8, bstroot);
        bstroot = bstroot.insert(12, bstroot);
        System.out.println(bstroot.height);
        System.out.println(bstroot);

        // Here we construct a AVL Tree and then print it
        AVLNode root = new AVLNode(10);
        root = root.insert(8, root);
        root = root.insert(12, root);
        // shown will be 1 less than the actual height.
        System.out.println(root.height);
        System.out.println(root);
        
        
        //Visual Algo Test: Passed 4/19/20: 9:05PM
        root = new AVLNode(12);
        root = root.insert(2, root);
        root = root.insert(42, root);
        root = root.insert(4, root);
        root = root.insert(14, root);
        root = root.insert(31, root);
        root = root.insert(8, root);
        root = root.insert(3, root);
        root = root.insert(25, root);
        root = root.insert(30, root);
        root = root.insert(26, root);
        root = root.insert(27, root);
        root = root.insert(29, root);
        root = root.insert(67, root);
        root = root.insert(90, root);
        root = root.insert(99, root);
        root = root.insert(88, root);
        root = root.insert(96, root);
        // Please note the the height reported is really the depth
        // of the tree from the root. Until the balancing algorithm
        // is implemented this value will be incorrect. The value
        // shown will be 1 less than the actual height.
        System.out.println("Root height: " + root.height);
        System.out.println(root.toString());
        
    }
}
