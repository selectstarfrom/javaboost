package com.javaboost.core.String;

public class App {
	public static void main(String[] args) {
		
		String lName1 = "Syed1";
		String lName2 = "Syed1";
		
		Employee lEmployee1 = new Employee(100L, 28, lName1);
		Employee lEmployee2 = new Employee(100L, 28, lName2);

		System.out.println("E1 Name: " + lEmployee1.getName().hashCode());
		System.out.println("E2 Name: " + lEmployee2.getName().hashCode());

		System.out.println("E1 Name: " + Integer.toHexString(lEmployee1.getName().hashCode()));
		System.out.println("E2 Name: " + Integer.toHexString(lEmployee2.getName().hashCode()));
		// -----------------------------------------
		
		System.out.println("-----------------------------------------");

		System.out.println("E1 ref: " + Integer.toHexString(lEmployee1.hashCode()));
		System.out.println("E2 ref: " + Integer.toHexString(lEmployee2.hashCode()));
		
		System.out.println("E1 hc: " + lEmployee1.hashCode());
		System.out.println("E2 hc: " + lEmployee2.hashCode());

	}
}

class Employee {

	private Long id;
	private Integer age;
	private String name;

	public Employee(Long pId, Integer pAge, String pName) {
		super();
		id = pId;
		age = pAge;
		name = pName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer pAge) {
		age = pAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

}
