package fr.ensma.a3.ia.convdevdal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao<T> implements IDao<T> {

	private static final String URL = "jdbc:sqlite:/home/richardm/Conv.db";
	
	public final Connection connectDB() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public final void closeDB(final Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
