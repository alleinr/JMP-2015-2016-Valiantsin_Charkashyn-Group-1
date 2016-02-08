package com.epam.jmp.threads04.model;

import java.util.TimerTask;

public class TimeOutTask extends TimerTask {

	private Thread t;

	TimeOutTask(Thread t) {
		this.t = t;
	}

	@Override
	public void run() {
		if (t != null && t.isAlive()) {
			t.interrupt();
			System.out.println(t.getName() + " was disqualificated!");
		}

	}

}
