package org.wso2.carbon.orderprocess.mgt;

import org.wso2.carbon.orderprocess.mgt.data.FoodItem;

public class OrderProcessManager {

	private FoodItem[] foodItems;
	
	public OrderProcessManager() {
		
		foodItems = new FoodItem[4];
		foodItems[0] = new FoodItem(001,"Ice Coffee", "120.00");
		foodItems[1] = new FoodItem(002, "Fruit Salad", "80.00");
		foodItems[2] = new FoodItem(003, "Milk Shake", "220.00");
		foodItems[3] = new FoodItem(004, "Burger", "420.00");
		
    }
	

	public FoodItem[] getMenu() {
		
		return foodItems;
	}
	
	public String confirmItem(String foodItemName, String foodItemPrice) {
		
		return "Your "+foodItemName+" is ready, Make the $"+foodItemPrice+" payment";
		
	}
}
