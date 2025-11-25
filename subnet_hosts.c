#include <stdio.h>
#include <limits.h>

int main() {
    int n;
    printf("Enter number of hosts (nodes): ");
    scanf("%d", &n);

    int g[n][n];
    printf("Enter adjacency matrix (0 if no link):\n");
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            scanf("%d",&g[i][j]);

    int key[n], parent[n];
    int visited[n];
    for(int i=0;i<n;i++) { key[i]=INT_MAX; visited[i]=0; }
    key[0]=0; parent[0]=-1;

    for(int count=0; count<n-1; count++){
        int min=INT_MAX, u=-1;
        for(int i=0;i<n;i++)
            if(!visited[i] && key[i]<min) { min=key[i]; u=i; }

        visited[u]=1;

        for(int v=0; v<n; v++)
            if(g[u][v] && !visited[v] && g[u][v]<key[v]){
                key[v]=g[u][v];
                parent[v]=u;
            }
    }

    printf("\nBroadcast Tree (Edges):\n");
    for(int i=1;i<n;i++)
        printf("%d - %d : cost=%d\n", parent[i], i, g[i][parent[i]]);

    return 0;
}