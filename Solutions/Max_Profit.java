/*
 * link to the problem:
 * http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * O(n) solution.   Dynamic approach would take O(n^2) time.
 * 
 * 
 */


import java.util.*;
import java.io.*;

public class Max_Profit
{
    public static void main(String[] Akash)throws IOException
    {
        
        /*  Basic Idea
         * Get the highest possible profit and the subaaray between those 2 values which provide
         * the max profit. run a reverse loop on that subarray and get the maximum possible value
         * from there. store in temp 1.
         * Now remove these 2 values and rerun the 1st loop normally, store sum in temp 2.
         * return whichever is higher.
         */
        System.out.println("Number of variations: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String variations=br.readLine();
        String var[]=variations.split(",");
        int len=var.length;
        int[] price=new int[len];
        for(int i=0;i<len;i++)
        {
            price[i]=Integer.parseInt(var[i]);
        }
        
        int max_profit=0;
        int min=price[0];
        int max_profit_low_index=0;
        int max_profit_high_index=0;
        int min_index=0;
        /*
         * For finding maximum profit
         */
        for(int i=1;i<len;i++)
        {
            if(price[i]<min)
            {
                min=price[i];
                min_index=i;
            }
            else
            {
                if((price[i]-min)>max_profit)
                {
                    max_profit=price[i]-min;
                    max_profit_low_index=min_index;
                    max_profit_high_index=i;
                }
            }
        }
        int temp_inside=0;
        
        
        /*
         * check inside the subset of highest difference elements: extract max profit from there 
         * to compare.
         */
        if((max_profit_high_index- max_profit_low_index)>2)
        {
            int max_inside=price[max_profit_high_index-1];
            int min_inside=price[max_profit_high_index-1];
            for(int i=(max_profit_high_index-1);i>=(max_profit_low_index+1);i--)
            {
                if((max_inside-price[i])<0 &&(price[i]-max_inside)>temp_inside)
                {
                    temp_inside=price[i]-max_inside;                   
                }
                else if((max_inside-price[i])>0)
                {
                    max_inside=price[i];
                }
            }
        }
        int final_profit_inside=max_profit+temp_inside;
        
        /*
         * remove the subset and check for highest output
         */
        if(max_profit_low_index==0 && max_profit_high_index<(len-1))
        {
            min=price[max_profit_high_index+1];
        }
        else
        {
            min=price[0];
        }
        int temp2=0;
            for(int i=1;i<len;i++)
            {
                if(i>=max_profit_low_index && i<=max_profit_high_index)
                {
                //ignore the part
                }
                else
                {
                    if(price[i]<min)
                        min=price[i];
                    else 
                    {
                        if((price[i]-min)>temp2)
                            temp2=price[i]-min;
                    }
                       
                }
            }
            int final_profit_outside=max_profit+temp2;
            int ans=final_profit_outside;
            if(final_profit_outside< final_profit_inside)
                ans= final_profit_inside;
        System.out.println(ans);
    }
}
