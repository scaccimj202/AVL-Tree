
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
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.time.Instant;

public class AVLClient {

    public static void main(String[] args) throws FileNotFoundException{

        PrintStream BST = new PrintStream(makeFile("BST.txt"));
        BST.println("Time \t Value of N");
        PrintStream AVL = new PrintStream(makeFile("AVL.txt"));
        AVL.println("Time \t Value of N");

        AVLClient test;
        test = new AVLClient();
        test.runExperiment(BST, AVL);
    }

    //Fields
    private AVLNode avltree;
    private BSTNode btree;
    private int[] variables =
        {100,500,1000,2500,5000,10000,15000, 20000, 23500};

    /**
     * Constructor
     */
    public AVLClient(){
        avltree = new AVLNode(1);
        btree = new BSTNode(1);
    }

    /**
     * Method makes a new file in the 'Experiment Data' sub directory
     * @param fileName_ name of the file
     * @return file to be written to
     */
    private static File makeFile(String fileName_){
        File dir = new File("Experiment Data");
        return new File(dir, fileName_);
    }

    /**
     * Method runs the experiments on both trees and writes the average insertion 
     * time per tree per variable into a respective file
     * @param btree the btree printstream
     * @param avltree the avltree printstream
     */
    public void runExperiment(PrintStream btree, PrintStream avltree){
        for(int i = 0; i < variables.length; i++){
            btree.println(averageBST(variables[i]) + "\t " + variables[i]);
            avltree.println(averageAVL(variables[i]) + "\t " + variables[i]);
            /*System.out.println("Average AVL Insert time for " + variables[i] +
             " elements : " +  averageAVL(variables[i]) + " milliseconds");
            System.out.println("Average BST Insert time for " +  variables[i] +
             " elements : " + averageBST(variables[i]) + " milliseconds");
             */
        }
    }

    /**
     * Method takes the average of the insertion times for a binary
     * search tree of size 'limit'
     * @param limit the number of values being inserted into the bst
     * @return the average time in milliseconds this operation will take
     */
    private long averageBST(int limit){
        long avg = 0;
        for(int i = 0; i < 10; i++)
            avg += timeBST(limit);
        return (avg/10);
    }

    /**
     * Method takes the average of the insertion times for a AVL tree
     * @param limit the number of values being inserted into the avl tree
     * @return the average time in milliseconds this operation will take
     */
    private long averageAVL(int limit){
        long avg = 0;
        for(int i = 0; i < 10; i++)
            avg += timeAVL(limit);
        return (avg/10);
    }

    /**
     * Method logs the time it takes to sequentailly add in 'limit'(N) nodes
     * @param limit the number(n) of nodes to be inserted into the tree
     * @return the time in milliseconds this operation will take
     */
    private long timeAVL(int limit){
        long start = Instant.now().toEpochMilli();
        buildAVL(limit);
        long end = Instant.now().toEpochMilli();
        //System.out.println("Total Time: " + (end-start) + " milliseconds");
        return (end-start);
    }

    /**
     * Method logs the time it takes to sequentailly add in 'limit'(N) nodes
     * @param limit the number(n) of nodes to be inserted into the tree
     * @return the time in milliseconds this operation will take
     */
    private long timeBST(int limit){
        long start = Instant.now().toEpochMilli();
        buildBST(limit);
        long end = Instant.now().toEpochMilli();
        //System.out.println("Total Time: " + (end-start) + " milliseconds");
        return (end-start);
    }

    /**
     * Method sequentailly inserts values into the AVL tree
     * @param limit the amount of values being inserted into the tree
     */
    private void buildAVL(int limit){
        for(int i = 2; i <= limit; i++)
            avltree = avltree.insert(i,avltree);
    }

    /**
     * Method sequentailly inserts values into the BST tree
     * @param limit the amount of values being inserted into the tree
     */
    private void buildBST(int limit){
        for(int i = 2; i <= limit; i++)
            btree = btree.insert(i,btree);
    }

}
