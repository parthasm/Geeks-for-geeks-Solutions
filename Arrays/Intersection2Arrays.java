import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Intersection2Arrays
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
        int[] ar2 = {};
        int[] ar1 = {7,8,9,10};
        printIntersection(ar1,ar2);
    }
    //utiility funcitons end
    private static void printIntersection(int[] ar1, int[] ar2)
    {
        int i1 = 0, i2 = 0;
        
        if(ar1.length == 0)     return;
        
        if(ar2.length == 0)     return;
        
        while(i1 < ar1.length && i2 < ar2.length)
        {
            if(ar1[i1] == ar2[i2])
            {
                System.out.print(ar1[i1]+" ");  ++i1;   ++i2;
            }
            
            else if(ar1[i1] < ar2[i2])
                ++i1;
            
            else
                ++i2;    
        }
        System.out.println();
    }
}

