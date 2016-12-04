package Properties;

import java.util.*;

public class PropDemo {

	public static void main(String[] args) {
		Properties capitals = new Properties();
		Set<Object> states;
		String str;
		
		capitals.put("Illinois", "Springfield");
		capitals.put("Missouri", "Jefferson City");
		capitals.put("Washington", "Olymfadf");
		capitals.put("Califormifdsf", "taiji");
		capitals.put("Inifdsfd", "ooofdsf");
		
		//show all states and capitals in hashtable
		states = capitals.keySet();
		Iterator<Object> itr = states.iterator();
		while(itr.hasNext())
		{
			str = (String) itr.next();
			System.out.println("The capital of " + 
					str + " is " + capitals.getProperty(str) + ".");
		}
		System.out.println();
	}

}
