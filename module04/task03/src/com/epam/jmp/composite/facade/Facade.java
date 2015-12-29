package com.epam.jmp.composite.facade;

import com.epam.jmp.composite.model.AstronomicalObject;

public class Facade {

	public AstronomicalObject createUniverse(){
		AstronomicalObject universe = new AstronomicalObject("Universe", "infinite");
		
		AstronomicalObject superCluster1 = new AstronomicalObject("Supercluster Laniakea", "not defined");
		AstronomicalObject superCluster2 = new AstronomicalObject("Virgo Supercluster", "not defined");
		
		AstronomicalObject galaxy1 = new AstronomicalObject("Milky Way Galaxy", "not defined");
		AstronomicalObject galaxy2 = new AstronomicalObject("Andromeda Galaxy", "not defined");
		
		AstronomicalObject planetarySystem = new AstronomicalObject("Solar system", "not defined");
		
		AstronomicalObject planet1 = new AstronomicalObject("Planet Earth", "not defined");
		AstronomicalObject planet2 = new AstronomicalObject("Planet Mars", "not defined");
		AstronomicalObject planet3 = new AstronomicalObject("Planet Venus", "not defined");
		
		planetarySystem.add(planet1);
		planetarySystem.add(planet2);
		planetarySystem.add(planet3);
		
		galaxy1.add(planetarySystem);
		
		superCluster1.add(galaxy1);
		superCluster1.add(galaxy2);
		
		universe.add(superCluster1);
		universe.add(superCluster2);
		
		return universe;
	}
	
	public void outputUniverse(AstronomicalObject universe){
		
		System.out.println(universe);
			for (AstronomicalObject whole: universe.getSubs()){
				System.out.println("\t" + whole);
				if (whole == null || !whole.getSubs().isEmpty()){
					for (AstronomicalObject sub1: whole.getSubs()){
						System.out.println("\t\t" + sub1);
						if (sub1 == null || !sub1.getSubs().isEmpty()){
							for (AstronomicalObject sub2: sub1.getSubs()){
								System.out.println("\t\t\t" + sub2);
								if (sub2 == null || !sub2.getSubs().isEmpty()){
									for (AstronomicalObject sub3: sub2.getSubs()){
										System.out.println("\t\t\t\t" + sub3);
										
									}
								}
							}
						}
					}
				}
			}
	}
}
