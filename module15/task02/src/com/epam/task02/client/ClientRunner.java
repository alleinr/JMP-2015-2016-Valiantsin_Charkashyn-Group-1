package com.epam.task02.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.epam.task02.service.IRandomNumberer;

public class ClientRunner {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new URL("http://localhost:12345/ws/random?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		QName qname = new QName("http://service.task02.epam.com/",
				"RandomNumbererService");

		Service service = Service.create(url, qname);
		IRandomNumberer numberer = service.getPort(IRandomNumberer.class);
		System.out.println("Lottery!");
		for (int i = 1; i <= 6; i++) {
			System.out.println("Number ¹ " + i + " is " +numberer.getRandomNumber(49, 0));
		}

	}

}
