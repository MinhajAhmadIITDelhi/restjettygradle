package sample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	public String name;
	public int age;

	public User() { // JAXB needs this
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}