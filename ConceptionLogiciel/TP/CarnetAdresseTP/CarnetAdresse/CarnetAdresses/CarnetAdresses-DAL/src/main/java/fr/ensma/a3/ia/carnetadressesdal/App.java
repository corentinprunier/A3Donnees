package fr.ensma.a3.ia.carnetadressesdal;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdal.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdal.dao.AdresseSqlDAO;
import fr.ensma.a3.ia.carnetadressesdal.dao.ContactPoiDAO;
import fr.ensma.a3.ia.carnetadressesdal.dao.ContactSqlDAO;
import fr.ensma.a3.ia.carnetadressesdal.dao.Dao;
import fr.ensma.a3.ia.carnetadressesdal.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdal.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactEntity;
import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactRiche;

/**
 * Test Dao
 *
 * @author Mikky Richard
 */
public class App {
    public static void main(String[] args) {


//    	IDao<AdresseEntity> adrdao = new AdresseSqlDAO();
//    	AdresseEntity adrajout = new AdresseEntity();
//        adrajout.setNumRue(2);
//        adrajout.setNomRue("toumoche");
//        adrajout.setCodePostal(97000);
//        adrajout.setNomVille("PythonVille");
//        System.out.println("Création de l'élément : " + adrajout);
//    	adrdao.create(adrajout);
//    	
//    	System.out.println("Éléments dans la base Adresses:");
//        List<AdresseEntity> alladr = adrdao.getAll();
//        for (AdresseEntity ad : alladr) {
//            System.out.println(ad);
//        }
    	
    	IDao<ContactEntity> persdao = new ContactSqlDAO();

    	ContactEntity persajout = new ContactEntity();
    	persajout.setNom("Caulet");
        persajout.setPrenom("Justine");
        persajout.setIdAdr(1);
        System.out.println("Création de l'élément : " + persajout);

        persdao.create(persajout);
    	
    	
    	System.out.println("Éléments dans la base Contact:");
        List<ContactEntity> allpers = persdao.getAll();
        for (ContactEntity ad : allpers) {
            System.out.println(ad);
        }

//        AdresseEntity adrajout2 = new AdresseEntity();
//        adrajout2.setNumRue(10);
//        adrajout2.setNomRue("toumoches");
//        adrajout2.setCodePostal(97000);
//        adrajout2.setNomVille("PitonVille");
//        System.out.println("Création de l'élément : " + adrajout2);
//    	adrdao.create(adrajout2);
//    	System.out.println(adrajout2);
//    	
//        System.out.println("Éléments dans la base :");
//        alladr = adrdao.getAll();
//        for (AdresseEntity ad : alladr) {
//            System.out.println(ad);
//        }
//        
//        adrajout2.setNomVille("PythonVille");
//        System.out.println("Update du nom de la ville");
//        adrdao.update(adrajout2);
//        
//        System.out.println("Éléments dans la base :");
//        alladr = adrdao.getAll();
//        for (AdresseEntity ad : alladr) {
//            System.out.println(ad);
//        }
//
//        System.out.println("Suppression de l'élément id = 3");
//        adrdao.delete(adrdao.getById(3).get());
//        System.out.println("Éléments dans la base :");
//        alladr = adrdao.getAll();
//        for (AdresseEntity ad : alladr) {
//            System.out.println(ad);
//        }
//        System.out.println("\n");
        
//        
//        

        ContactEntity perscherche = new ContactEntity();
        perscherche.setNom("RICHARD");
        perscherche.setPrenom("Michael");
        perscherche.setIdAdr(0);
        System.out.println("Recherche par valeur de l'élément : " + perscherche);
        Optional<ContactEntity> res2 = persdao.getByValue(perscherche);
        if (res2.isPresent()) {
            System.out.println(res2.get());
        }
        System.out.println("Recherche par id de l'élément : id=1 ");
        res2 = persdao.getById(1);
        if (res2.isPresent()) {
            System.out.println(res2.get());
        }
        ContactEntity persajout2 = new ContactEntity();
        persajout2.setNom("ISAE");
        persajout2.setPrenom("NSMA");
//        persajout.setIdAdr(3);
        System.out.println("Création de l'élément : " + persajout2);
        persdao.create(persajout2);
        
        System.out.println("Éléments dans la base :");
        allpers = persdao.getAll();
        for (ContactEntity pers : allpers) {
            System.out.println(pers);
        }
        
        persajout2.setPrenom("ENSMA");
        System.out.println("Update du prenom");
        persdao.update(persajout2);
        System.out.println("Éléments dans la base :");
        allpers = persdao.getAll();
        for (ContactEntity pers : allpers) {
            System.out.println(pers);
        }

        System.out.println("Suppression de l'élément id = 3");
        persdao.delete(persdao.getById(3).get());
        System.out.println("Éléments dans la base :");
        allpers = persdao.getAll();
        for (ContactEntity pers : allpers) {
            System.out.println(pers);
        }
        System.out.println("\n");
        
//        
//        
//        
//        System.out.println("Éléments dans la DAO global:");
//        IDao<ContactRiche> contdao = new Dao(persdao,adrdao);
//        List<ContactRiche> allcont = contdao.getAll();
//        for (ContactRiche cont : allcont) {
//            System.out.println(cont);
//        }
//        ContactRiche contcherche = new ContactRiche();
//        contcherche.setAdresse(adcherche);
//        contcherche.setPersonne(perscherche);
//
//        System.out.println("Recherche par valeur de l'élément : " + contcherche);
//        Optional<ContactRiche> res3 = contdao.getByValue(contcherche);
//        if (res3.isPresent()) {
//            System.out.println(res3.get());
//        }
//        System.out.println("Recherche par id de l'élément : id=1 ");
//        res3 = contdao.getById(1);
//        if (res3.isPresent()) {
//            System.out.println(res3.get());
//        }
//        ContactRiche contajout = new ContactRiche();
//        contajout.setAdresse(adrajout);
//        contajout.setPersonne(persajout);
//        System.out.println("Création de l'élément : " + contajout);
//        contdao.create(contajout);
//        System.out.println("Update du Contact");
//        
//        contajout.setNomVille("Pulversheim");
//        contdao.update(contajout);
//        System.out.println("Éléments dans la DAO globale :");
//        allcont = contdao.getAll();
//        for (ContactRiche cont : allcont) {
//            System.out.println(cont);
//        }
//        System.out.println("Ajout d'un élément déjà en base :");
//        contdao.create(contajout);
//        System.out.println("Suppression de l'élément id = 3");
//        contdao.delete(contdao.getById(3).get());
//        System.out.println("Éléments dans la base :");
//        allcont = contdao.getAll();
//        for (ContactRiche cont : allcont) {
//            System.out.println(cont);
//        }
//        System.out.println("\n");
    }
}
