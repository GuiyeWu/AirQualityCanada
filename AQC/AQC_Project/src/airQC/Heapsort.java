package airQC;

public class Heapsort {
	public static void sortCity(Comparable[] x, int n) {
		for (int k = n / 2; k >= 1; k--)
			sinkCity(x, k, n);
		while (n > 1) {
			Comparable t = x[0];
			x[0] = x[n - 1];
			x[n - 1] = t;
			n--;
			sinkCity(x, 1, n);
		}
	}

	private static void sinkCity(Comparable[] x, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && x[j - 1].compareTo(x[j]) < 0)
				j++;
			if (x[k - 1].compareTo(x[j - 1]) >= 0)
				break;
			Comparable t = x[k - 1];
			x[k - 1] = x[j - 1];
			x[j - 1] = t;
			k = j;
		}
	}

	public static void sortCityIndex(NodeADT[] x, int n) {
		for (int k = n / 2; k >= 1; k--)
			sinkCityIndex(x, k, n);
		while (n > 1) {
			NodeADT t = x[0];
			x[0] = x[n - 1];
			x[n - 1] = t;
			n--;
			sinkCityIndex(x, 1, n);
		}
	}

	private static void sinkCityIndex(NodeADT[] x, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && x[j - 1].getCityIndex() < x[j].getCityIndex())
				j++;
			if (x[k - 1].getCityIndex() >= (x[j - 1].getCityIndex()))
				break;
			NodeADT t = x[k - 1];
			x[k - 1] = x[j - 1];
			x[j - 1] = t;
			k = j;
		}
	}
	//sort air quality index
	public static void sortIndex(NodeADT[] x, int n) {
		for (int k = n / 2; k >= 1; k--)
			sinkIndex(x, k, n);
		while (n > 1) {
			NodeADT t = x[0];
			x[0] = x[n - 1];
			x[n - 1] = t;
			n--;
			sinkIndex(x, 1, n);
		}
	}

	private static void sinkIndex(NodeADT[] x, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && x[j - 1].getCityIndex() < x[j].getIndex())
				j++;
			if (x[k - 1].getIndex() >= (x[j - 1].getIndex()))
				break;
			NodeADT t = x[k - 1];
			x[k - 1] = x[j - 1];
			x[j - 1] = t;
			k = j;
		}
	}
}
