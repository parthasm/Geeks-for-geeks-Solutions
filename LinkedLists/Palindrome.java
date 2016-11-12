import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Palindrome
{
    //utiility funcitons begin
    private static Node getInput(char[] inp)
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
        char[] ar1 = {'m','a','l','a','a','l','p','m'};
        
        Node head1 = getInput(ar1);
        printLinkedList(head1);
        System.out.println(isPalin(head1));
    }
    //utiility funcitons end
    
    private static boolean isPalin(Node head)
    {
        if(head == null || head.next == null)
            return true;
        Node n1 = head, n2 = null;
        
        int leng = 0, ctr = 1;
        
        while(n1 != null)
        {
            n1 = n1.next;   ++leng;
        }
        
        n1 = head;  
        
        while(ctr <= leng / 2)
        {
            n1 = n1.next;   ++ctr;
        }
        
        if(leng % 2 == 1)
            n1 = n1.next;
        
        n2 = reverseLL(n1);
        
        ctr = 1;    n1 = head;
        
        while( ctr <= leng/2)
        {
            if(n1.data != n2.data)
                return false;
            n1 = n1.next;   n2 = n2.next;   ++ctr;
        }
        return true;
    }
    
    private static Node reverseLL(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node n = head;
        
        while( n.next != null)
            n = n.next;
        
        Node endN = n;
        
        reverseLLactual(head);
        
        return endN;
    }
    
    private static void reverseLLactual(Node head)
    {
        if(head == null || head.next == null)
            return;
        reverseLLactual(head.next);
        head.next.next = head;
        head.next = null;
    }
}

class Node
{
    char data;
    Node next;
}
