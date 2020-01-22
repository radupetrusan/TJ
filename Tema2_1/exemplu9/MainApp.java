package exemplu9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("exemplu9/Beans.xml");
		Mesaj m1 = (Mesaj)context.getBean("mesaj");
		System.out.println("Obiectul m1 dupa creare:" + m1);
		
		m1.setMesaj("Al doilea mesaj!");
		System.out.println("Obiectul m1 dupa setare:" + m1);
		
		Mesaj m2 = (Mesaj)context.getBean("mesaj");
		System.out.println("Obiectul m2 dupa creare:" + m2);
	}

}
