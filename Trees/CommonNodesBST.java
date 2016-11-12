import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node
{
    Node parent;
    int data;
    Node left;
    Node right;
}

public class CommonNodesBST
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
        
        Node x = formBSTBal(ar,sI,mPos-1);
        Node y = formBSTBal(ar,mPos+1,endI);
        
        n.left = x;
        n.right = y;
        
        if(x!=null)
            x.parent = n;
        if(y!=null)
            y.parent = n;
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
        //int[] ar1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};    int[] ar2 = {2,3,4,5,6,7,8,10,11,12,13,14,15,17,19};
        int[] ar1 = {1,4,5}; int[] ar2 = {1,6,7}; 
        Node root1 = formBSTBal(ar1,0,ar1.length-1);   Node root2 = formBSTBal(ar2,0,ar2.length-1);
        
        System.out.println("In order Traversal:");
        printInOrderTree(root1);        
        System.out.println();
        
        System.out.println("Level order Traversal:");
        printLevelOrderTree(root1);        
        System.out.println();        
        
        
        System.out.println("In order Traversal:");
        printInOrderTree(root2);        
        System.out.println();
        
        System.out.println("Level order Traversal:");
        printLevelOrderTree(root2);        
        System.out.println();          
        commonNodesIterInOrd(root1,root2);
    }
    //utiility funcitons end
    /*1st way: Traverse the trees in order and put the Nodes(or the data) in 2 lists, which would be sorted
    then compare the nodes/data in the 2 lists and print the common data points
    */
    private static void inOrdPutList(Node root, List<Integer> arLi)
    {
        if(root  == null)
            return;
        
        inOrdPutList(root.left, arLi);      arLi.add(root.data);        inOrdPutList(root.right,arLi);
    }
    
    private static void commonNodesInOrdPutList(Node root1,Node root2)
    {
        List<Integer> arLi1 = new ArrayList<>();    List<Integer> arLi2 = new ArrayList<>();    
        int ctr1 = 0, ctr2 = 0;
        
        inOrdPutList(root1,arLi1);      inOrdPutList(root2,arLi2);  
        
        while(ctr1 < arLi1.size() && ctr2 < arLi2.size())
        {
            if(arLi1.get(ctr1) > arLi2.get(ctr2))
                ++ctr2;
            else if(arLi1.get(ctr1) < arLi2.get(ctr2))
                ++ctr1;
            else
            {
                System.out.print(arLi1.get(ctr1)+" ");    ++ctr1;     ++ctr2;
            }
        }
        System.out.println();
    }
    
    
    /*2nd way: Using parent pointer
    Find smallest element in both trees and then keep comparing them as you would do for sorted arrays
    Big Hint: with parent pointer, the inorder successor of each node can be found
    Order = O(n*h)
    n could be n1 or n2 or somewhere in between
    h is corresponding
    */
    
    private static void commonNodesInOrdSuc(Node r1, Node r2)
    {
        Node n1 = r1, n2 = r2;
        
        if(n1==null || n2==null)
            return;
        
        while(n1.left != null)
            n1 = n1.left;
            
        while(n2.left!= null)
            n2 = n2.left;
        
        while(n1!=null && n2!=null)
        {
            if(n1.data < n2.data)
                n1 = inOrdSuc(n1);
            
            else if(n1.data > n2.data)
                n2 = inOrdSuc(n2);
            
            else
            {
                System.out.print(n1.data+" ");  n1 = inOrdSuc(n1);  n2 = inOrdSuc(n2);
            }
        }
        
        System.out.println();
    }
    
    private static Node inOrdSuc(Node root)
    {
        Node n = root;
        
        if(n==null)
            return null;
            
        if(n.right!=null)
        {
            n = n.right;
            while(n.left!=null)
                n = n.left;
            return n;
        }
        
        Node par = n.parent;
        
        while(par!=null)
        {
            if(par.data > n.data)
                return par;
            par = par.parent;
        }
        return null;
    }
    
    /*3rd way: Traverse 1st tree in order
    Send the data from each of its node to 2nd tree, looking for the data
    if found, print it 
    Order = O(n1*h2)
    Choose the tree with lower height as the 2nd tree
    */
    
    private static void commonNodesBSTFind(Node r1, Node r2)
    {
        if(r1 == null || r2==null)
            return;
        commonNodesBSTFind(r1.left, r2);
        findNode(r2,r1.data);
        commonNodesBSTFind(r1.right,r2);
    }
    
    private static void findNode(Node root, int dat)
    {
        if(root == null)
            return;
        
        if(root.data > dat)
            findNode(root.left,dat);
        else if(root.data < dat)
            findNode(root.right,dat);
        else
        {
            System.out.print(root.data+" ");
        }
    }
    
    /*4th way:  Iteratively traverse the trees in order using 2 stacks
    If 1 element is lower, move to its in-order successor using the stacks
     This is same as the 2nd method without using parent pointers
     */
     private static void commonNodesIterInOrd(Node root1,Node root2)
     {
         if(root1 == null || root2 == null)  return;
         
         LinkedList<Node> stack1 = new LinkedList<>();
         LinkedList<Node> stack2 = new LinkedList<>();
         
         Node n1 = root1, n2 = root2;
         
         while(true)
         {
             if(n1!=null)
             {
                 stack1.push(n1);   n1 = n1.left;
             }
             if(n2!=null)
             {
                 stack2.push(n2);   n2 = n2.left;
             }             
             
             if(n1 == null && n2 == null)
             {
                 if(stack1.size() == 0 || stack2.size() == 0)
                    break;
                
                n1 = stack1.peekFirst();    n2 = stack2.peekFirst();
                
                if(n1.data < n2.data)
                {
                    stack1.pop();   n1 = n1.right;  n2 = null;
                }
                else if(n1.data > n2.data)
                {
                    stack2.pop();   n2 = n2.right;  n1 = null;
                }
                else
                {
                    stack1.pop();   stack2.pop();   
                    System.out.print(n1.data+" ");
                    n1 = n1.right; n2 = n2.right;
                }
             }
         }
     }
     
}