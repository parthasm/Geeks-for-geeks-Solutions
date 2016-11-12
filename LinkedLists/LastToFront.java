import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LastToFront
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
        int[] ar = {9,7,6,2,8};
        
        Node head = getInput(ar);
        printLinkedList(head);
        Node x = lastToFron(head);
        printLinkedList(x);
    }
    //utiility funcitons end
    
    private static Node lastToFron(Node head)
    {
        if(head == null || head.next == null)
            return head;
        
        Node n = head;
        
        while(n.next.next != null)
            n = n.next;
        
        Node nei = n.next;  nei.next = head;    n.next = null;
        
        return nei;
    }
}

class Node
{
    int data;
    Node next;
}
