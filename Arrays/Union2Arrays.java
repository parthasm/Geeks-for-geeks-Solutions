import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Union2Arrays
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
        int[] ar2 = {7,10};
        int[] ar1 = {};
        printUnion(ar1,ar2);
    }
    //utiility funcitons end
    private static void printUnion(int[] ar1, int[] ar2)
    {
        int i1 = 0, i2 = 0;
        
        while(i1 < ar1.length && i2 < ar2.length)
        {
            if(ar1[i1] == ar2[i2])
            {
                System.out.print(ar1[i1]+" ");  ++i1;   ++i2;
            }
            
            else if(ar1[i1] < ar2[i2])
            {
                System.out.print(ar1[i1]+" ");  ++i1; 
            }
            
            else
            {
                System.out.print(ar2[i2]+" ");  ++i2; 
            }            
        }
        while(i1 < ar1.length)
        {
            System.out.print(ar1[i1]+" ");  ++i1; 
        }   
        
        while(i2 < ar2.length)
        {
            System.out.print(ar2[i2]+" ");  ++i2; 
        }           
        System.out.println();
    }
}

