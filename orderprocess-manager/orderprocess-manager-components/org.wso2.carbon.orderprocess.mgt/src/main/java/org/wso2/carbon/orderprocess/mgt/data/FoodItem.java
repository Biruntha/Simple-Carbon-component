package org.wso2.carbon.orderprocess.mgt.data;

public class FoodItem {

	private int Id;
	private String foodItemName;
	private String foodItemprice;

	public FoodItem(int ID, String fooditemName, String foodItemprice) {

		this.Id = ID;
		this.foodItemName = fooditemName;
		this.foodItemprice = foodItemprice;
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public String getFoodItemprice() {
		return foodItemprice;
	}

	public void setFoodItemprice(String foodItemprice) {
		this.foodItemprice = foodItemprice;
	}

}
