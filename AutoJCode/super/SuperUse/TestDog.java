package SuperUse;

class Animal{
	public void move(){
		System.out.println("��������ƶ�");
	}
}

class Dog extends Animal{
	public void move(){
		super.move();
		System.out.println("�������ܺ���");
	}
}




public class TestDog {
	public static void main(String[] args) {
		
	}
}
