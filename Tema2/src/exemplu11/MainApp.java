package exemplu11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("exemplu11/Beans.xml");
		Persoana p = (Angajat)context.getBean("angajat");
		System.out.println(p);
	}

}
