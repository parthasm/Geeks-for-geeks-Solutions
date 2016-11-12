import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DoubleLinkedList
{
    private Node head;
    
    
    private void insert(int data, int k)
    {
        if( k > 1 && this.head == null)    
        {
            System.out.println("Error..."); return;
        }
        Node newN = new Node();     newN.data = data;
        if(this.head == null)
        {
            this.head = newN;   return;
        }
        if(k == 1)
        {
            newN.next = this.head;  this.head.prev = newN;
            this.head = newN;   return;
        }
        int ctr = 1;    Node n = this.head;
        
        while(ctr < k - 1)
        {
            n = n.next;     ++ctr;
        }
        Node nxtN = n.next;     n.next = newN;  newN.prev = n;
        if(nxtN != null)
        {
            newN.next = nxtN;   nxtN.prev = newN;       
        }
        return;
    }
    
    private void print()
    {
        if(this.head == null)   return;
        Node n = this.head;
        while( n != null)
        {
            System.out.print(n.data+" ");   n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        DoubleLinkedList dlObj = new DoubleLinkedList();
        dlObj.insert(1,1);  dlObj.insert(2,2);  dlObj.insert(3,3);  
        dlObj.insert(0,2);
        dlObj.print();
    }
    
    
}

class Node
{
    int data;   Node prev;  Node next;
}