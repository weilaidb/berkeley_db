package Override2;

class Animal{
	public void move(){
		System.out.println("��������ƶ�");
		
	}
}

class Dog extends Animal{
	public void move(){
		System.out.println("�������ܺ���");
		
	}
	
	public void bark(){
		System.out.println("�����Էͽ�");
		
	}
}


public class TestDog{
	public static void main(String[] args){
		Animal a = new Animal();
		Animal b = new Dog();
		a.move();
		b.move();
//		b.bark(); //error
	}
}