import java.util.*;

public class BroadcastTree {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[][] g=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                g[i][j]=s.nextInt();

        boolean[] v=new boolean[n];
        int[] key=new int[n], parent=new int[n];
        Arrays.fill(key,9999); key[0]=0; parent[0]=-1;

        for(int c=0;c<n-1;c++){
            int u=-1,min=9999;
            for(int i=0;i<n;i++)
                if(!v[i] && key[i]<min){min=key[i];u=i;}
            v[u]=true;

            for(int j=0;j<n;j++)
                if(g[u][j]!=0 && !v[j] && g[u][j]<key[j]){
                    key[j]=g[u][j];
                    parent[j]=u;
                }
        }

        System.out.println("Broadcast Tree:");
        for(int i=1;i<n;i++)
            System.out.println(parent[i]+" - "+i+" : cost="+g[i][parent[i]]);
    }
}
