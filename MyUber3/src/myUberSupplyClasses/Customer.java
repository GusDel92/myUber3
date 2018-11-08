package supplyClasses;

public class Customer {

	public String name;
	public String surname;
	public Coordinates coordinates;
	
	public Customer() {
		this.name="Robert";
		this.surname="Bebert";
		this.coordinates.x=0;
		this.coordinates.y=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}