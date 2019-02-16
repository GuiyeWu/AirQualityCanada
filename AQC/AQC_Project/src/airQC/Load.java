package airQC;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Load {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NodeADT[] nodes = toNodeADT();
		for (int i = 0; i < nodes.length; i++) {
			System.out.println(nodes[i]);
		}

	}

	public static NodeADT[] toNodeADT() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/201702_MONTHLY_AQHI_ON_SiteObs.csv"));
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		String line = br.readLine();
		String[] lineL = line.split(",");
		for (int i = 2; i < lineL.length; i++) {
			ArrayList<String> str = new ArrayList<String>();
			data.add(str);
		}
		for (int i = 2; i < lineL.length; i++) {
			ArrayList<String> element = data.get(i - 2);
			element.add(lineL[i]);
			data.set(i - 2, element);
		}
		while ((line = br.readLine()) != null) {
			String[] lineLst = line.split(",");
			for (int i = 2; i < lineLst.length; i++) {
				ArrayList<String> element = data.get(i - 2);
				element.add(lineLst[i]);
				data.set(i - 2, element);

			}
		}
		ArrayList<String[]> CGNDB = loadCGNDB();
		NodeADT[] nodes = new NodeADT[data.size()];
		for (int i = 0; i < data.size(); i++) {
			ArrayList<Double> index = new ArrayList<Double>();
			index = IndexArray(data.get(i));
			double index1;
			index1 = AverageCalculator(index);
			double[] location = new double[2];
			String color;
			color = Color(index1);
			String cityName = "";
			for (String[] s:CGNDB) {
				if (s[0].equals(data.get(i).get(0))) {
					cityName = s[1];
					location[0] = Double.parseDouble(s[3]);
					location[1] = Double.parseDouble(s[4]);
				}
			}
			nodes[i] = new NodeADT(i,cityName, color, index1, location);
		}
		return nodes;
	}
	
	private static ArrayList<String[]> loadCGNDB() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/CGNDB_List.txt"));
		ArrayList<String[]> CGNDB = new ArrayList<String[]>();
		String line;
		while ((line = br.readLine()) != null) {
			String[] city = line.split(",");
			CGNDB.add(city);
		}
		return CGNDB;
	}

	private static String Color(double index) {
		String color = "SOMETHING WRONG";

		if (0 <= index && index < 1.5)
			color = "LightBlue";
		else if (1.5 <= index && index < 2.5)
			color = "RoyalBlue";
		else if (2.5 <= index && index < 3.5)
			color = "MediumBlue";
		else if (3.5 <= index && index < 4.5)
			color = "Yellow";
		else if (4.5 <= index && index < 5.5)
			color = "Gold";
		else if (5.5 <= index && index < 6.5)
			color = "Orange";
		else if (6.5 <= index && index < 7.5)
			color = "Violet";
		else if (7.5 <= index && index < 8.5)
			color = "Red";
		else if (8.5 <= index && index < 9.5)
			color = "Crimson";
		else if (9.5 <= index && index < 10.5)
			color = "FireBrick";
		else if (10.5 <= index)
			color = "DarkRed";

		return color;
	}

	private static double AverageCalculator(ArrayList<Double> index) {
		double avg = 0.0;
		for (double i : index) {
			avg += i;
		}
		avg = avg / index.size();
		return avg;
	}

	private static ArrayList<Double> IndexArray(ArrayList<String> s) {
		ArrayList<Double> index = new ArrayList<Double>();
		for (int i = 0; i < s.size() - 1; i++) {
			if (!s.get(i + 1).equals(""))
				index.add(Double.parseDouble(s.get(i + 1)));
		}
		return index;
	}
}
