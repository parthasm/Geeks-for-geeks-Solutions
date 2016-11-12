import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlattenLevelWise
{
    //utiility funcitons begin
    private static Node getInputMultiLevelManual()
    {
        Node head = new Node(); head.data = 5;
        Node n1 = new Node();   n1.data = 10;    head.next = n1;
        Node n2 = new Node();   n2.data = 19;    n1.next = n2;
        Node n3 = new Node();   n3.data = 28;    n2.next = n3;
       
        Node n4 = new Node();   n4.data = 7;    head.down = n4;
        Node n5 = new Node();   n5.data = 8;    n4.down = n5;
        Node n6 = new Node();   n6.data = 30;    n5.down = n6;
        
        Node n7 = new Node();   n7.data = 20;    n1.down = n7;
        
        Node n8 = new Node();   n8.data = 22;    n2.down = n8;
        Node n9 = new Node();   n9.data = 50;    n8.down = n9;
        
        Node n10 = new Node();   n10.data = 35;    n3.down = n10;
        Node n11 = new Node();   n11.data = 40;    n10.down = n11;
        Node n12 = new Node();   n12.data = 45;    n11.down = n12;
        
        return head;
    }
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
    
    private static void printMultiLevelLinkedListLevelWise(Node head)
    {
        int loopI;
        List<Node> cN = new ArrayList<>();
        List<Node> nN = new ArrayList<>();
        cN.add(head);
        
        while(cN.size() > 0)
        {
            for(loopI = 0; loopI < cN.size(); ++loopI)
            {
                Node x = cN.get(loopI);
                while(x!=null)
                {
                    System.out.print(x.data+" ");
                    if(x.down!=null)
                        nN.add(x.down);
                    x = x.next;
                }
            }
            cN = nN;    nN = new ArrayList<>();     System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        Node head = getInputMultiLevelManual();
        printMultiLevelLinkedListLevelWise(head);
        flattenLLLevelwise(head);
        printMultiLevelLinkedListLevelWise(head);
    }
    //utiility funcitons end
    private static void flattenLLLevelwise(Node head)
    {
        Node end = head, n = head, dn = null;
        
        while(end.next != null)
            end = end.next;
        
        while(n!=null)
        {
            if(n.down!=null)
            {
                dn = n.down;    n.down = null;  end.next = dn;
                while(dn.next != null)
                    dn = dn.next;
                end = dn;
            }
            n = n.next;
        }
    }
}

class Node
{
    int data;
    Node next;
    Node down;
}
