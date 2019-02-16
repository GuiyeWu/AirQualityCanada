package airQC;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;

public class FindPath {

	public static EdgeWeightedDigraph toGraph(NodeADT[] nodes) {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(nodes.length);
		for (int i = 0; i < nodes.length; i++) {
			double lat = nodes[i].getLocation()[0];
			double lon = nodes[i].getLocation()[1];
			for (int j = i + 1; j < nodes.length; j++) {
				double lat2 = nodes[j].getLocation()[0];
				double lon2 = nodes[j].getLocation()[1];
				if (lat - 1 < lat2 && lat2 < lat + 1 && lon - 1 < lon2 && lon2 < lon + 1) {
					int iCityIndex = nodes[i].getCityIndex();
					int jCityIndex = nodes[j].getCityIndex();
					double iAirIndex = nodes[i].getIndex();
					double jAirIndex = nodes[j].getIndex();
					DirectedEdge edge = new DirectedEdge(iCityIndex, jCityIndex, jAirIndex);
					DirectedEdge edge2 = new DirectedEdge(jCityIndex, iCityIndex, iAirIndex);
					graph.addEdge(edge);
					graph.addEdge(edge2);
				}

			}
		}
		return graph;
	}
	
	public static int cityToCityIndex(NodeADT[] nodes, String city) {
		Heapsort.sortCity(nodes,nodes.length);
		int index = BinarySearch.searchCity(nodes, city);
		return nodes[index].getCityIndex();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NodeADT[] nodes = Load.toNodeADT();
		EdgeWeightedDigraph graph = toGraph(nodes);
		// System.out.println(graph);
		for (int i = 0; i < nodes.length; i++)
			System.out.println(nodes[i]);
		int input = cityToCityIndex(nodes,"Toronto");
		//System.out.println(input);
		DijkstraSP sp = new DijkstraSP(graph,input);
		Heapsort.sortIndex(nodes, nodes.length);
		System.out.println(sp.hasPathTo(nodes[0].getCityIndex()));
		boolean hasPathTo = sp.hasPathTo(nodes[0].getCityIndex());
		if (hasPathTo) {
			Stack<DirectedEdge> path = sp.pathTo(nodes[0].getCityIndex());
			for (DirectedEdge e:path) {
				System.out.println(e);
			}
		}
	
	
	
	}

}
