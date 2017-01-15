package com.javaboost.core.String;

public class AppHashCode {
	public static void main(String[] args) {

		String lTest = new String();
		
		String lName1 = "Syed1";
		String lName2 = "Syed1";

		Staff lStaff1 = new Staff(100L, 27, lName1);
		Staff lStaff2 = new Staff(100L, 28, lName2);

		System.out.println(lStaff1.equals(lStaff2));

	}
}

class Staff {

	private Long id;
	private Integer age;
	private String name;

	public Staff(Long pId, Integer pAge, String pName) {
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

	@Override
	public String toString() {
		return "Staff [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
