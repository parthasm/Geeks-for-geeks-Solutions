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

public class SubTree
{
    //utiility funcitons begin
    private static Node formBSTBal(int[] ar, int sI, int endI)
    {
        if(sI > endI)
            return null;
        Node n = new Node();
        int mPos = (sI+endI)/2;
        n.data = ar[mPos];
        if(sI == endI)
            return n;
        
        n.left = formBSTBal(ar,sI,mPos-1);
        n.right = formBSTBal(ar,mPos+1,endI);
        return n;
    }
    
    private static Node createTreeBSTBal(int d)
    {
        Node root = new Node();
        root.data = (int)Math.pow(2,d-1);
        int level = 1, loopI;
        
        List<Node> cN = new ArrayList<>();
        List<Node> nN = new ArrayList<>();
        cN.add(root);
        
        while(level < d)
        {
            int dat = (int)Math.pow(2,d-(1+level));
            for(loopI=0;loopI<cN.size();++loopI)
            {
                Node x = cN.get(loopI);     
                
                Node le = new Node();   le.data = dat;
                dat += ((int)Math.pow(2,d-level));   x.left = le;    nN.add(le);
                
                Node ri = new Node();   ri.data = dat;
                dat += ((int)Math.pow(2,d-level));   x.right = ri;   nN.add(ri);
            }
            cN = nN;    nN = new ArrayList<>();     ++level;
        }
        return root;
    }
    
    private static Node getInput(int[][] inp)
    {
        Node root = null;
        int i,j,c;
        
        List<Node> currNodes = null;
        List<Node> nextNodes = new ArrayList<Node>();
        for(i=0;i<inp.length;++i)
        {
            c = 0;
            for( j=0; j<inp[0].length;++j)
            {
                if(inp[i][j] == -2)
                    break;
                Node x = null;
                if(inp[i][j] != -1)
                {
                    x = new Node();
                    x.data = inp[i][j];     nextNodes.add(x);   
                }
                
                if(i==0)
                    root = x;
                else
                {
                    if(j%2==0)
                        currNodes.get(c).left = x;
                    else
                    {   currNodes.get(c).right = x;     ++c;    }
                }
            }
            currNodes = nextNodes;      nextNodes = new ArrayList<Node>();
        }
        return root;
    }
    
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
        /*
        int[][] ar = {{4,-2,-2,-2},
                      {2,6,-2,-2},
                      {1,3,5,7}};
        Node root = getInput(ar);*/
        int[] ar = {};
        Node root1 = createTreeBSTBal(8);
        Node root2 = formBSTBal(ar,0,ar.length-1);
        /*
        System.out.println("Pre order Traversal:");
        printPreOrderTree(root);        
        System.out.println();        
        
        System.out.println("In order Traversal:");
        printInOrderTree(root);        
        System.out.println();
        
        System.out.println("Post order Traversal:");
        printPostOrderTree(root);        
        System.out.println();        
        */
        System.out.println("Level order Traversal:");
        printLevelOrderTree(root2);        
        System.out.println();  
        
        System.out.println(isSubTree(root1,root2,root2));
        
    }
    //utiility funcitons end
    private static boolean isSubTree(Node currN1, Node root2, Node currN2)
    {
        boolean ret = false;
        
        if(currN2 == null)      return true;
        if(currN1 == null)      return false;
        
        if(currN1.data == currN2.data)
            ret = isSubTree(currN1.left, root2, currN2.left) && isSubTree(currN1.right, root2, currN2.right);
        
        if(ret)     return ret;
        
        return isSubTree(currN1.left, root2, root2)  ||  isSubTree(currN1.right, root2, root2);
    }
}