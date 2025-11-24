import java.util.*;

public class Dijkstra {
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), src=sc.nextInt();
        int[][] g=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                g[i][j]=sc.nextInt();

        int[] d=new int[n]; boolean[] v=new boolean[n];
        Arrays.fill(d,9999); d[src]=0;

        for(int k=0;k<n;k++){
            int u=-1, min=9999;
            for(int i=0;i<n;i++)
                if(!v[i] && d[i]<min){ min=d[i]; u=i; }
            v[u]=true;

            for(int j=0;j<n;j++)
                if(g[u][j]!=0 && d[u]+g[u][j]<d[j])
                    d[j]=d[u]+g[u][j];
        }

        System.out.println("Shortest distances:");
        System.out.println(Arrays.toString(d));
    }
}
