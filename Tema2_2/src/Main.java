import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Vehicul veh1 = (Vehicul) context.getBean("auto");
        Vehicul veh2 = (Vehicul) context.getBean("moto1");
        Vehicul veh3 = (Vehicul) context.getBean("moto2");
        Vehicul veh4 = (Vehicul)context.getBean("tir1");
        Vehicul veh5 = (Vehicul) context.getBean("tir2");


        System.out.println(veh1.toString());
        System.out.println(veh2.toString());
        System.out.println(veh3.toString());
        System.out.println(veh4.toString());
        System.out.println(veh5.toString());
    }
}
