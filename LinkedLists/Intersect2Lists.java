import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Intersect2Lists
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
        int[] ar2 = {1,2,2,3,4,5,6,7,8,8,15};
        int[] ar1 = {2,4,6,6,6,6,8,9,9,10,10,11,12,13,14};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        printLinkedList(head1);
        printLinkedList(head2);
        Node newH = interDupliSortedLL(head1,head2);
        System.out.print("Intersection: ");
        printLinkedList(newH);
    }
    //utiility funcitons end
    private static Node interesect2Lists(Node head1,Node head2)
    {
        Node n1 = head1, n2 = head2;
        Node newH = null, x = null, xP = null;
        int ctr = 0;
        
        while(n1 != null && n2 != null)
        {
            if(n1.data < n2.data)
                n1 = n1.next;
            else if(n1.data > n2.data)
                n2 = n2.next;
            else
            {
                x = new Node();
                x.data = n1.data;   
                n1 = n1.next;       n2 = n2.next;
                if(ctr == 0)
                    newH = x;
                else
                    xP.next = x;
                xP = x;         ++ctr;
            }
        }
        return newH;
    }
    
    private static Node interDupliSortedLL(Node h1, Node h2)
    {
        Node head = null, pN = null, n1 = h1, n2 = h2;   
        boolean firstN = true;
        
        while(n1 != null && n2 != null)
        {
            if(n1.data < n2.data)   n1 = n1.next;
            
            else if(n1.data > n2.data)  n2 = n2.next;
            
            else
            {
                if(firstN)
                {
                    head = new Node();  head.data = n1.data;    pN = head;  firstN = false;
                }
                else
                {
                    Node n = new Node();    n.data = n1.data;   pN.next = n;    pN = n;
                }
                int d = n1.data;
                
                while(n1 != null && n1.data == d)   n1 = n1.next;
                
                while(n2 != null && n2.data == d)   n2 = n2.next;
            }
        }
        return head;
    }
}

class Node
{
    int data;
    Node next;
}
