/*OrderOddEven
Given a linked list of integers, segregate odd ones & even ones, even first & maintaining order

1 2 3 4 5 6 ==> 2 4 6 1 3 5

Algorithm: Start from head & traverse to end to find last node(en)

Again, start from head & while not en
    if node even, move on to next node
    else    remove node from list & attach it at end
    
    also do it for en
    
    */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OrderOddEven
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
        while(head!= null)
        {
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int[] ar2 = {1,3,5};
        int[] ar1 = {2,3,5,7,39,6,8,9,11,15};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        printLinkedList(head1);
        printLinkedList(head2);
        Node x1 = ordOddEve(head1);
        Node x2 = ordOddEve(head2);
        printLinkedList(x1);
        printLinkedList(x2);
    }
    //utiility funcitons end
    private static Node ordOddEve(Node head)
    {
        if(head == null || head.next == null)
            return head;
        
        Node n = null, en = head, nP = null, currE =null, nei = null;
        int leng = 0, oddCtr = 0;
        
        while(en.next != null)
        {
            if(en.data%2==1)
                ++oddCtr;
            ++leng;         en = en.next;
        }
        ++leng;
        if(en.data%2==1)
            ++oddCtr;
        
        //if all odd or all even, return immediately because there is nothing to rearrange
        if(oddCtr==0 || oddCtr==leng)
            return head;
        
        n = head;   currE = en;
        
        while(n!=en)
        {
            if(n.data%2==0)
            {
                nP = n;     n = n.next;
            }
            else
            {
                nei = n.next;
                if(nP!=null)
                    nP.next = nei;
                else
                    head = nei;
                
                currE.next = n;     currE = n;  n.next = null;      n = nei;
            }
        }
        
        if(en.data%2==1)
        {
            nei = en.next;
            
            if(nP!=null)
                nP.next = nei;
            else
                head = nei;
            
            currE.next = en;    currE = en;     en.next = null;
        }
        
        return head;
    }
}

class Node
{
    int data;
    Node next;
}

