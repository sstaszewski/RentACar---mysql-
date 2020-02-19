package model;

// nie wnikaj po co ta klasa ;)
public class RentedCar {
	private String name;
	private double length;
	private double pri;

	public RentedCar() {

	}

	public RentedCar(RentedCar rentedCar) {
		this.name = rentedCar.name;
		this.pri = rentedCar.pri;
		this.length = rentedCar.length;
	}

	public RentedCar(String name, double pri, double length) {
		this.name = name;
		this.pri = pri;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public double getLength() {
		return length;
	}

	public double getPri() {
		return pri;
	}

	public void setCarName(String name) {
		this.name = name;
	}

	public void setCarPri(double pri) {
		this.pri = pri;
	}

	public void setCarLength(double lenght) {
		this.length = lenght;
	}
}