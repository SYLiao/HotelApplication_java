package Testcase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javab.Hotel;
import javab.Room;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res = new ClassPathResource("springCfg.xml");
		BeanFactory bean = new XmlBeanFactory(res);
		
		
		Hotel h1 = (Hotel) bean.getBean("Hotel1");
		Room r1 = (Room) bean.getBean("Room1");
		
		System.out.println(h1.toString());
		System.out.println("------------------------------");
		h1.addRoom(r1, 2);
		System.out.println(h1.toString());
	}

}
