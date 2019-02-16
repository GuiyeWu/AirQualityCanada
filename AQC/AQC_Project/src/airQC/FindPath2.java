package airQC;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class FindPath2 {
	public static Graph toGraph(NodeADT[] nodes) {
		Graph graph = new Graph(nodes.length);
		for (int i = 0; i < nodes.length; i++) {
			double lat = nodes[i].getLocation()[0];
			double lon = nodes[i].getLocation()[1];
			for (int j = i + 1; j < nodes.length; j++) {
				double lat2 = nodes[j].getLocation()[0];
				double lon2 = nodes[j].getLocation()[1];
				if (lat - 1 < lat2 && lat2 < lat + 1 && lon - 1 < lon2 && lon2 < lon + 1) {
					int iCityIndex = nodes[i].getCityIndex();
					int jCityIndex = nodes[j].getCityIndex();
					graph.addEdge(iCityIndex, jCityIndex);
				}

			}
		}
		return graph;
	}
	
	public static int cityToCityIndex(NodeADT[] nodes, String city) {
		Heapsort.sortCity(nodes,nodes.length);
		int i = BinarySearch.searchCity(nodes, city);
		return nodes[i].getCityIndex();
	}
	
	public static String cityIndexToCity(NodeADT[] nodes, int index) {
		Heapsort.sortCityIndex(nodes, nodes.length);
		int i = BinarySearch.searchCityIndex(nodes, index);
		return nodes[i].getCity();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NodeADT[] nodes = Load.toNodeADT();
		Graph graph = toGraph(nodes);
		//System.out.println(graph);
		for (int i = 0; i < nodes.length; i++)
			System.out.println(nodes[i]);
		System.out.println("***********************************************************************");
		System.out.print("Input city: Petawawa");
		int input = cityToCityIndex(nodes,"Petawawa");
		System.out.println("(index: "+input+")");
		BFS sp = new BFS(graph,input);
		Heapsort.sortIndex(nodes, nodes.length);
		System.out.println("The best air quality city: "+nodes[0].getCity()+"(index: "+nodes[0].getCityIndex()+")");
		System.out.println("Is it a path to the best air quality city? "+sp.hasPathTo(nodes[0].getCityIndex()));
		boolean hasPathTo = sp.hasPathTo(nodes[0].getCityIndex());
		if (hasPathTo) {
			Stack<Integer> path = sp.pathTo(nodes[0].getCityIndex());
			System.out.println("The shortest path: ");
			for (Integer e:path) {
				if (e == path.peek())
					System.out.print(e);
				else
					System.out.print(" --> " + e);
			}
			System.out.println();
			for (Integer e:path) {
				if (e == path.peek())
					System.out.print(cityIndexToCity(nodes,e));
				else
					System.out.print(" --> " + cityIndexToCity(nodes,e));
			}
		}
	

        JTextPane jtp = new JTextPane();
       
        UIManager.put("OptionPane.minimumSize",new Dimension(400,200)); 
        JLabel label = new JLabel("Selected City: Hamilton"
        		+ "  (index: "+input+")");
        label.setFont(new Font("Arial",1,22));
        Object[] options = {"City Nearby",
    			"Path to Others","Close"};
    	int n = JOptionPane.showOptionDialog(jtp,label,"Searching Result...",1,1,null,options,options[1]);
    	
    	if (n == 0){
    		Object[] options_0 = {
    				"Return", "Close"
    		};
    		JLabel label_2 = new JLabel("The BEST air quality nearby is:  " + nodes[0].getCity()
    				+"  (index: "+nodes[0].getCityIndex()+")");
    		label_2.setFont(new Font("Arial",1,22));
    		int i = JOptionPane.showOptionDialog(jtp,label_2,"City Nearby...",1,1,null,options_0,options_0[0]);
    		if(i == 0){
    			JOptionPane.showOptionDialog(jtp,label,"Searching Result...",1,1,null,options,options[1]);
    		}
    	}
    	else if(n == 1 ){
    		if(sp.hasPathTo(nodes[0].getCityIndex())){
    			Object[] options_1 = {"Return",
    					"Close",};
    			JLabel label_3 = new JLabel("Path to nearby city ");
    			label_3.setFont(new Font("Arial",1,22));
    			int m = JOptionPane.showOptionDialog(jtp,label_3,"Path to others...",1,1,null,options_1,options[0]);
    			if(m == 0){
    				JOptionPane.showOptionDialog(jtp,label,"Searching Result...",1,1,null,options,options[1]);
    			}
    		}

    	}
	}
    
	}
	
