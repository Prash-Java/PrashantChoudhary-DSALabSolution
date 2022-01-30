package com.greatlearning.dslabthree.longestpathinbinarytreedriverpackageusingbst;

import java.util.Scanner;

public class LongestPathForBinaryTreeDriver {
    // BST node data and behaviour
    static class Node {
        int key, height;
        LongestPathForBinaryTreeDriver.Node left, right;
    }

    // creation of new node we can proceed here
    static Node newNode(int data) {
        Node temp = new Node();

        temp.key = data;
        temp.height = 0;

        temp.left = null;
        temp.right = null;

        return temp;
    }

    //height for generic node can be known and returned here
    public int getHeight(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    //this will be used to compare lengths, which subtree side is max
    public int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node insert(LongestPathForBinaryTreeDriver.Node node, int key) {

        // create node from scratch that will be inserted with their keys and build tree
        if (node == null) {
            return (newNode(key));
        }

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else { // Duplicate keys we not allow in problem
            System.out.println("Cannot insert Duplicate values");
            return node;
        }
        node.height = 1 + findMax(getHeight(node.left), getHeight(node.right));

        return node;
    }

    //For Tree Traversal, recursively it will traverse in inorder like A+B until it reaches respective Leaf Nodes
    public void inorder(Node root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.print(root.key + "{" + root.height + "} ");
            inorder(root.right);
        }
    }

    //For Printing the longest path from Root to Leaf Node
    public void printLongestPath(Node root) {
        System.out.print(root.key+", ");
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            if (root.right.height > root.left.height) {
                printLongestPath(root.right);
            } else if (root.left.height >= root.right.height) {
                printLongestPath(root.left);
            }
        } else if (root.right != null) {
            printLongestPath(root.right);
        } else {
            printLongestPath(root.left);
        }
    }

    //Driver Code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int value, num;

        LongestPathForBinaryTreeDriver longestPathOfTree = new LongestPathForBinaryTreeDriver();
        System.out.println("Enter no of values: ");
        num = sc.nextInt();

        Node root = null;
        Node result = null;

        for (int i = 0; i < num; i++) {
            System.out.println("\nInserted value at " + (i + 1) + ": ");
            value = sc.nextInt();
            if (root == null) {
                root = longestPathOfTree.insert(root, value);
            } else {
                result = longestPathOfTree.insert(root, value);
                if (result.key == value)
                    i -= 1;
            }
            System.out.println("Inorder of Binary Tree\n");
            longestPathOfTree.inorder(root);
            System.out.println();
        }
        System.out.println("\nNodes of Longest Branch");
        longestPathOfTree.printLongestPath(root);
        sc.close();
    }
}
