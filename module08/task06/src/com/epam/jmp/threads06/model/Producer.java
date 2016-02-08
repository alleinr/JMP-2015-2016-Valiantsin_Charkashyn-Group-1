package com.epam.jmp.threads06.model;

import java.util.Vector;

@SuppressWarnings("rawtypes")
public class Producer implements Runnable {

	private final Vector QUEUE;
	private final int SIZE;

	public Producer(Vector sharedQueue, int size) {
		this.QUEUE = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println("Producer produced: " + i);
			produce(i);
		}
	}

	@SuppressWarnings("unchecked")
	private void produce(int i) {
		while (QUEUE.size() == SIZE) {
			synchronized (QUEUE) {
				System.out.println(Thread.currentThread().getName() + " is waiting , size: " + QUEUE.size());
				try {
					QUEUE.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized (QUEUE) {
			QUEUE.add(i);
			QUEUE.notifyAll();
		}
	}

}
