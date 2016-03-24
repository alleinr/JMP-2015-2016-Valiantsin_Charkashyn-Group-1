package com.epam.task02.endpoint;

import javax.xml.ws.Endpoint;

import com.epam.task02.service.RandomNumberer;

public class RandomNumbererPublisher {
	public static void main(String[] args) {
		   Endpoint.publish("http://localhost:12345/ws/random", new RandomNumberer());
	    }
}
