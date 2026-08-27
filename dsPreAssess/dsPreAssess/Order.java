package dsPreAssess;

public class Order {
	private String id = "0000";
	private String name = "None";
	private String product = "None";
	private String amount = "0000";
	private String date = "None";
	
	public Order() {}
	
	public Order(String id, String name, String product, String amount, String date) {
		this.id = id;
		this.name = name;
		this.product = product;
		this.amount = amount;
		this.date = date;
	}
	
	public String toString() {
		return String.format("%-8s %-30s %10s%n", this.id, this.product, this.amount);
	}
	
	
}
