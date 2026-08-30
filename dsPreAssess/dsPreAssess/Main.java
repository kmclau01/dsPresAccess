package dsPreAssess;

public class Main {
	
	public static void main(String args[]) {
		Driver a = new Driver("orders.txt");
		a.showOrders();
		
		Order order1 = new Order();
		boolean bool = a.add(order1);
		System.out.printf("Adding Object = %b\n", bool);
		a.showOrders();
		
		Order order2 = new Order("1111","Jason Durulo","Whisle","50.0","2020");
		a.add(50,order2);
		a.showOrders();
		
		a.saveOrders("orders2.txt");
		a.clear();
		a.showOrders();
		a.loadOrders("orders2.txt");
		a.showOrders();
		
		System.out.println(a.get(25));
		int index = a.searchByOrderID(1111);
		System.out.printf("Your order is at index %d.\n", index );
		
		Order order3 = a.remove(25);
		a.set(25, order3);
		System.out.println("The system has "+ a.size() + " orders");
		System.out.println("The system has "+ a.capacity() +" slots");
	}
	
}
