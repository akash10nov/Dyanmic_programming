/*
 * link to the problem:
 * http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
 * dynamic programming problem
 * THIS SOLUTION will give you information about all the minum distances
 * O(n^2) solution
 */
import java.io.*;
import java.util.*;
public class train_min_cost
{
    public static void main(String[] akash) throws IOException
    {
        /*
         *  Bellman-ford Algorithm
         */
        System.out.println("first line: size of array, then array component");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] data=new int[N][N];
        
        for(int i=0;i<N;i++)
        {
            String s=br.readLine();
            String[] temp=s.split(",");
            for(int j=0;j<N;j++)
            {
                if(temp[j].equals("INF"))
                {
                    data[i][j]=10000000;
                }
                else
                {
                    data[i][j]=Integer.parseInt(temp[j]);
                }
            }
            
        }
        int ans=bellmanford(data,N,0,(N-1));
        System.out.println(ans);
                  
    }
    static int bellmanford(int [][]data, int N,int i,int j)
    {
        
        if((i+1)==j)
        {
            return data[i][j];
        }
        else if((i+2)==j)
        {
            if(data[i][j]<(data[i][i+1]+data[i+1][j]))
                return data[i][j];
            else
                return data[i][i+1]+data[i+1][j];
        }
        else
        {
            int temp1= data[i][i+1]+bellmanford(data,N,i+1,j);
            int temp2= data[j-1][j]+bellmanford(data,N,i,j-1);
            if(temp1<temp2)
                return temp1;
            else
                return temp2;
        }
    }
}