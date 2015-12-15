package com.epam.jmp.factory.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.jmp.factory.model.Person;

public class SerializationTool {

	public Person deserialize(String fileName) {
		Person person = null;
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileStream);
			person = (Person) in.readObject();
			in.close();
			fileStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return person;
	}

	public void serialize(Person person) {
		String fileName = person.getName();
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(person);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
