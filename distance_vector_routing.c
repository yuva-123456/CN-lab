#include <stdio.h>
#include <limits.h>

#define MAX 10

int main() {
    int n, i, j, k;

    printf("Enter the number of nodes: ");
    scanf("%d", &n);
    
    int cost[MAX][MAX], dist[MAX][MAX], next_hop[MAX][MAX];

    printf("Enter the adjacency matrix (use 0 for no connection and the distance between nodes):\n");
    for(i = 0; i < n; i++) {
        for(j = 0; j < n; j++) {
            scanf("%d", &cost[i][j]);
            if(cost[i][j] == 0 && i != j) {
                cost[i][j] = INT_MAX; 
            }
            dist[i][j] = cost[i][j];
            if(cost[i][j] != INT_MAX && i != j) {
                next_hop[i][j] = j; 
            } else {
                next_hop[i][j] = -1; 
            }
        }
    }

   
    for(k = 0; k < n; k++) {
        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if(dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    next_hop[i][j] = next_hop[i][k]; 
                }
            }
        }
    }

    printf("\nRouting Tables for each node:\n");
    for(i = 0; i < n; i++) {
        printf("Routing Table for Node %d:\n", i);
        for(j = 0; j < n; j++) {
            if(dist[i][j] == INT_MAX) {
                printf("To Node %d: No path\n", j);
            } else {
                printf("To Node %d: Cost = %d, Next Hop = %d\n", j, dist[i][j], next_hop[i][j]);
            }
        }
        printf("\n");
    }

    return 0;
}