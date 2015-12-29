package com.epam.jmp.composite.model;

import java.util.ArrayList;
import java.util.List;

public class AstronomicalObject {
	
	private String name;
	private String age;
	private List<AstronomicalObject> subs;
	
	public AstronomicalObject(String name, String age) {
		this.name = name;
		this.age = age;
		subs = new ArrayList<AstronomicalObject>();
	}
	
	public void add (AstronomicalObject object){
		subs.add(object);
	}
	
	public void remove (AstronomicalObject object){
		subs.remove(object);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<AstronomicalObject> getSubs() {
		return subs;
	}

	public void setSubs(List<AstronomicalObject> subs) {
		this.subs = subs;
	}

	@Override
	public String toString() {
		return "AstronomicalObject [name=" + name + ", age=" + age + "]";
	}
}
