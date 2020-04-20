/////////////////////////////////////////////////////////////////////
// AVLClient.java: skeleton client code for AVLNode class
// CIS 303 Analysis of Algorithms
// Fall 2018
// Revised 19 October 2018, L. Grabowski
/////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class AVLClient {
    public static void main (String [] args) throws FileNotFoundException {
        /*
        // Here we construct a BST and then print it for sanity testing
        BSTNode bstroot = new BSTNode(10);
        bstroot = bstroot.insert(8, bstroot);
        bstroot = bstroot.insert(12, bstroot);
        System.out.println(bstroot.height);
        System.out.println(bstroot);
        */
        /* Original Code
        // Here we construct a AVL Tree and then print it
        AVLNode root = new AVLNode(10);
        root = root.insert(8, root);
        root = root.insert(12, root);
        // Please note the the height reported is really the depth
        // of the tree from the root. Until the balancing algorithm
        // is implemented this value will be incorrect. The value
        // shown will be 1 less than the actual height.
        System.out.println(root.height);
        System.out.println(root);
        */
        /*
        // Visual Algo Test: Passed 4/19/20: 9:05PM
        AVLNode root = new AVLNode(12);
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
        */
    }
}
