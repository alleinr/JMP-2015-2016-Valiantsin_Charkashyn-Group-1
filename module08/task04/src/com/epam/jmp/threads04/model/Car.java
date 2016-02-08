package com.epam.jmp.threads04.model;

import java.util.Timer;

public class Car implements Runnable {

	private static final long MAX_DISTANCE = 10000;

	private long friction;
	private long distance;
	private boolean disqualificate;

	private String name;

	public Car(String name, long friction, boolean d) {
		this.name = name;
		this.friction = friction;
		disqualificate = d;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		if (disqualificate == true) {
			Timer timer = new Timer(true);
			timer.schedule(new TimeOutTask(Thread.currentThread()), 200);
		}
		try {
			while (distance < MAX_DISTANCE) {
				Thread.sleep(friction);
				distance += 100;
				System.out.println(name + " " + distance);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
