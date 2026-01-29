package logic;

import java.util.ArrayList;
import java.util.Objects;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		this.orderNumber=totalOrderCount;
		totalOrderCount++;
		orderItemList = new ArrayList<OrderItem>();

	}

	public OrderItem addItem(Item item, int amount) {

		for(OrderItem tt:orderItemList){
			if(tt.getItem().getName().equals(item.getName())){
				if(tt.getItemAmount()+amount>=0){
					tt.setItemAmount(tt.getItemAmount()+amount);

				}
				return tt;
			}
		}


		OrderItem newOrderItem =new OrderItem(item,amount);
		this.orderItemList.add(newOrderItem);
		return newOrderItem;
	}

	public int calculateOrderTotalPrice() {
		int TotalPrice =0;
		for(OrderItem tt:orderItemList){
			TotalPrice += tt.calculateTotalPrice();
		}
		return TotalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
