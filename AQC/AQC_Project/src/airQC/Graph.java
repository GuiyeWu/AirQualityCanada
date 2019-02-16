package airQC;

public class Graph {

	private Bag<Integer>[] adj;
	private int V;
	private int E;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
		for (int v = 0; v < V; v++)
			// Initialize all lists
			adj[v] = new Bag<Integer>(); // to empty.
	}

	public void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v))
			degree++;
		return degree;
	}

	public static int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V(); v++)
			if (degree(G, v) > max)
				max = degree(G, v);
		return max;
	}

	public static int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				if (v == w)
					count++;
		return count / 2; // each edge counted twice
	}

	@Override
	public String toString() {
		String s = V + "	vertices,	" + E + "	edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ":	";
			for (int w : this.adj(v))
				s += w + "	";
			s += "\n";
		}
		return s;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Graph a = new Graph(3);
//		a.addEdge(0, 0);
//		a.addEdge(0, 1);
//		a.addEdge(0, 2);
//		System.out.println("Graph1:");
//		System.out.println(a);
//
//		// Graph b = new Graph(new In("graph.txt"));
//		// System.out.println("Graph2");
//		// System.out.println(b);
//
//		int degree = degree(a, 0); // 4
//		int maxDegree = maxDegree(a); // 4
//		int avgDegree = avgDegree(a); // 2 * 4/3 = 2
//		int selfLoop = numberOfSelfLoops(a);
//
//		System.out.println("degree: " + degree);
//		System.out.println("max degree: " + maxDegree);
//		System.out.println("avg degree: " + avgDegree);
//		System.out.println("self loops: " + selfLoop);
//	}

}
