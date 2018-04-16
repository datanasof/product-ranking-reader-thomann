package server;

public class Product {
	private String name;
	private String url;
	private String type;
	private String ranking;
	private String fileName;
	private String[] categoryURL;
	private String price;
	
	public Product(String name, String url, String type){
		this.name = name;
		this.url = url;
		this.setType(type);
		this.ranking = "";
		this.fileName = Credentials.reportFilePath + name + ".txt";
		if(type.equals("th")) this.categoryURL = Credentials.THcategory;
		else if(type.equals("usb")) this.categoryURL = Credentials.USBcategory;
		this.price = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getCategoryURL() {
		return categoryURL;
	}

	public void setCategoryURL(String[] categoryURL) {
		this.categoryURL = categoryURL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
