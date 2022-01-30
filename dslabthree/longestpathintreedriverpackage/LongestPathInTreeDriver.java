package com.greatlearning.dslabthree.longestpathintreedriverpackage;

import java.util.ArrayList;

public class LongestPathInTreeDriver {
    //Node Data And Behaviour
    static class Node {
        Node leftNode;
        Node rightNode;
        int data;
    };
    //Method to create a new Binary Node
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.leftNode = null;
        temp.rightNode = null;
        return temp;
    }

    // Method to get longest path
    public static ArrayList<Integer> longestPath(Node root) {
        // checkpoint: If root is null then return empty
        if (root == null) {
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        // Recursively calling for root.right subtree
        ArrayList<Integer> rightList = longestPath(root.rightNode);
        // Recursively calling for root.left subtree
        ArrayList<Integer> leftList = longestPath(root.leftNode);
        //comparing the size for left and right traversals, and based on comparision, add new root data on larger subtree
        if (rightList.size() < leftList.size()) {
            leftList.add(root.data);
        } else {
            rightList.add(root.data);
        }
        // Return back list with bigger size, depending on left and right traversals, for appended root appropriately
        return (leftList.size() > rightList.size() ? leftList : rightList);
    }

    // Main Driver Program
    public static void main(String[] args) {
        //creating tree from problem statement
        Node root = newNode(100);
        root.leftNode = newNode(20);
        root.rightNode = newNode(130);
        root.leftNode.leftNode = newNode(10);
        root.leftNode.rightNode = newNode(50);
        root.rightNode.leftNode = newNode(110);
        root.rightNode.rightNode = newNode(140);
        root.leftNode.leftNode.leftNode = newNode(5);
        //Result Array List That Will Process With Recursion
        ArrayList<Integer> resultList = longestPath(root);
        int size = resultList.size();
        System.out.print("Longest path ");
        System.out.print(resultList.get(size - 1));
        //Printing In Reverse Order So That Path Tracing Starts From Root Towards Leaf Node
        for (int i = size - 2; i >= 0; i--) {
            System.out.print(" -> " + resultList.get(i));
        }
    }
}
