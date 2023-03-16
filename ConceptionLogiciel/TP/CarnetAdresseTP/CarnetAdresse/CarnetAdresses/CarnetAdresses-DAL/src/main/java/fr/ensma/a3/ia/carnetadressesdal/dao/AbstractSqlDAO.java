package fr.ensma.a3.ia.carnetadressesdal.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public abstract class AbstractSqlDAO<T> implements IDao<T> {

	
    private Connection connection = null;
    private Statement statement = null;
    private String FILE__NAME_PROP;
 
    public AbstractSqlDAO() {
    	Properties dbprops = new Properties();
        try {
            dbprops.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            FILE__NAME_PROP = System.getProperty("user.dir") + dbprops.getProperty("sqlpath");
            System.out.println(FILE__NAME_PROP);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public Connection openBase() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + FILE__NAME_PROP);
            System.out.println("Connexion a " + FILE__NAME_PROP + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }
        return connection;
    }
    
    
    public void createTable(String data, Connection connection) {
    	String request = "CREATE TABLE IF NOT EXISTS ";
    	try {
            statement = connection.createStatement();
        	statement.executeUpdate(request+data);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    

    public Boolean tableExist(String nomTable, Connection connection) {
    	try {
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, nomTable, null);
            if(rs.next()){
              System.out.println("Table exists");
              return true;
            }else{
              System.out.println("Table does not exist");
              return false;
            }
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}

    }
    
	
    protected void writeBase(String insertSQL, Connection connection) {
        try {
        	statement = connection.createStatement();
        	statement.executeUpdate(insertSQL);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    protected void removeBase(String deleteSQL,  Connection connection) {
        try {
        	statement = connection.createStatement();
        	statement.executeUpdate(deleteSQL);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public ResultSet query(String requet,  Connection connection) {
        ResultSet resultat = null;
        try {
        	statement = connection.createStatement();
            resultat = statement.executeQuery(requet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requet : " + requet);
        }
        return resultat;
  
    }
    
 
    public void closeBase(Connection connection) {
        try {
        	statement = connection.createStatement();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
	
