package airQC;

// Breadth First Search
public class BFS {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;

	// Computes all paths from start point s
	public BFS(Graph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Integer.MAX_VALUE;
		bfs(G, s);
	}

	// BFS from single source
	// Uses Queue.java (authors: Robert Sedgewick and Kevin Wayne)
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		marked[s] = true;
		distTo[s] = 0;
		q.enqueue(s);
		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}

	// Checks if start point has path to v
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	//Returns the number of edges from start point to v
	public int distTo(int v) {
		return distTo[v];
	}

	// Returns a path from start point to v
	// Uses Stack.java (authors: Robert Sedgewick and Kevin Wayne)
	public Stack<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}
}
