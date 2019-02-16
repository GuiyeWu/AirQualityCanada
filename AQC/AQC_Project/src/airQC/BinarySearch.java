package airQC;

public class BinarySearch {
	public static int searchCity(NodeADT[] x, String key) {
		int min = 0;
		int max = x.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int cmp = key.compareTo(x[mid].getCity());
			if (cmp == 0)
				return mid;
			if (cmp > 0)
				min = mid + 1;
			else
				max = mid - 1;
		}
		return -1;
	}

	public static int searchCityIndex(NodeADT[] x, int key) {
		int min = 0;
		int max = x.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (key == x[mid].getCityIndex())
				return mid;
			if (key > x[mid].getCityIndex())
				min = mid + 1;
			else
				max = mid - 1;
		}
		return min;
	}

}
