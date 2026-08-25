package dsPreAssess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver implements OrderDB{
	private String[][]orders;
	
	public Driver() {
		
	}
	
	public Driver(String fileName) {
		loadOrders(fileName);
	}
	
	private void readFile(String fileName) throws IOException{
		String line;
		ArrayList<String[]> list = new ArrayList<>();
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		//waste top line
		line = file.readLine();
		
		while((line = file.readLine()) != null) {
			String[] elem = line.split(",");
			list.add(elem);
			//added deliniated string array to list
		}
		
		//make array as big as list
		String[][] orders = new String[list.size()][list.get(0).length];
		
		//fill array
		for(int i = 0; i < orders.length; i++) {
			for(int j = 0; j < orders[0].length;j++) {
				orders[i][j] = list.get(i)[j];
			}
		}
		file.close();
		//save array to object
		this.orders = orders;
	}
	
	@Override
	public void loadOrders(String fileName) {
		//screw this method for not letting IOExceptions
		try {
			readFile(fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showOrders() {
		//print format, %-# means allot # spaces and put a string in it.
		System.out.printf("%-8s %-30s %10s%n","Order ID", "Product", "Total Amt");
		System.out.printf("%-8s %-30s %10s%n","--------", "-------", "---------");
				
		for (int i = 0; i < orders.length; i++) {
				System.out.printf("%-8s %-30s %10s%n",this.orders[i][0], this.orders[i][2], this.orders[i][3]);
				
				}
		
	}

}
