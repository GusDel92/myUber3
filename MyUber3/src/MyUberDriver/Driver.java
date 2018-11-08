package MyUberDriver;

public class Driver {

	public String name;
	public String surname;
	public String state;
	
	public Driver() {
		this.name="Gérard";
		this.surname="Gégé";
		this.state="Au repos";
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
