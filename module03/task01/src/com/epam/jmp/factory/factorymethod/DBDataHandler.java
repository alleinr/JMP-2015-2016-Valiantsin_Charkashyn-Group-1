package com.epam.jmp.factory.factorymethod;

import java.sql.PreparedStatement;

import com.epam.jmp.factory.model.Person;

public class DBDataHandler extends AbstractDataHandler {

	@Override
	public	void writePerson(Person person) {	
		PreparedStatement pstmt = resource.connection.prepareStatement(WRITE_OBJECT_SQL);

	    // set input parameters
	    pstmt.setString(1, className);
	    pstmt.setObject(2, object);
	    pstmt.executeUpdate();

	    // get the generated key for the id
	    ResultSet rs = pstmt.getGeneratedKeys();
	    int id = -1;
	    if (rs.next()) {
	      id = rs.getInt(1);
	    }

	    rs.close();
	    pstmt.close();
	    System.out.println("writeJavaObject: done serializing: " + className);
	}

	@Override
	public	Person readPerson() {
		return null;
	}

	@Override
	public Person readPerson(String name) {
		return null;
	}

}
