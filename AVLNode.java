/////////////////////////////////////////////////////////////////////
// AVLNode.java: starter code for AVLNode class
// CIS 303 Analysis of Algorithms
// Fall 2018
// Revised 19 October 2018, L. Grabowski
/////////////////////////////////////////////////////////////////////
// You will implement only the balance method and the 4 rotation methods
// found near the end of this file. DO NOT change the rest of the class.
/////////////////////////////////////////////////////////////////////
public class AVLNode {
    
    // Fields
    int data;
    AVLNode left;
    AVLNode right;
    int height;
    
    // Constructors
    AVLNode (int data) {
        this(data, null, null);
    }
    
    AVLNode (int data, AVLNode left, AVLNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
    
    // Param: int value - to insert
    //        AVLNode rt - node that roots this subtree
    // Returns: new root of this subtree
    public AVLNode insert (int value, AVLNode rt) {
        if (rt == null)
            return new AVLNode(value, null, null);
        if (value < rt.data)
            rt.left = insert(value, rt.left);
        else if (value > rt.data)
            rt.right = insert(value, rt.right);
        // else this is a duplicate, do nothing
        return balance(rt);
    }
    
    // Returns : String representation of tree root at this node
    public String toString() {
        return toString(this);
    }
    
    // Param: AVLNode rt
    // Returns : String representation of tree root at rt
    //Note to self - toString is done in pre-order traversal format
    private String toString(AVLNode rt) {
        if (rt == null)
            return "";
        if (rt.left == null && rt.right == null)
            return rt.data + " ";
        String result = rt.data + " ";
        if (rt.left != null)
            result += toString(rt.left);
        if (rt.right != null)
            result += toString(rt.right);
        return result;
        
    }
    
    // Param: AVLNode n
    // Returns: height of largest subtree, -1 if n is null
    private int height (AVLNode n) {
        return n == null ? -1 : n.height;
    }
    
/////////////////////////////////////////////////////////////////////
// Implement the next 5 methods
/////////////////////////////////////////////////////////////////////
    
    // Param: AVLNode - rt - node to check for balance
    // Returns: new root of this subtree after balancing
    private AVLNode balance (AVLNode rt) {
       if (rt == null)
            return rt;
        // Write the code here to handle the different cases that
        // will use the 4 rotations
        return rt;
    }
    
    // Param: AVLNode rt
    // Returns: new root after single rotation of this rt right
    private AVLNode rotateRight(AVLNode rt) {
        // stub
        return rt;
    }
    
    // Param: AVLNode rt
    // Returns: new root after single rotation of this rt left
    private AVLNode rotateLeft(AVLNode rt) {
        // stub
        return rt;
    }
    
    private AVLNode doubleRotateLeftRight(AVLNode rt) {
        // stub
        return rt;
    }
    
    private AVLNode doubleRotateRightLeft(AVLNode rt) {
        // stub
        return rt;
    }
}
