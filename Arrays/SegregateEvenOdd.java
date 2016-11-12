/*
Question: Given an array with even & odd numbers, put all the even numbers at the beginning &
put all the odd numbers at the end (Order does not matter)
Same implementation question: Given a binary array with 0 & 1, put all the 0s at the beginning &
put all the 1s at the end
Algorithm: Maintain 2 indices - left starting at 0 and right starting at array end
Swap elements if they are on the wrong side & move indices
Else move the index(ices) for elements on the correct side
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SegregateEvenOdd
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
        int[] ar = {1,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,1,1,1,1,0,0};
        segreEvenOdd(ar);
        printAr(ar);
    }
    //utiility funcitons end
    private static void segreEvenOdd(int[] ar)
    {
        int left = 0, right = ar.length - 1;
        
        while(left < right)
        {
            if(ar[left] %2 == 1 && ar[right]%2 == 0)
            {
                ar[left] += ar[right];
                ar[right] = ar[left] - ar[right];
                ar[left] -= ar[right];
                ++left;     --right;
            }
            else
            {
                if(ar[left]%2==0)   ++left;
                if(ar[right]%2==1)  --right;
            }
        }
    }
}

