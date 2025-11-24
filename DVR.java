import java.util.*;

public class DVR {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();                 // number of nodes
        int[][] cost=new int[n][n];        // adjacency matrix
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cost[i][j]=s.nextInt();

        int[][] dist=new int[n][n];        // each node's distance vector
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j]=cost[i][j];

        // Distance Vector Iterations (Bellman–Ford)
        for(int k=0;k<n-1;k++)
            for(int i=0;i<n;i++)          // router i
                for(int j=0;j<n;j++)      // destination j
                    for(int v=0;v<n;v++)  // neighbor v
                        if(dist[i][j] > cost[i][v] + dist[v][j])
                            dist[i][j] = cost[i][v] + dist[v][j];

        System.out.println("\nDistance Vectors:");
        for(int i=0;i<n;i++)
            System.out.println("Router "+i+" : "+Arrays.toString(dist[i]));
    }
}
