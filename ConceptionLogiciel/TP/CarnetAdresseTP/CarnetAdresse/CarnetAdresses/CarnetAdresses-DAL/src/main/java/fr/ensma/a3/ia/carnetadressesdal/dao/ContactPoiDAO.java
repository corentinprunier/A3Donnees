package fr.ensma.a3.ia.carnetadressesdal.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactEntity;

public class ContactPoiDAO extends AbstractPoiDAO<ContactEntity> {
	
	private static Logger LOGGER = Logger.getLogger(AdressePoiDAO.class.getName());

    @Override
    public Optional<ContactEntity> getById(int id) {
        XSSFWorkbook bdd = openBase();
        Sheet tablepers = bdd.getSheet("Personnes");
        Iterator<Row> iterator = tablepers.iterator();
        iterator.next();
        boolean trouve = false;
        ContactEntity pers = null;
        while (iterator.hasNext() && !trouve) {
            Row ligne = iterator.next();
            pers = new ContactEntity();
            if (id == (int) ligne.getCell(0).getNumericCellValue()) {
            	pers.setIdPers((int) ligne.getCell(0).getNumericCellValue());
                pers.setNom(ligne.getCell(1).getStringCellValue());
                pers.setPrenom(ligne.getCell(2).getStringCellValue());
                pers.setIdAdr((int) ligne.getCell(3).getNumericCellValue());
                trouve = true;
            }
        }
        if (trouve) {
            closeBase(bdd);
            return Optional.of(pers);
        }
        closeBase(bdd);
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
        XSSFWorkbook bdd = openBase();
        Sheet tablepers = bdd.getSheet("Personnes");
        ArrayList<ContactEntity> listepers = new ArrayList<ContactEntity>();
        Iterator<Row> iterator = tablepers.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row ligne = iterator.next();
            ContactEntity pers = new ContactEntity();
            Iterator<Cell> cellIterator = ligne.iterator();
            Cell cellule = cellIterator.next();
            pers.setIdPers((int) cellule.getNumericCellValue());
            pers.setNom(ligne.getCell(1).getStringCellValue());
            pers.setPrenom(ligne.getCell(2).getStringCellValue());
            pers.setIdAdr((int) ligne.getCell(3).getNumericCellValue());
            listepers.add(pers);
        }
        closeBase(bdd);
        return listepers;
    }

    @Override
    public void create(ContactEntity elem) {
        if (getByValue(elem).isEmpty()) {
            XSSFWorkbook bdd = openBase();
            Sheet tablepers = bdd.getSheet("Personnes");
            int lrow = tablepers.getLastRowNum();
            int lid = (int) tablepers.getRow(lrow).getCell(0).getNumericCellValue();
            elem.setIdPers(lid + 1);
            Row ligne = tablepers.createRow(lrow + 1);
            Cell cell = ligne.createCell(0);
            cell.setCellValue(elem.getIdPers());
            cell = ligne.createCell(1);
            cell.setCellValue(elem.getNom());
            cell = ligne.createCell(2);
            cell.setCellValue(elem.getPrenom());
            cell = ligne.createCell(3);
            cell.setCellValue(elem.getIdAdr());
            writeBase(bdd);
            closeBase(bdd);
        } else {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact deja dans la base ...");
        }
    }

    @Override
    public void update(ContactEntity elem) {
        if (getByValue(elem).isEmpty()) {
            XSSFWorkbook bdd = openBase();
            Sheet tablepers = bdd.getSheet("Personnes");
            Iterator<Row> iterator = tablepers.iterator();
            iterator.next();
            boolean trouve = false;
            while (iterator.hasNext() && !trouve) {
                Row ligne = iterator.next();
                if (elem.getIdPers() == (int) ligne.getCell(0).getNumericCellValue()) {
                    trouve = true;
                    ligne.getCell(1).setCellValue(elem.getNom());
                    ligne.getCell(2).setCellValue(elem.getPrenom());
                    ligne.getCell(3).setCellValue(elem.getIdAdr());
                    writeBase(bdd);
                }
            }
            if (!trouve) {
                // TODO : Prévoir une exception ...
                LOGGER.log(Level.INFO, "Contact absent de la base ...");
            }
            closeBase(bdd);
        } else {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact Deja dans la base ...");
        }
    }

    @Override
    public void delete(ContactEntity elem) {
        XSSFWorkbook bdd = openBase();
        Sheet tableadr = bdd.getSheet("Personnes");
        Iterator<Row> iterator = tableadr.iterator();
        iterator.next();
        boolean trouve = false;
        while (iterator.hasNext() && !trouve) {
            Row ligne = iterator.next();
            if (elem.getIdPers() == (int) ligne.getCell(0).getNumericCellValue()) {
                trouve = true;
                removeRow(tableadr, ligne.getRowNum());
                writeBase(bdd);
            }
        }
        if (!trouve) {
            // TODO : Prévoir une exception ...
            LOGGER.log(Level.INFO, "Contact absent de la base ...");
        }
        closeBase(bdd);
    }

}
