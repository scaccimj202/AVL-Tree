# AVL-Tree
Algorithms assignemnt(5b) detailing the worst case performace of an AVL(balance + rotations of our own implementation) against a BST. 

Problem: For this assignment we're to modify the AVLNode.java source code by implementing the balancing algorithm for an AVL tree. We're to add the four rotation methods, the cases that will trigger them, and any helper methods necessary. From here we're to test the tree independently for validity(source code for this will be left in the in the main directory for this program). After this we're to time test this implementation against the given binary search tree(this client code will be in the Experiments Data sub directory). Our lab report should detail our hypothesis(in this case log n growth for AVL and n^2 growth for BST) and show the resulting graphs produced from the data.

Testing Criteria: For this assignment testing was done in two major phases and there split into two files in two directories.
*AVL Testing: Here the tree was stress tested by forcing rotations and comparing the results against Visualgo and state diagrams. All rotation cases we're tested for correctness.
*Perfomance Testing: This was ultimatly done by averaging the insertion times per variable. Given the variable set: {100,500,1000,2500,5000,10000,15000, 20000, 23500} tests are to be performed on insertion times for each amount on each tree. I tested this by timing the insertion of (variable) values into each tree. I repeated this ten times taking the average of those times. Therfore, for each varaible, I inserted (variable) amount of integers sequentially ten times and took the average of those times. I then wrote this data to respective files for each tree. 

Execution Instructions: compile and run AVLClient.java
*Using the AVLClient.java in the main directory the work is done automatically and will perform a variey of tree insertions that test the rotations within the balance method.
*Using the AVLClient.java in the Experiments Data sub directory you will first want to move it out into the main directory. Then simply compile and run the AVLClient.java file and the program will run automatically. You will then find the results within Experiments Data sub directory.

