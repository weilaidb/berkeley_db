//package abstracttest;
//
//public class AbstractDemo {
//	public static void main(String[] args) {
//		Employee e = new Employee("George W.", "Houston", 43); //Employee is abstract; cannot be instantiated
//		System.out.println("\n Call mailCheck using Employee reference--");
//		e.mailCheck();
//	}
//	
//}



package abstracttest;

public class AbstractDemo{
	public static void main(String[] args) {
		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
		Employee e = new Salary("John Adamas", "Boston, Ma", 2, 2400.00);
		
		System.out.println("Call mailCheck using Salary reference -- ");
		s.mailCheck();
		s.show();
		
		System.out.println("\n Call mailCheck using Employee reference -- ");
		e.mailCheck();
		e.show();
	}
}
