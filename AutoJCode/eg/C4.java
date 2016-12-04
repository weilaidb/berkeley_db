
public class C4 implements A, B {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("it's show");

	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("it's eat");

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("it's sleep");

	}

	@Override
	public void atie() {
		// TODO Auto-generated method stub
		System.out.println("it's atie");

	}
	
	public static void main(String[] args)
	{
		System.out.println("test for implements");
		C4 c = new C4();
		c.eat();
		c.atie();
		c.sleep();
		c.show();
	
	}

}
