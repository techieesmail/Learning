/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.binarytree;

/**
 *
 * @author sanghvir
 */
public class BinarySearchTree {

    static Node start;

    public static void main(String[] args) {
        add(10);
        add(7);
        add(12);
        add(1);
        add(6);
        display(start);
        myRecursiveMethod(10);

    }

    public static int myRecursiveMethod(int aVariable) {
        System.out.println(aVariable);
        aVariable--;
        if (aVariable == 0) {
            return 0;
        }
        int i =  myRecursiveMethod(aVariable);
        System.out.println("The returned value from recurssion is "+i);
        return i;
    }
    private static void add(int i) {
        // Create new node
        Node p = new Node();
        p.data = i;
        if (start == null) {
            start = p;
        } else {
            placeNode(p, start);
        }
    }

    private static void placeNode(Node p, Node target) {

        //Check if p.data is less than target.data
        //If yes than check if target.left is null
        //If yes than attach new node to target.left
        //If no than call placeNode with target as target.left
        if (p.data < target.data) {
            if (target.left == null) {
                target.left = p;
            } else {
                placeNode(p, target.left);
            }
        }
        //If yes than check if target.right is null
        //If yes than attach new node to target.right
        //If no than call placeNode with target as target.right
        if (p.data > target.data) {
            if (target.right == null) {
                target.right = p;
            } else {
                placeNode(p, target.right);
            }
        }

    }

    private static void display(Node target) {
        //Check if the node has left node
        if (target.left != null) {
            //if left node is present call display with left node as target
            display(target.left);
        }

        //Print the data when left is null
        System.out.println(target.data);

        if (target.right != null) {
            //if right node is present call display with right node as target
            display(target.right);
        }

    }
}

class Node {

    public int data;
    public Node left;
    public Node right;

}
//http://www.java-redefined.com/2013/08/data-structure-binary-search-tree.html
//http://www.java-redefined.com/2013/08/java-collections-internal-working.html
