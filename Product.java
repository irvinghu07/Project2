
public class Product{

	private String asin;

	private Float avgRating;

	public Product(String asin, int[] ratings) {
		this.setAsin(asin);
		int sum = 0;

		for (int i = 0; i < ratings.length; i++) {
			sum += ratings[i];
		}
		this.setAvgRating(Float.valueOf((float) sum / ratings.length));
	}

	// Getters and Setters
	@Override
	public String toString() {
		return String.format("ASIN:%s\tVALUES:%f\n", this.getAsin(), this.getAvgRating());
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public Float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}


}
