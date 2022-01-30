package com.greatlearning.dslabthree.longestpathintreedriverpackage;

import java.util.ArrayList;

public class LongestPathInTreeDriver {
    //Node Data And Behaviour
    static class Node
    {
        Node left;
        Node right;
        int data;
    };

    //Method to create a new Binary Node
    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Method to get longest path
    public static ArrayList<Integer> longestPath(Node root)
    {
        // checkpont: If root is null then return empty
        if(root == null)
        {
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        // Recursively calling for root.right subtree
        ArrayList<Integer> rightList = longestPath(root.right);
        // Recursively calling for root.left subtree
        ArrayList<Integer> leftList = longestPath(root.left);
        //comparing the size for left and right traversals, and based on comparision, add new root data on larger subtree
        if(rightList.size() < leftList.size())
        {
            leftList.add(root.data);
        }
        else
        {
            rightList.add(root.data);
        }
        // Return back list with bigger size, depending on left and right traversals, for appended root appropriately
        return (leftList.size() > rightList.size() ? leftList :rightList);
    }

    // Main Driver Program
    public static void main(String[] args)
    {
        Node root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.right.left = newNode(110);
        root.right.right = newNode(140);
        root.left.left.left = newNode(5);

        ArrayList<Integer> output = longestPath(root);
        int n = output.size();
        System.out.print("Longest path ");
        System.out.print(output.get(n - 1));
        //Printing In Reverse Order So That Path Tracing Starts From Root Towards Leaf Node
        for(int i = n - 2; i >= 0; i--)
        {
            System.out.print(" -> " + output.get(i));
        }
    }
}
