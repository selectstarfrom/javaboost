package com.javaboost.core.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class App {

	public static void main(String[] args) {

		List<Person> lList = new ArrayList<Person>();

		lList.add(new Person(100L, "Syed Firoze"));
		lList.add(new Person(101L, "ASyed Akmal"));
		lList.add(new Person(192L, "Joaq Masc"));
		lList.add(new Person(103L, "Sridevi Bolla"));
		lList.add(new Person(104L, "ZShyam"));

		//List<Person> lArray = lList.stream().filter(p -> p.getName().contains("S"))/*.map(p->p.getName().toUpperCase())*/.collect(Collectors.toList());
//		Optional<Person> lMin = lList.stream().max(Comparator.comparing(item -> item.getId()));
		Optional<Person> lMin = lList.stream().max(Comparator.comparing(item -> item.getName()));
		
		BinaryOperator<Person> accumulator = new BinaryOperator<Person>() {
			
			@Override
			public Person apply(Person pT, Person pU) {
				pT.setName(pT.getName()+"--"+pU.getName());
				return pT;
			}
		};
		
		Person identity = new Person(0L, "STARTS");
		Person lPerson = lList.stream().reduce(identity, accumulator);

		System.out.println(lPerson);
//		for (Object lObject : lList) {
//			System.out.println(lObject);
//		}
	}

}

class Person {
	private Long id;
	private String name;

	public Person(Long pId, String pName) {
		super();
		id = pId;
		name = pName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

}
