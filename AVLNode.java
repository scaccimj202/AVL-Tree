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
    //Note to self - toString is done in pre-order traversal
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
/**
 * @author Matthew Scaccia
 * course: CIS303
 * @since 4/19/20
 * assignment: 5b AVL Tree Balancing
 */

    /**
     * Method balances a tree post insertion: takes a node, updates the height
     * of the node, checks the balance factor of the subtree, and depending
     * on the value of the balance factor, will follow through with one of four
     * rotation cases for a balance.
     * @param rt node where the balance factor will be tested
     * @return the new root of this tree/subtree or the unchanged root
     */
    private AVLNode balance (AVLNode rt) {
       if (rt == null)
            return rt;
        updateHeight(rt);

        /**
         * Recall balance factor is calculated as: 
         * height of left subtree - hight of right subtree
         */
        int balanceFactor = getBalanceFactor(rt);
        /**
        * If we have a negative number we have a right leaning tree
        */
        if(balanceFactor < -1){
            if(height(rt.right.right) > height(rt.right.left)){
                rt = rotateLeft(rt);
            }else{
                rt = doubleRotateRightLeft(rt);
            }
        }       
        /**
        * If we have a positive number we have a left leaning tree
        */
        else if( balanceFactor > 1){
            if(height(rt.left.left) > height(rt.left.right)){
                rt = rotateRight(rt);
            }else{
                rt = doubleRotateLeftRight(rt);
            }
        }
        return rt;
    }
    
    /**
     * Method for rotating right case, juggles pointers to rebalance right
     * @param rt AVL node
     * @return temp new root after single rotation of this rt left
     */
    private AVLNode rotateRight(AVLNode rt) {
        AVLNode temp = rt.left;
        rt.left = temp.right;
        temp.right = rt;
        updateHeight(temp.right);
        updateHeight(temp);
        return temp;
    }
    /**
     * Method for rotating left case, juggles pointers to rebalance left
     * @param rt AVL node
     * @return temp new root after single rotation of this rt left
     */
    private AVLNode rotateLeft(AVLNode rt) {
        AVLNode temp = rt.right;
        rt.right = temp.left;
        temp.left = rt;
        updateHeight(temp.left);
        updateHeight(temp);
        return temp;
    }
    
    /**
     * Method for doing a Left Right rotation, does a left
     * rotation on the child node followed by a right rotation
     * on the grandparent node
     * @param rt the grandparent node we are rotating about
     * @return rt the node we have done a rotation about
     */
    private AVLNode doubleRotateLeftRight(AVLNode rt) {
        rt.left = rotateLeft(rt.left);
        return rotateRight(rt);

    }
    
    /**
     * Method for doing a Right Left rotation, does a right
     * rotation on the child node followed by a left rotation
     * on the grandparent node
     * @param rt the grandparent node we are rotating about
     * @return rt the node we have done a rotation about
     */    
    private AVLNode doubleRotateRightLeft(AVLNode rt) {
        rt.right = rotateRight(rt.right);
        return rotateLeft(rt);
    }

    /**
     * Method: sets the height of the current node to the
     * maximum value of it's two subtrees 
     * @param root the node we are currently traversing
     */
    private void updateHeight(AVLNode root){
        root.height = 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Method takes the root node and caluclates the balance factor for the 
     * left and right subtrees, returning either 0 if root is null or the 
     * differnce of left - right subtree height.
     * @param root the node whos subtrees we will be checking 
     * @return either 0 or the differnce of the left and right subtree heights
     */
    private int getBalanceFactor(AVLNode root){
        if(root == null) return 0;
        else return (height(root.left) - height(root.right));
    }
}
