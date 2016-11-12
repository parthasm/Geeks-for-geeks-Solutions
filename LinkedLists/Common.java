import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Add2Nums
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
        int[] ar2 = {7};
        int[] ar1 = {9,9,9,9,9,8};
        
        Node head1 = getInput(ar1);
        Node head2 = getInput(ar2);
        printLinkedList(head1);
        printLinkedList(head2);
        Node x = add2numbers(head1,head2);
        printLinkedList(x);
    }
    //utiility funcitons end

}

class Node
{
    int data;
    Node next;
}
