public class InsertionSort {

	public static void sort(ArrayBasedList<Product> plist) throws Exception {
		Product standardProduct = null, targetProduct = null;
		int listSize = plist.size();
		int insertIndex = 0;
		boolean flag;
		for (int i = 1; i < listSize; i++) {
			flag = false;
			standardProduct = plist.get(i);
			for (int j = i - 1; j >= 0; j--) {
				targetProduct = plist.get(j);
				if (standardProduct.getAvgRating().floatValue() < targetProduct.getAvgRating().floatValue()) {
					insertIndex = j;
					flag = true;
				}
			}
			if (flag) {
				plist.swapValue(insertIndex, i);
			}
		}
	}
}
