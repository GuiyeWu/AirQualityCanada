package airQC;

public class NodeADT implements Comparable<NodeADT> {
	private final int cityIndex;
	private final String city;
	private final String color;
	private final double index;
	private final double[] location;

	public NodeADT(int cityIndex, String city, String color, double index, double[] location) {
		this.city = city;
		this.color = color;
		this.index = index;
		this.location = location;
		this.cityIndex = cityIndex;
	}

	public int getCityIndex() {
		return cityIndex;
	}

	public String getCity() {
		return city;
	}

	public String getColor() {
		return color;
	}

	public double getIndex() {
		return index;
	}

	public double[] getLocation() {
		return location;
	}

	@Override
	public int compareTo(NodeADT other) {
		if (city.compareTo(other.city) < 0)
			return -1;
		if (city.compareTo(other.city) > 0)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%-4d %-19s %-12s %-10f %-10f %-10f", cityIndex, city, color, index, location[0],
				location[1]);
	}

}
