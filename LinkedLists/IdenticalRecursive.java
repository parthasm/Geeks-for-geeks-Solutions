import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IdenticalRecursive
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
        int[] ar2 = {7,2,9};
        int[] ar1 = {7,8,9};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        printLinkedList(head1);
        printLinkedList(head2);
        
        System.out.println(isIdentical(head1,head2));
    }
    //utiility funcitons end
    private static boolean isIdentical(Node n1,Node n2)
    {
        if(n1==null && n2==null)
            return true;
        
        if(n1==null)
            return false;
            
        if(n2==null)
            return false;            
        
        if(n1.data!=n2.data)
            return false;  
        
        return isIdentical(n1.next,n2.next);
    }
}

class Node
{
    int data;
    Node next;
}
