package com.epam.jmp.threads06.runner;

import java.util.Vector;

import com.epam.jmp.threads06.model.Consumer;
import com.epam.jmp.threads06.model.Producer;
import com.epam.jmp.threads06.tool.Output;

public class Runner {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Vector sharedQueue = new Vector();		
        int size = new Integer(new Output().init());
        Thread producer = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consumer = new Thread(new Consumer(sharedQueue, size), "Consumer");
        producer.start();
        consumer.start();
    }
}
