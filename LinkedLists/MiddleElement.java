/*Find the middle of a given linked list
if there are two, print 2nd
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiddleElement
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
        int[] ar2 = {4,5,6};
        int[] ar1 = {90,91,92,93,94,8};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        
        findMid(head1);     findMid(head2);
    }
    //utiility funcitons end
    
    private static void findMid(Node head)
    {
        if(head == null)
            return;
        
        int leng = 0, ctr = 1;
        Node n = head;
        
        while(n!=null)
        {
            n = n.next;     ++leng;     
        }
        n = head;
        
        while(ctr <= leng/2)
        {
            ++ctr;      n = n.next;
        }
        
        System.out.println(n.data);
    }
}

class Node
{
    int data;
    Node next;
}
