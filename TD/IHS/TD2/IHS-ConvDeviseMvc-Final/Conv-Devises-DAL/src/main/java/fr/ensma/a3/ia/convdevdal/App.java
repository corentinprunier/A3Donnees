package fr.ensma.a3.ia.convdevdal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.convdevdal.dao.EntityTauxDevises;
import fr.ensma.a3.ia.convdevdal.dao.IDao;
import fr.ensma.a3.ia.convdevdal.dao.TauxDevisesDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	Connection conn = null;
    	Statement stmt;
    	ResultSet rs;
    	String sql;
    	
    	try {
    		//createTables();
    		insertData();
    		
    		conn = DriverManager.getConnection("jdbc:sqlite:/home/richardm/Conv.db");
    		stmt = conn.createStatement();
    		sql = "SELECT * FROM Taux_Devises";
    		rs = stmt.executeQuery(sql);    		
    		while (rs.next()) {
    			System.out.println( "Id = " + rs.getString("ID") + " Name = " + rs.getString("NAME") 
    						+ " Taux = " + rs.getFloat("TAUX"));
    		}
    		rs.close();
    		stmt.close();
    		conn.close();
    		
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		System.exit(0);
    	}*/
    	
    	IDao<EntityTauxDevises> dao_devises = new TauxDevisesDao();
    	List<EntityTauxDevises> liste_devises = dao_devises.getAll();
    	for (EntityTauxDevises devi : liste_devises) {
			System.out.println(devi);
		}
    	EntityTauxDevises livre_st = new EntityTauxDevises();
    	livre_st.setId("LIVS_EUR");
    	livre_st.setLabel("Livre Sterling -> Euro");
    	livre_st.setTauxConversion(1.16f);
    	if ((dao_devises.getById(livre_st.getId()).isEmpty())) {
    		dao_devises.save(livre_st);
    	} else {
    		System.out.println("Existe Déjà !!");
    	}
    	liste_devises = dao_devises.getAll();
    	for (EntityTauxDevises devi : liste_devises) {
			System.out.println(devi);
		}
    	
    	
    	
    }
    
    private static void insertData() {
    	Connection conn;
    	Statement stmt;
    	String sql;
    	
    	try {
    		conn = DriverManager.getConnection("jdbc:sqlite:/home/richardm/Conv.db");
    		stmt = conn.createStatement();
    		sql = "INSERT INTO Taux_Devises (ID,NAME,TAUX) VALUES ('DOL_EUR','Dollar -> Euro', 0.96);";
    		stmt.execute(sql);
    		sql = "INSERT INTO Taux_Devises (ID,NAME,TAUX) VALUES ('EUR_DOL','Euro -> Dollar', 1.04);";
    		stmt.execute(sql);
    				
    		stmt.close();
    		conn.close();
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		System.exit(0);
    	}
    }
    
    private static void createTables() {
    	Connection conn;
    	Statement stmt;
    	String sql;
    	
    	try {
    		conn = DriverManager.getConnection("jdbc:sqlite:/home/richardm/Conv.db");
    		stmt = conn.createStatement();
    		sql = "CREATE TABLE Taux_Devises ("
    				+ "ID VARCHAR(15) PRIMARY KEY NOT NULL,"
    				+ "NAME TEXT NOT NULL,"
    				+ "TAUX REAL NOT NULL"
    				+ ");";
    		stmt.execute(sql);
    		stmt.close();
    		conn.close();
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		System.exit(0);
    	}
    }
    
    
}
