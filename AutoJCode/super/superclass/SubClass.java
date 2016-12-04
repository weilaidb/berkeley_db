package superclass;

public class SubClass extends SuperClass{
	
	private int n;
	SubClass()
	{
		super(300);
		System.out.println("SubClass");
	}
	
	public SubClass(int  n)
	{
		super(2009);
		System.out.println("n = " + n);
		System.out.println("super.n = " + super.n);
		System.out.println("SubClass(int  n)");
		this.n = n;
	}
	

}
