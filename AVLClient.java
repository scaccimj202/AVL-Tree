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
        int[] variables = makeVariables();
        for(int i = 0; i < variables.length; i++)
            System.out.println(variables[i]);
        /*
        int variable = 23500;
        System.out.println("Adding 1 - " + variable + " in order,");
        long startTime = System.currentTimeMillis();
        BSTNode bstroot = new BSTNode(1);
        for(int i = 2; i <= variable; i++)
            bstroot = bstroot.insert(i, bstroot);
        //System.out.println(bstroot.toString());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime-startTime;

        long astartTime = System.currentTimeMillis();
        AVLNode root = new AVLNode(1);
        for(int i = 2; i <= variable; i++)
            root = root.insert(i, root);
        //System.out.println(root.toString());
        long aendTime = System.currentTimeMillis();
        long atotalTime = aendTime-astartTime;

        System.out.println("Total time for BST: " + totalTime);
        System.out.println("Total time for AVL: " + atotalTime);
        System.out.println("Time difference(BST-AVL):" + (totalTime-atotalTime));
        */
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
}
