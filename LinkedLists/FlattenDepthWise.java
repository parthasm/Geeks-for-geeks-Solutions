import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlattenDepthWise
{
    //utiility funcitons begin
    private static Node getInputMultiLevelManual()
    {
        Node n1 = new Node();  n1.data = 1;
        Node head = n1;
        Node n2 = new Node();    n2.data = 2;   n1.next = n2;
        Node n3 = new Node();    n3.data = 3;   n2.next = n3;
        Node n4 = new Node();    n4.data = 4;   n3.next = n4;
        
        Node n7 = new Node();    n7.data = 7;   n2.down = n7;
        Node n8 = new Node();    n8.data = 8;   n7.next = n8;
        Node n10 = new Node();   n10.data = 10; n8.next = n10;
        Node n12 = new Node();   n12.data = 12; n10.next = n12;
        
        Node n9 = new Node();   n9.data = 9;    n7.down = n9;
        Node n14 = new Node();  n14.data = 14; n9.down = n14;
        Node n15 = new Node();  n15.data = 15; n14.down = n15;
        Node n23 = new Node(); n23.data = 23;  n15.next = n23;
        Node n24 = new Node(); n24.data = 24;   n23.down = n24;
        
        Node n16 = new Node(); n16.data = 16; n8.down = n16;
        Node n17 = new Node(); n17.data = 17;   n16.down = n17;
        Node n18 = new Node(); n18.data = 18;   n17.next = n18;
        Node n19 = new Node(); n19.data = 19;   n18.next = n19;
        Node n20 = new Node(); n20.data = 20;   n19.next = n20;
        Node n21 = new Node(); n21.data = 21;   n20.down = n21;
        
        Node n11 = new Node(); n11.data = 11;   n10.down = n11;        
        
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
        flattenLLDepthwise(head);
        printMultiLevelLinkedListLevelWise(head);
    }
    //utiility funcitons end
    private static void flattenLLDepthwise(Node head)
    {
        Node n = head;
        while( n!= null)
        {
            Node nxt = n.next;
            if(n.down != null)
            {
                Node dow = n.down;  n.down = null;  
                n.next = dow;  
                while(dow.next != null)
                    dow = dow.next;
                dow.next = nxt;
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
