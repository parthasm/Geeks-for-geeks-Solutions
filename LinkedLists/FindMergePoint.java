import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindMergePoint
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
    
    // head1 is head of main linked list; head2 is head of stub linked list
    //move to end of stub linked list and join it in "pos" of main linked list
    private static void mergeLists(int pos, Node head1,Node head2)
    {
        if(head1 == null || head2 == null)
        {
            System.out.println("Error! Linked list(s) are empty. Can't proceed further. ");
            return;
        }
        int ctr = 1;
        Node n1 = head1, n2 = head2;
        while(ctr < pos)
        {
            n1 = n1.next;   ++ctr;
        }
        
        while(n2.next!=null)
            n2 = n2.next;
        
        n2.next = n1;
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
        int[] ar1 = {1,2};
        int[] ar2 = {3};
        int mergePos = 2;
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        System.out.println("Linked Lists before merging:");
        printLinkedList(head1);
        printLinkedList(head2);
        
        mergeLists(mergePos,head1,head2);
        System.out.println("Linked Lists after merging:");
        printLinkedList(head1);
        printLinkedList(head2);
        findMergePt(head1,head2);
    }
    //utiility funcitons end
    private static void findMergePt(Node hA,Node hB)
    {
        Node nA = hA, nB = hB;
        if(hA == null || hB == null)
            return;
        
        while(nA!=nB)
        {
            if(nA.next!=null)
                nA = nA.next;
            else
                nA = hB;
            
            if(nB.next!=null)
                nB = nB.next;
            else
                nB = hA;
        }
        System.out.println(nA.data);
    }
}

class Node
{
    int data;
    Node next;
}
