package com.epam.jmp.third.model;

import java.util.List;

public class Car {

	private List<Wheel> wheels = null;
	private SteeringWheel steeringWheel = null;
	private List<Chair> chairs = null; 
	private Engine engine = null;
	private Coachwork coachwork = null;
	public List<Wheel> getWheels() {
		return wheels;
	}
	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}
	public SteeringWheel getSteeringWheel() {
		return steeringWheel;
	}
	public void setSteeringWheel(SteeringWheel steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	public List<Chair> getChairs() {
		return chairs;
	}
	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Coachwork getCoachwork() {
		return coachwork;
	}
	public void setCoachwork(Coachwork coachwork) {
		this.coachwork = coachwork;
	}
	
	

}
