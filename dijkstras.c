#include <stdio.h>
#include <limits.h>

#define MAX 20

int main() {
    int n, i, j;
    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int g[MAX][MAX];
    printf("Enter adjacency matrix (0 if no edge):\n");
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            scanf("%d",&g[i][j]);

    int dist[MAX], visited[MAX];
    int src;
    printf("Enter source node (0 to %d): ", n-1);
    scanf("%d",&src);

    for(i=0;i<n;i++){
        dist[i] = INT_MAX;
        visited[i] = 0;
    }
    dist[src] = 0;

    for(i=0;i<n-1;i++){
        int min=INT_MAX, u=-1;
        for(j=0;j<n;j++)
            if(!visited[j] && dist[j]<min){ min=dist[j]; u=j; }

        visited[u] = 1;

        for(j=0;j<n;j++)
            if(g[u][j] && !visited[j] && dist[u]+g[u][j]<dist[j])
                dist[j] = dist[u] + g[u][j];
    }

    printf("\nShortest distances from node %d:\n", src);
    for(i=0;i<n;i++)
        printf("Node %d : %d\n", i, dist[i]);

    return 0;
}