package com.epam.jmp.threads06.model;

import java.util.Vector;

@SuppressWarnings("rawtypes")
public class Consumer implements Runnable {

	private final Vector QUEUE;    
	private final int SIZE;

    public Consumer(Vector sharedQueue, int size) {
        this.QUEUE = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer consumed: " + consume());
                Thread.sleep(20);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }

        }
    }

    private int consume() throws InterruptedException {
        while (QUEUE.isEmpty()) {
            synchronized (QUEUE) {
                System.out.println(Thread.currentThread().getName() + " is waiting , size: " + QUEUE.size());
                QUEUE.wait();
            }
        }

        synchronized (QUEUE) {
            QUEUE.notifyAll();
            return (Integer) QUEUE.remove(0);
        }
    }

}
