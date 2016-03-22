package com.epam.task02.service;

import java.util.Random;

import javax.jws.WebService;


@WebService(endpointInterface = "com.epam.task02.service.IRandomNumberer")
public class RandomNumberer implements IRandomNumberer {

	public int getRandomNumber(int upper, int lower) {	
		
		Random random = new Random();
		long range = (long)upper - (long)lower + 1;
	    long fraction = (long)(range * random.nextDouble());
	    int randomNumber =  (int)(fraction + lower);   
		return randomNumber;
	}
	

}
