package com.epam.jmp.factory.factorymethod;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epam.jmp.factory.model.Person;
import com.epam.jmp.factory.model.DBResource;

public class DBDataHandler extends AbstractDataHandler {

	private static final String SQL_QUERY_WRITE_OBJECT = "";

	@Override
	public void writePerson(Person person) {

		PreparedStatement pstmt;
		try {
			pstmt = ((DBResource) resource).getConnection().prepareStatement(SQL_QUERY_WRITE_OBJECT);
			pstmt.setObject(1, person);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person readPerson() {
		return null;
	}

	@Override
	public Person readPerson(String name) {
		return null;
	}

}
