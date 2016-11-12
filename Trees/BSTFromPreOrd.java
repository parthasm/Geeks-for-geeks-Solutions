import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node
{
    //Node parent;
    int data;
    Node left;
    Node right;
}

public class BSTFromPreOrd
{
    //utiility funcitons begin

    private static void printInOrderTree(Node root)
    {
        if(root!=null)
        {
            printInOrderTree(root.left);    
            System.out.print(root.data+" ");
            printInOrderTree(root.right);
        }
    }
    
    private static void printPreOrderTree(Node root)
    {
        if(root!=null)
        {
            System.out.print(root.data+" ");        
            printPreOrderTree(root.left);
            printPreOrderTree(root.right);            
        }
    }        
    
    private static void printLevelOrderTree(Node root)
    {
        int loopI,loopJ;
        if(root == null)
            return;
        List<Node> currNodes = new ArrayList<Node>();
        List<Node> nextNodes = new ArrayList<Node>();
        currNodes.add(root);
        while(currNodes.size()!=0)
        {
            for(loopI = 0; loopI < currNodes.size(); ++loopI)
            {
                Node x = currNodes.get(loopI);
                if(x.left != null)
                    nextNodes.add(x.left);
                if(x.right!=null)
                    nextNodes.add(x.right);
                    
                System.out.print(x.data+" ");                    
            }
            currNodes = nextNodes;      nextNodes = new ArrayList<Node>();
        }
    }            
    
    public static void main(String[] args)
    {

        int[] ar = {8,4,6,5,7,12,10,9,11,14,13,15};    
        Node root = formBSTPreOrd(ar,0,ar.length-1);
        System.out.println("Pre order Traversal:");
        printPreOrderTree(root);        
        System.out.println();        
        
        System.out.println("In order Traversal:");
        printInOrderTree(root);        
        System.out.println();
        
        System.out.println("Level order Traversal:");
        printLevelOrderTree(root);        
        System.out.println();        
        
    }
    //utiility funcitons end
    private static Node formBSTPreOrd(int[] ar, int low, int high)   
    {
        if(low > high)
            return null;
        
        Node root = new Node();     root.data = ar[low];
        if(low == high)
            return root;
        int loopI;
        
        for(loopI = low+1; loopI<= high && ar[loopI] < ar[low]; ++loopI);
        
        root.left = formBSTPreOrd(ar,low+1,loopI-1);
        root.right = formBSTPreOrd(ar,loopI,high);
        
        return root;
    }
}