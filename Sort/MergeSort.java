import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSort
{
    //utiility funcitons begin
    private static void printList(List<Integer> li)
    {
        if(li.size() == 0)  return;
        
        for(int loopI = 0; loopI < li.size(); ++loopI)
            System.out.print(li.get(loopI)+" ");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        //4,7,6,7,2,1,8,1
        List<Integer> li = new ArrayList<>();  // li.add(4);  li.add(7); li.add(6);   li.add(7);
        //li.add(2); li.add(1);   li.add(8); li.add(1);
        
        printList(li);
        mergeSort(li);
        printList(li);
        
    }
    //utiility funcitons end
    private static void mergeSort(List<Integer> li)
    {
        int s = li.size();
        
        if(s < 2)   return;
        
        if( s == 2)
        {
            if(li.get(0) > li.get(1))
            {
                int num = li.get(0);    li.set(0, li.get(1));   li.set(1, num);
            }
            return;
        }
        
        List<Integer> li1 = new ArrayList<>();  List<Integer> li2 = new ArrayList<>();
        int loopI;
        
        for(loopI = 0; loopI < s/2; ++loopI)    li1.add(li.get(loopI));
        for(loopI = s/2; loopI < s; ++loopI)    li2.add(li.get(loopI));
        
        li.clear();     mergeSort(li1);     mergeSort(li2);
        
        int c1 = 0, c2 = 0;
        
        while(c1 < li1.size() && c2 < li2.size())
        {
            if(li1.get(c1) < li2.get(c2))
            {
                li.add(li1.get(c1));    ++c1;
            }
            else if(li1.get(c1) > li2.get(c2))
            {
                li.add(li2.get(c2));    ++c2;
            }
            else
            {
                li.add(li1.get(c1));    li.add(li1.get(c1));    ++c1;       ++c2;
            }
        }
        
        for(loopI = c1; loopI < li1.size(); ++loopI)    li.add(li1.get(loopI));
        
        for(loopI = c2; loopI < li2.size(); ++loopI)    li.add(li2.get(loopI));
    }
}

