/*Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 1 to n, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

Algorithm: Since elements are in the range of indices
Reach indices & make number there negative A[A[i]] *= -1
If a number at an index is already negative => index has been reached for 2nd time
=> print index; set number at index to zero to avoid repititions. 

Count zeros separately in the beginning to catch repeated zeros

Alternate problem which can be solved by the same algorithm:
Numbers range from 0 to n-1 or 1 to n, length of array is n+2 & only 
2 elements are repeated
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RemoveDupliNoExtraSpaceN
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
        int[] ar = {3,0,1,4,1,6,5};
        findDupliArr(ar);
    }
    //utiility funcitons end
    private static void findDupliArr(int[] ar)
    {
        int i,cz=0;
        
        
        for(i=0;i<ar.length;++i)
        {
            if(ar[i] == 0)      ++cz;
        }
        if(cz > 1)      System.out.print("0 ");
        
        for(i=0; i < ar.length; ++i)
        {
            if(ar[Math.abs(ar[i])] > 0 )    ar[Math.abs(ar[i])] *= -1;
            
            else if(ar[Math.abs(ar[i])] < 0 )    
            {
                if(ar[i]!=0)
                    System.out.print(Math.abs(ar[i])+" ");      
                
                ar[Math.abs(ar[i])] = 0;
            }
        }
        System.out.println();
    }
}

