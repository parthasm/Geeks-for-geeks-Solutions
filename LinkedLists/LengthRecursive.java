import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LengthRecursive
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
        int[] ar2 = {1,1,2,34,56,-7,8};
        int[] ar1 = {9,9,9,9,9,8};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        //printLinkedList(head1);
        //printLinkedList(head2);

        System.out.println(findLenRecur(head1));
        System.out.println(findLenRecur(head2));
    }
    //utiility funcitons end
    
    private static int findLenRecur(Node head)
    {
        if(head == null)
            return 0;
        
        return findLenRecur(head.next)+1;
    }
}

class Node
{
    int data;
    Node next;
}
