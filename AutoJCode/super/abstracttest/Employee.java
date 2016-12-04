package abstracttest;

public abstract class Employee {
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address,int number) {
		System.out.println("Constructing an Employee");
		this.name = name;
		this.address  = address;
		this.number = number;
	}
	public double computePay() {
		System.out.println("Mailing a check to " + this.name
				+"  " + this.address);
		return 0.0;
	}
	@Override
	public String toString() {
		return name + "  " + address +  "   " + name; 
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void mailCheck() {
		System.out.println("Mailing a check to " + this.name
				+ "  " + this.address);
	}
	
	public abstract void show();
}


