package fr.ensma.a3.ia.carnetadressesdal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactEntity;

public class ContactSqlDAO extends AbstractSqlDAO<ContactEntity> {
	
	private static Logger LOGGER = Logger.getLogger(ContactSqlDAO.class.getName());

    @Override
    public Optional<ContactEntity> getById(int id) {
        Connection connection = openBase();
        String request = "SELECT * FROM Contact WHERE idPers =" + id;
        ResultSet result = query(request,connection);
        try {
            if (result.next()) {
            	ContactEntity pers = new ContactEntity();
            	pers.setIdPers(result.getInt("idPers"));
            	pers.setIdAdr(result.getInt("idAdr"));
            	pers.setNom(result.getString("nom"));
            	pers.setPrenom(result.getString("prenom"));
                closeBase(connection);
                return Optional.of(pers);
            }
        } catch (SQLException e){
        	e.printStackTrace();
        }

        closeBase(connection);
        return Optional.empty();
    }
    
    

    @Override
    public Optional<ContactEntity> getByValue(ContactEntity elem) {
        List<ContactEntity> listtemp = getAll();
        for (ContactEntity pers : listtemp) {
            if (pers.equals(elem)) {
                return Optional.of(pers);
            }
        }
        return Optional.empty();
    }
    
    

    @Override
    public List<ContactEntity> getAll() {
    	Connection connection = openBase();
        ArrayList<ContactEntity> listepers = new ArrayList<ContactEntity>();
        ResultSet result = query("SELECT * FROM Contact",connection);
        try {
            while (result.next()) {
            	ContactEntity pers = new ContactEntity();
            	pers.setIdPers(result.getInt("idPers"));
            	pers.setIdAdr(result.getInt("idAdr"));
            	pers.setNom(result.getString("nom"));
            	pers.setPrenom(result.getString("prenom"));
                listepers.add(pers);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        closeBase(connection);
        return listepers;
    }


    
    
    
    @Override
    public void create(ContactEntity elem) {
    	Connection connection = openBase();
    	List<ContactEntity> listtemp = getAll();
    	if (tableExist("Contact",connection)==false) {
    		createTable("Contact (idPers INTEGER PRIMARY KEY, nom TEXT, prenom TEXT, idAdr INTEGER)",connection);
    	}
    	if (getByValue(elem).isEmpty()) {
    		elem.setIdPers(listtemp.size());
        	String request = "INSERT INTO Contact (idPers, nom, prenom, idAdr)"
        			+ " VALUES (" + elem.getIdPers() + ", '"+ elem.getNom() + "', '" + elem.getPrenom() + "', " + elem.getIdAdr() + ")";
            writeBase(request,connection);

        } else {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact deja dans la base ...");
        }
        closeBase(connection);
    }
    
    
    

    @Override
    public void update(ContactEntity elem) {
        if (getByValue(elem).isEmpty()) {
    		Connection connection = openBase();
        	ResultSet result = query("SELECT * FROM Contact WHERE idAdr = " + elem.getIdAdr(),connection);
        	try {
            	if (result.next()) {
    	            String request = "UPDATE Contact SET nom = '" + elem.getNom() + "', prenom = '"
    	            		+ elem.getPrenom() + "', idAdr = " + elem.getIdAdr() + " WHERE idPers = " + elem.getIdPers();
    	            writeBase(request,connection);
            	} else {
            		// TODO : Prévoir une exception ...
            		LOGGER.log(Level.INFO, "Contact absent de la base ...");
            	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        	closeBase(connection);
        } else {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact Deja dans la base ...");
        }
    }

    
    
    
    @Override
    public void delete(ContactEntity elem) {
        
        if (!getByValue(elem).isEmpty()) {
        	Connection connection = openBase();
        	String request = "DELETE FROM Contact WHERE idPers = " + elem.getIdPers();
        	removeBase(request,connection);
            closeBase(connection);
        }
        else {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact absent de la base ...");
        }

    }

}

