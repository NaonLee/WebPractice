package di_practice01;

public class PersonServiceImpl implements PersonService{
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

}
