package exemplu8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("exemplu8/Beans.xml");
		Persoana p = (Persoana)context.getBean("persoana");
		System.out.println(p);
	}

}
