/*
 * link to the problem:
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 * O(n) solution
 * without recursion
 */


import java.util.*;
import java.io.*;

public class Keyboard_A
{
    public static void main(String[] akash)throws IOException
    {
        System.out.println("Key stokes allowed:");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int N=Integer.parseInt(s);
        int[] mem=new int[]{4,5,6}; // last 3 results
        int[] add=new int[]{1,1,3};//what amount was added to get last 3 results individually
        int ans;
        int extramem=3;
        int m=3;
        if(N<=6)
            System.out.println(N);
        else
        {
            for(int i=7;i<=N;i++)
            {
                int max=0;
                int mem_add=0;
                m=3;
                for(int j=0;j<3;j++)
                {
                    if((mem[j]+((m--)*add[j]))>= max)
                    {
                        max=(mem[j]+((m+1)*add[j]));
                        mem_add=add[j];                        
                    }
                }
                if((2*mem[0])>=max)
                {
                    mem_add=mem[0];
                    max=2*mem[0];
                }
                if(((2*extramem)+extramem)>=max)
                {
                    mem_add=extramem;
                    max=(2*extramem)+extramem;
                }
                extramem=mem[0];
                arrayUpdate(mem,max);
                arrayUpdate(add,mem_add);
                System.out.println(max);
            }
        }
    }
    static void arrayUpdate(int[] mem,int newMem)
    {
        mem[0]=mem[1];
        mem[1]=mem[2];
        mem[2]=newMem;
    }
}