/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.reverselinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sanghvir
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        //program reverses a particular set of values in a list 
        collectionsUtilReverse();
        //reverseAlog();
    }

    private static void collectionsUtilReverse() {
        
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(15);
        ll.add(12);
        ll.add(20);
        ll.add(8);

        System.out.println("Original linked list " + ll);

        List<Integer> sub = ll.subList(0, 2);
        List<Integer> ss = ll.subList(2, ll.size());
        Collections.reverse(sub);

        LinkedList<Integer> newLs = new LinkedList<>();
        newLs.addAll(sub);
        newLs.addAll(ss);
        System.out.println("After reversing entire list " + newLs);
    }

    private static void reverseAlog() {
        class Node {

            int value;
            Node next;

            Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        Node firstNode = null;

        //creating a linked list
        Node previousNode = firstNode = new Node(1, null);
        Node headNode = firstNode;
        for (int i = 2; i <= 10; i++) {
            Node nextNode = new Node(i, null);
            previousNode.next = nextNode;
            previousNode = nextNode;
        }

        //printing all the nodes in Original order
        Node iterNode = headNode.next;
        System.out.println(headNode.value);
        while (iterNode != null) {
            System.out.println(iterNode.value);
            iterNode = iterNode.next;
        }

        //reversing the nodes.
        Node pointerNode = null;
        Node tempNode = null;
        Node revPreviousNode = firstNode;

        Node secNode = pointerNode = firstNode.next;
        if (secNode == null) {
            System.out.println("There is only one node ");
            return;
        }
        firstNode.next = null;

        while (pointerNode != null) {
            tempNode = pointerNode.next;
            if (tempNode == null) {
                headNode = pointerNode;
            }
            pointerNode.next = revPreviousNode;
            revPreviousNode = pointerNode;
            pointerNode = tempNode;
        }
        
        System.out.println("Printing the reverse orders ------------------------ ");
        Node revIterNode = headNode.next;
        System.out.println(headNode.value);
        while (revIterNode != null) {
            System.out.println(revIterNode.value);
            revIterNode = revIterNode.next;
        }
    }

}
