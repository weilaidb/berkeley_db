package polymorphic;

public class Employee {
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address, int number) {
		// TODO Auto-generated constructor stub
		System.out.println("Employee ���캯��");
		this.name    = name;
		this.address = address;
		this.number  = number;
	}
	
	public void mailCheck() {
		System.out.println("�ʼ�֧Ʊ��: " + this.name 
				+"   " + this.address);
	}
	@Override
	public String toString() {
		return name + " " + address + " " + number;
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
	
}
