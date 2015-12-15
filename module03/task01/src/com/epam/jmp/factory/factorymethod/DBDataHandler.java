package com.epam.jmp.factory.factorymethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.jmp.factory.model.Person;
import com.epam.jmp.factory.model.DBResource;

public class DBDataHandler extends AbstractDataHandler {

	private static final String SQL_QUERY_WRITE_OBJECT = "INSERT INTO persons (?,?)";
	private static final String SQL_QUERY_SELECT_OBJECT_BY_NAME = "SELECT * FROM persons WHERE name = ?";
	private static final String SQL_QUERY_SELECT_FIRST = "SELECT * FROM persons WHERE ROWNUM <= number";

	@Override
	public void writePerson(Person person) {

		PreparedStatement pstmt;
		try {
			pstmt = ((DBResource) resource).getConnection().prepareStatement(SQL_QUERY_WRITE_OBJECT);
			pstmt.setObject(1, person);
			pstmt.setString(2, person.getName());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person readPerson() {
		PreparedStatement pstmt;
		Person person = null;
		try {
			pstmt = ((DBResource) resource).getConnection().prepareStatement(SQL_QUERY_SELECT_FIRST);
			ResultSet rs = pstmt.executeQuery();
			person = new Person();
			rs.next();
			person.setName(rs.getString("name"));
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public Person readPerson(String name) {
		PreparedStatement pstmt;
		Person person = null;
		try {
			pstmt = ((DBResource) resource).getConnection().prepareStatement(SQL_QUERY_SELECT_OBJECT_BY_NAME);
			ResultSet rs = pstmt.executeQuery();
			person = new Person();
			rs.next();
			person.setName(rs.getString("name"));
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

}
