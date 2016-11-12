import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseLL
{
    //utiility funcitons begin
    private static Node getInput(int[] inp)
    {
        Node head = null,n = null,prevNode = null;
        for(int loopI = 0; loopI < inp.length; ++loopI)
        {
            n = new Node();
            if(loopI == 0)
                head = n;    
            else
                prevNode.next = n;
            n.data = inp[loopI];
            prevNode = n;
        }
        return head;
    }
    
    private static void printLinkedList(Node head)
    {
        System.out.println();
        while(head!= null)
        {
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int[] ar = {7,3,2,14,21,9,10};
        Node head = getInput(ar);
        printLinkedList(head);
        head = reverseList(head);
        printLinkedList(head);
    }
    //utiility funcitons end
    
    private static Node reverseList(Node head)
    {
        if(head == null)
            return null;
        Node n = head;
        while(n.next != null)
            n = n.next;
        reverseListDriver(head);
        return n;
    }
    
    private static void reverseListDriver(Node head)
    {
        if(head == null || head.next == null)
            return;
        reverseListDriver(head.next);
        head.next.next = head;
        head.next = null;
    }
}

class Node
{
    int data;
    Node next;
}
