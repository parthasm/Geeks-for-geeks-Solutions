import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DecimalBin
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
        int[] ar = {1,1,1,1,1,1,1};
        Node head = getInput(ar);
        System.out.println(decEquiLL(head));
    }
    //utiility funcitons end
    
    private static long decEquiLL(Node head)
    {
        int lengthLL = 0;
        Node n = head;
        
        while(n!=null)
        {
            n = n.next;     ++lengthLL;
        }
        
        int ctr = 1;    long runSum = 0;    n = head;
        
        while(n != null)
        {
            if(n.data == 1)
                runSum += (long)(Math.pow(2,lengthLL-ctr));
            n = n.next;     ++ctr;
        }
        return runSum;
    }
}

class Node
{
    int data;
    Node next;
}
