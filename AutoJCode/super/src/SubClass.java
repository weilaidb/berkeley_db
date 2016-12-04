package src;

public class SubClass extends SuperClass{

	int i = 100;
	public void showMessage()
	{
		System.out.printf("super.i=%d, this.i=%d\n", super.i, this.i);
		
	}
}
