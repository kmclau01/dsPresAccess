package dsPreAssess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver implements OrderDB{
	private Order[] orders;
	
	public Driver() {
		
	}
	
	public Driver(String fileName) {
		loadOrders(fileName);
		orders = new Order[25];
	}
	
	private void readFile(String fileName) throws IOException{
		String line;
		int index = 0;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		//waste top line
		line = file.readLine();
		
		while((line = file.readLine()) != null) {
			String[] elem = line.split(",");
			
			if(index >= orders.length) {
				resize();
			}
			
			orders[index] = new Order(elem[0],elem[1],elem[2],elem[3],elem[4]);
			index++;
			
		}
		
		file.close();
	}
	
	
	public int loadOrders(String fileName) {
		//screw this method for not letting IOExceptions
		try {
			readFile(fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	public void showOrders() {
		//print format, %-# means allot # spaces and put a string in it.
		System.out.printf("%-8s %-30s %10s%n","Order ID", "Product", "Total Amt");
		System.out.printf("%-8s %-30s %10s%n","--------", "-------", "---------");
				
		for (int i = 0; i < orders.length; i++) {
				//System.out.printf("%-8s %-30s %10s%n",this.orders[i][0], this.orders[i][2], this.orders[i][3]);
				
				}
		
	}

	@Override
	public int saveOrders(String fileName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchByOrderID(int orderID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order set(int index, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resize() {
		Order[] ordersNew = new Order[this.orders.length + 25];
		
		for(int i = 0; i < this.orders.length; i++) {
			ordersNew[i] = this.orders[i];
		}
		
		this.orders = ordersNew;
		
	}

}
