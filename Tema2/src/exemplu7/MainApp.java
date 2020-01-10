package exemplu7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("exemplu7/Beans3.xml");
		Persoana p = (Persoana)context.getBean("persoana");
		System.out.println(p);
	}

}
