package exemplu5;

import java.beans.Beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

class Dreptunghi {
	private int lungime;

	private int latime;
	
	public void aria() {
		System.out.println("Aria dreptunghiului:" + (lungime * latime));
	}
	
	public int getLungime() {
		return lungime;
	}

	public void setLungime(int lungime) {
		this.lungime = lungime;
	}

	public int getLatime() {
		return latime;
	}

	public void setLatime(int latime) {
		this.latime = latime;
	}
	
}

public class exemplu5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/exemplu5/Beans.xml"));
		Dreptunghi d = (Dreptunghi)factory.getBean("dreptunghi");
		d.aria();
	}

}
