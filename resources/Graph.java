package resources;

import java.util.*;

class Graph {
      static class Edge implements Comparable<Edge> {
            int src, dest, weight;
            
            // Comparator function used for sorting edges based on their weight
            public int compareTo(Edge compareEdge) {
                  return this.weight - compareEdge.weight;
            }
      };
      
      // A class to represent a subset for union-find
      static class Subset {
            int parent, rank;
      };
      
      int V, E;
      Edge edge[];
      
      // Constructor
      Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                  edge[i] = new Edge();
      }
      
      // A utility function to find set of an element i (uses path compression technique)
      int find(Subset subsets[], int i) {
            if (subsets[i].parent != i)
                  subsets[i].parent = find(subsets, subsets[i].parent);
            
            return subsets[i].parent;
      }
      
      // A function that does union of two sets of x and y (uses union by rank)
      void union(Subset subsets[], int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);
            
            if (subsets[xroot].rank < subsets[yroot].rank)
                  subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                  subsets[yroot].parent = xroot;
            else {
                  subsets[yroot].parent = xroot;
                  subsets[xroot].rank++;
            }
      }
      
      // The main function to construct MST using Kruskal's algorithm
      void kruskalMST() {
            Edge result[] = new Edge[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                  result[i] = new Edge();
            
            Arrays.sort(edge);
            
            // Allocate memory for creating V subsets
            Subset subsets[] = new Subset[V];
            for (i = 0; i < V; ++i)
                  subsets[i] = new Subset();
            
            // Create V subsets with single elements
            for (int v = 0; v < V; ++v) {
                  subsets[v].parent = v;
                  subsets[v].rank = 0;
            }
            
            i = 0;
            
            // Number of edges to be taken is equal to V-1
            while (e < V - 1) {
                  Edge nextEdge = new Edge();
                  nextEdge = edge[i++];
                  
                  int x = find(subsets, nextEdge.src);
                  int y = find(subsets, nextEdge.dest);
                  
                  if (x != y) {
                        result[e++] = nextEdge;
                        union(subsets, x, y);
                  }
            }
            
            // Print the contents of result[] to display the built MST
            System.out.println("Following are the edges in the constructed MST using Kruskal's algorithm");
            int minimumCost = 0;
            for (i = 0; i < e; ++i) {
                  System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
                  minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost Spanning Tree " + minimumCost);
      }
      
      // A utility function to find the vertex with the minimum key value,
      // from the set of vertices not yet included in MST
      int minKey(int key[], Boolean mstSet[]) {
            int min = Integer.MAX_VALUE, min_index = -1;
            
            for (int v = 0; v < V; v++)
                  if (mstSet[v] == false && key[v] < min) {
                        min = key[v];
                        min_index = v;
                  }
            
            return min_index;
      }
      
      // A utility function to print the constructed MST stored in parent[]
      void printMST(int parent[], int graph[][]) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < V; i++)
                  System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
      }
      
      // Function to construct and print MST for a graph represented using adjacency matrix representation
      void primMST(int graph[][]) {
            // Array to store constructed MST
            int parent[] = new int[V];
            
            // Key values used to pick minimum weight edge in cut
            int key[] = new int[V];
            
            // To represent set of vertices included in MST
            Boolean mstSet[] = new Boolean[V];
            
            // Initialize all keys as INFINITE
            for (int i = 0; i < V; i++) {
                  key[i] = Integer.MAX_VALUE;
                  mstSet[i] = false;
            }
            
            // Always include first 1st vertex in MST.
            key[0] = 0; // Make key 0 so that this vertex is picked as first vertex
            parent[0] = -1; // First node is always root of MST
            
            // The MST will have V vertices
            for (int count = 0; count < V - 1; count++) {
                  // Pick the minimum key vertex from the set of vertices not yet included in MST
                  int u = minKey(key, mstSet);
                  
                  // Add the picked vertex to the MST set
                  mstSet[u] = true;
                  
                  // Update key value and parent index of the adjacent vertices of the picked vertex.
                  // Consider only those vertices which are not yet included in MST
                  for (int v = 0; v < V; v++)
                        
                        // graph[u][v] is non zero only for adjacent vertices of m
                        // mstSet[v] is false for vertices not yet included in MST
                        // Update the key only if graph[u][v] is smaller than key[v]
                        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                              parent[v] = u;
                              key[v] = graph[u][v];
                        }
            }
            
            // Print the constructed MST
            System.out.println("Following are the edges in the constructed MST using Prim's algorithm");
            printMST(parent, graph);
      }
      
      // Driver Method
      public static void main(String[] args) {
            int V = 4; // Number of vertices in graph
            int E = 5; // Number of edges in graph
            Graph graph = new Graph(V, E);
            
            // add edge 0-1
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = 10;
            
            // add edge 0-2
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 6;
            
            // add edge 0-3
            graph.edge[2].src = 0;
            graph.edge[2].dest = 3;
            graph.edge[2].weight = 5;
            
            // add edge 1-3
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 15;
            
            // add edge 2-3
            graph.edge[4].src = 2;
            graph.edge[4].dest = 3;
            graph.edge[4].weight = 4;
            
            // Kruskal's MST
            graph.kruskalMST();
            
            // Graph for Prim's MST
            int primGraph[][] = new int[][]{{0, 10, 6, 5},
                         {10, 0, 0, 15},
                         {6, 0, 0, 4},
                         {5, 15, 4, 0}};
            
            // Prim's MST
            graph.primMST(primGraph);
      }
}
