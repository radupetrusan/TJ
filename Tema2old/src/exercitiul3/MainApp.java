package exercitiul3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) throws IOException {
		String nr_inmatriculare,marca,culoare;
		int anul,nr_km;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("exercitiul3/Beans.xml");
		OperatiiBD operatiiBd= (OperatiiBD)context.getBean("operatiiJDBC");
		
		int optiune = 0;
		boolean loop = true;
		
		while(loop) {
			System.out.println("1.Adauga masina");
			System.out.println("2.Sterge masina");
			System.out.println("3.Cauta masina");
			System.out.println("4.Lista masini");
			System.out.println("5.Afisarea numarului de masini din BD au o anumita marca");
			System.out.println("6.Afisarea statistica a numarului de masini din BD au sub 100 000 km");
			System.out.println("7.Afisarea tuturor caracteristicilor pentru masinile mai noi de 5 ani");
			System.out.println("Alege optiune:");
			
			try {
				optiune = Integer.parseInt(br.readLine());
			}catch(NumberFormatException ex) {
				System.err.println("Invalid format");
				continue;
			}
			
			switch(optiune) {
			case 1:
				System.out.println("Nr. de inmatriculare al masinii:");
			 	nr_inmatriculare = br.readLine();
			 	System.out.println("Marca masinii:");
			 	marca = br.readLine();
			 	System.out.println("Anul masinii:");
				anul = Integer.parseInt(br.readLine());
				System.out.println("Culoarea masinii:");
				culoare = br.readLine();
				System.out.println("Km masinii:");
				nr_km= Integer.parseInt(br.readLine());
			 	
				operatiiBd.insert(nr_inmatriculare, marca, anul, culoare, nr_km);
				break;
			case 2:
				System.out.println("Nr de inmatriculare al masinii:");
			 	nr_inmatriculare = br.readLine();
			 	operatiiBd.delete(nr_inmatriculare);
			 	break;
			case 3:
				System.out.println("Nr de inmatriculare al masinii:");
			 	nr_inmatriculare = br.readLine();
			 	operatiiBd.searchCar(nr_inmatriculare);
			 	break;
			case 4:
				List<Masina> lista_masini = operatiiBd.getListaMasini();
				for (Masina m : lista_masini) 
				{ 
					System.out.println(m);
				}
				break;
			case 5:
				System.out.println("Cauta numarul de masini dupa marca:");
				marca = br.readLine();
				operatiiBd.getNumberOfCars(marca);
				break;
			case 6:
				System.out.println("Numar de km:");
				nr_km = Integer.parseInt(br.readLine());
				List<Masina> masini = operatiiBd.getCarsWithKM(nr_km);
				for(Masina m : masini) {
					System.out.println(m.toString());
				}
				break;
			case 7:
				Calendar calendar  = Calendar.getInstance();
				calendar.add(Calendar.YEAR, -5);
				int year = calendar.get(Calendar.YEAR);
//				Date d1 = calendar.getTime();
//				System.out.println();
				List<Masina> cars = operatiiBd.getCarsByYear(year);
				for(Masina m : cars) {
					System.out.println(m.toString());
				}
				break;
			default: 
				loop = false;
				break;
			}
		}
	}

}
