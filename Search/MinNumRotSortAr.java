import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinNumRotSortAr
{
    //utiility funcitons begin
    
    private static void printAr(int[] ar)
    {
        for(int loopI = 0; loopI < ar.length; ++loopI)
            System.out.print(ar[loopI]+" ");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int[] ar1 = {8,9,10,11,12,13,14,4,5,6,7};
        int[] ar2 = {7,6};
        
        System.out.println(findMinRotSorAr(ar1,0,ar1.length-1));
        System.out.println(findMinRotSorAr(ar2,0,ar2.length-1));
        
    }
    //utiility funcitons end
    private static int findMinRotSorAr(int[] ar,int low, int high)
    {
        if(low>high)
            return -1;
        
        if(low == high)
            return ar[low];
    
        //no rotation
        if(ar[low] < ar[high])
            return ar[low];

        if(high-low == 1)        
            return ar[high];
        
        else if(high-low==2)
            return Math.min(ar[high-1],ar[high]);
            
        int mid = (low+high)/2;
        
        if(ar[low] > ar[mid])
            return findMinRotSorAr(ar,low,mid);
        
        else if(ar[mid+1] > ar[high])
            return findMinRotSorAr(ar,mid+1,high);
        
        return Math.min(ar[mid+1],ar[low]);
    }
}

