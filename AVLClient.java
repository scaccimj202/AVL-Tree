/////////////////////////////////////////////////////////////////////
// AVLClient.java: skeleton client code for AVLNode class
// CIS 303 Analysis of Algorithms
// Fall 2018
// Revised 19 October 2018, L. Grabowski
/////////////////////////////////////////////////////////////////////
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;

public class AVLClient {
    private static boolean debug = false;
    public static void main (String [] args) throws FileNotFoundException {

        PrintStream BST = new PrintStream(makeFile("BST.txt"));
        BST.println("Time \t Value of N");
        PrintStream AVL = new PrintStream(makeFile("AVL.txt"));
        AVL.println("Time \t Value of N");

        int[] variables = makeVariables();
        if(debug == true) viewVariables(variables);

        

    }


    /**
     * Method displays the current variables to be tested
     * @param variables_ the array of variables
     */
    private static void viewVariables(int[] variables_){
        for(int i = 0; i < variables_.length; i++)
            System.out.println(variables_[i]);
    }

    /**
     * Method generates the variables used in the experiment and stores 
     * them in an integer array. 
     * Note: Due to the hardware being tested on 
     * I have chosen to stop the maximum variable size at 23,500 as opposed
     * to the original 25000.
     * @return variables an integer array of values
     */
    private static int[] makeVariables(){
        int[] variables = new int[10];
        variables[0] = 100;
        variables[1] = 500;
        variables[2] = 1000;
        int iterator = 3;
        for(int i = 2500; i < 10000; i+= 2500){
            variables[iterator] = i;
            iterator++;
        }
        for(int i = 10000; i <= 20000; i+= 5000){
            variables[iterator] = i;
            iterator++;
        }
        variables[iterator] = 23500;
        return variables;
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
     * Method tests the worst case scenario for adding to a BST
     * by adding all values(1 - variable) in sequental order.
     * @param variable number of values to be inserted into the tree
     * @return double the time it took to add in (variable) amount of values
     */
    private static double testBST(int variable){
        long startTime = System.currentTimeMillis();
        BSTNode bstroot = new BSTNode(1);;
        for(int i = 1; i <= variable; i++)
            bstroot = bstroot.insert(i, bstroot);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Method tests the worst case scenario for adding to a BST
     * by adding all values(1 - variable) in sequental order.
     * @param variable number of values to be inserted into the tree
     * @return double the time it took to add in (variable) amount of values

     */
    private static double testAVL(int variable){
        long startTime = System.currentTimeMillis();
        AVLNode root = new AVLNode(1);;
        for(int i = 1; i <= variable; i++)
            root = root.insert(i, root);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
