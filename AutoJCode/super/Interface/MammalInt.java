package Interface;


public class MammalInt implements Animal {

	@Override
	public void eat() {
		System.out.println("MammalInt  eat");
	}

	@Override
	public void travel() {
		System.out.println("MammalInt travel");
	}
	
	public int noOfLegs() {
		return 0;
	}
	public static void main(String[] args) {
		MammalInt m = new MammalInt();
		m.eat();
		m.travel();
	}

}

