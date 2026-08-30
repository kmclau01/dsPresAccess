package dsPreAssess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver implements OrderDB{
	private Order[] orders;
	private int index;
	public Driver() {
		
	}
	
	public Driver(String fileName) {
		this.orders = new Order[25];
		loadOrders(fileName);
	}
	
	private void readFile(String fileName) throws IOException{
		String line;
		this.index = 0;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		//waste top line
		line = file.readLine();
		
		while((line = file.readLine()) != null) {
			String[] elem = line.split(",");
			
			if(this.index >= this.orders.length) {
				resize();
			}
			
			this.orders[this.index] = new Order(elem[0],elem[1],elem[2],elem[3],elem[4]);
			this.index++;
			
		}
		
		file.close();
	}
	
	private void writeFile( String fileName) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("Order_ID,Customer_Name,Product,Total_Amount,Order_Date");
			writer.newLine();
		if(this.index != 0) {
			for(int i = 0; i < this.index; i++) {
				System.out.println("Saving order "+i);
				writer.write(this.orders[i].id()+","+this.orders[i].name()+","+this.orders[i].product()+","+this.orders[i].amount()+","+this.orders[i].date());
				writer.newLine();
			}
		}
		else {
			System.out.println("No orders to save!");
		}
		
		writer.close();
	}
	
	
	public int loadOrders(String fileName) {
		//screw this method for not letting IOExceptions
		System.out.println("Loading Orders from "+ fileName +" ...");
		try {
			readFile(fileName);	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.index;
	}

	
	public void showOrders() {
		//print format, %-# means allot # spaces and put a string in it.
		System.out.println("Showing Orders ...");
		System.out.printf("%-8s %-30s %10s%n","Order ID", "Product", "Total Amt");
		System.out.printf("%-8s %-30s %10s%n","--------", "-------", "---------");
				
		for (int i = 0; i < this.index; i++) {
				System.out.println(this.orders[i].toString());
		}
		
	}

	@Override
	public int saveOrders(String fileName){
		System.out.println("Saving Orders to "+ fileName +" ...");
		try {
			writeFile(fileName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return this.index;
	}

	@Override
	public boolean add(Order order) {
		System.out.println("Adding Order ...");
		try {
			if(this.index >= orders.length) {
				resize();
			}
			orders[this.index] = order;
			this.index++;
			return true;
		}
		catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}

	@Override
	public void add(int index, Order order) {
		System.out.printf("Adding Order at %d ...\n", index);
		try {
			this.orders[index] = order;
			if(this.orders[index] == null){
				this.index++;
			}

		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index was out of bounds of the array");
		}
		
	}

	@Override
	public void clear() {
		System.out.println("Clearing Orders ...");
		this.orders = new Order[25];
		this.index = 0;
	}

	@Override
	public Order get(int index) {
		System.out.println("Getting Order ...");
		return this.orders[index];
	}

	@Override
	public int searchByOrderID(int orderID) {
		System.out.printf("Searching for Order %d ...\n",orderID);
		int ind = -1;
		for(int i = 0; i<this.index;i++) {
			if(orderID == Integer.parseInt(this.orders[i].id())){
				ind = i;
			}
		}
		return ind; 
	}

	@Override
	public Order remove(int index) {
		System.out.printf("Removing Order at %d ...\n",index);
		Order temp = this.orders[index];
		this.orders[index] = null;
		this.index--;
		return temp;
	}

	@Override
	public Order set(int index, Order order) {
		System.out.printf("Setting Order at index %d ...\n", index);
		Order temp = this.orders[index];
		this.orders[index] = order;
		return temp;
	}

	@Override
	public int size() {
		return this.index;
	}

	@Override
	public int capacity() {
		return this.orders.length;
	}

	@Override
	public void resize() {
		System.out.println("Resizing ...");
		Order[] ordersNew = new Order[this.orders.length + 25];
		
		for(int i = 0; i < this.orders.length; i++) {
			ordersNew[i] = this.orders[i];
		}
		
		this.orders = ordersNew;
		
		
	}

}
