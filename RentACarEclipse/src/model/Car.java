package model;
public class Car {
	private String carName;
	private double price;

	public Car(String carName, double price) {
		this.carName = carName;
		this.price = price;
	}

	public String getCarName() {
		return carName;
	}

	public double getPrice() {
		return price;
	}
}