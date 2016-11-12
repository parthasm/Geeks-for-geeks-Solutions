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

public class BSTFromPostOrd
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
    
    private static void printPostOrderTree(Node root)
    {
        if(root!=null)
        {
            printPostOrderTree(root.left);
            printPostOrderTree(root.right);
            System.out.print(root.data+" ");
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

        int[] ar = {3,1,9,7,5};    
        Node root = formBSTPostOrd(ar,0,ar.length-1);

        System.out.println("In order Traversal:");
        printInOrderTree(root);        
        System.out.println();

        System.out.println("Post order Traversal:");
        printPostOrderTree(root);        
        System.out.println();        
        
        System.out.println("Level order Traversal:");
        printLevelOrderTree(root);        
        System.out.println();        
        
    }
    //utiility funcitons end
    private static Node formBSTPostOrd(int[] ar, int low, int high)   
    {
        if(low > high)
            return null;
        
        Node root = new Node();     root.data = ar[high];
        if(low == high)
            return root;
        int loopI;
        
        for(loopI = high-1; loopI >= low && ar[loopI] > ar[high]; --loopI);
        
        root.left = formBSTPostOrd(ar,low,loopI);
        root.right = formBSTPostOrd(ar,loopI+1,high-1);
        
        return root;
    }
}