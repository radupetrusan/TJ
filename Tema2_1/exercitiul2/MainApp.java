package exercitiul2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("exercitiul2/Beans.xml");
		Vehicul veh1 = (Autoturism)context.getBean("auto");
		Vehicul veh2 = (Motocicleta)context.getBean("moto1");
		Vehicul veh3 = (Tir)context.getBean("tir1");
		Vehicul veh4 = (Tir)context.getBean("tir2");
		Vehicul veh5 = (Motocicleta)context.getBean("moto2");
		
		System.out.println(veh1.toString());
		System.out.println(veh2.toString());
		System.out.println(veh3.toString());
		System.out.println(veh4.toString());
		System.out.println(veh5.toString());
	}

}
