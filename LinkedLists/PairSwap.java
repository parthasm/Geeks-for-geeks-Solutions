import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PairSwap
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
        int[] ar1 = {1};
        int[] ar2 = {};
        
        Node h1 = getInput(ar1);
        Node h2 = getInput(ar2);
        printLinkedList(h1);
        printLinkedList(h2);
        pairSwapVal(h1);     pairSwapVal(h2);
        printLinkedList(h1);
        printLinkedList(h2);
    }
    //utiility funcitons end
    private static Node pairSwapNodes(Node head)
    {
        if(head == null || head.next == null)   return head;
        int ctr = 0;
        
        Node n1 = head, n2 = head.next, nei = null, nP = null;
        
        while(n2!=null)
        {
            nei = n2.next;  n1.next = nei;  n2.next = n1;
            
            if(ctr == 0 )   head = n2;  
            else    nP.next = n2;
            
            nP = n1;    n1 = nei;  
            
            if(n1!= null)   n2 = n1.next;
            else    n2 = null;
            
            ++ctr;
        }
        return head;
    }
    
    private static void pairSwapVal(Node head)
    {
        if(head == null || head.next == null)   return ;
        
        int swapVar = -1;
        Node n1 = head, n2 = n1.next;
        
        while(n2!=null)
        {
            swapVar = n1.data; n1.data = n2.data;   n2.data = swapVar;
            n1 = n2.next;
            
            if(n1!=null)    n2 = n1.next;
            else    n2 = null;
        }
        
    }
}

class Node
{
    int data;
    Node next;
}
