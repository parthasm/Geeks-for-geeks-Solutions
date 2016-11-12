/*
Question: Given an array, find consecutive element indices range which
sum to zero
1st approach(Naive) - Space O(1) Time O(N^2): 
Traverse through indices i 
For every i, initialize a running sum variable to Zero
Traverse sub array starting from i till end,
Whenever running sum becomes zero, print i & ending index

2nd Approach(HashMap) - Space O(n)  Time O(N^2) worst case, average slightly worse than O(n):
Initialize running Sum variable to zero
Initialize hashmap. This will hold the running Sum as key and list of indices
where that running sum is found as value
Start traversing array & keep updating running Sum at every point
Insert K,V in map

At the end, traverse map & find indices 
Array = 6,3,-1,-3,4,-2,2,4,6,-12,-7,0
Example:  6:0, 9:[1,4,6], 8:2, 5:3, 7:[5,9], 13:7, 19:8, 0:[10,11] 
Ans: (1+1) to 4
    (1+1) to 6
    (4+1) to 6
    0 to 10
    0 to 11
    (10+1) to 11
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumZeroSubArray
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
        int[] ar = {3,-3,1,-1};
        printSubArrZNaive(ar);
        printSubArrZHashMap(ar);
    }
    //utiility funcitons end
    private static void printSubArrZNaive(int[] ar)
    {
        int n = ar.length, i ,j;
        
        if(n == 0)  return;
        
        for( i = 0; i < n; ++i)
        {
            int varSum = 0;
            for(j = i; j < n; ++j)
            {
                varSum += ar[j];
                if(varSum == 0)
                    System.out.println("Sub array found from index "+i+
                    " to "+j);
            }
        }
    }
    
    private static void printSubArrZHashMap(int[] ar)
    {
        int n = ar.length;
        if( n == 0)     return;
        
        int runSum = 0, i , j;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        
        for( i = 0; i < n; ++i)
        {
            runSum += ar[i];
            list = map.get(runSum);
            
            if(list == null)    list = new ArrayList<>();
            list.add(i);        map.put(runSum,list);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet())
        {
            runSum = entry.getKey();    list = entry.getValue();
            if(runSum == 0)
            {
                for( j = 0; j < list.size(); ++j)
                    System.out.println("Sub array found from index 0 to "+list.get(j));
            }
            
            for( i = 0; i < (list.size() - 1); ++i)
            {
                for( j = i+1; j < list.size(); ++j)
                    System.out.println("Sub array found from index "+(list.get(i)+1)+
                    " to "+list.get(j));
            }
        }
    }
}
