package airQC;

// Edge two weighted directed graph
// Reference: EdgeWeightedDigraph.java, authors: Robert Sedgewick and Kevin Wayne
public class EdgeWeightedDigraph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	// Initializes an edge two weighted directed graph with v
	// Uses Bag.java (authors: Robert Sedgewick and Kevin Wayne)
	public EdgeWeightedDigraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}

	// Returns the number of nodes
	public int V() {
		return V;
	}

	// Returns the number of edges
	public int E() {
		return E;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	// Adds a two weights directed edge to the graph
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		E++;
	}

	// Returns the connected edge of v
	public Iterable<DirectedEdge> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	
	// Outputs the view of the graph
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (DirectedEdge e : adj[v]) {
				s.append(e + "  ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
}
