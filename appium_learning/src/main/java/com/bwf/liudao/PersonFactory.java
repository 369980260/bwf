package com.bwf.liudao;

public class PersonFactory {
	public static Person initPerson(String name, int age) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		return p;
	}
}
