package fr.ensma.a3.ia.carnetadressesdal.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdal.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactEntity;
import fr.ensma.a3.ia.carnetadressesdal.dao.entity.ContactRiche;

public class Dao extends AbstractPoiDAO<ContactRiche> {
	
	
	private IDao<ContactEntity> pers;
	private IDao<AdresseEntity> adr;

	
	public Dao(final IDao<ContactEntity> per, final IDao<AdresseEntity> ad) {
		pers = per;
		adr = ad;
	}

    @Override
    public Optional<ContactRiche> getById(int id) {
    	
    	if (pers.getById(id).isEmpty()) {
    		return Optional.empty();
    	} else {
    		ContactEntity personne = pers.getById(id).get();
    		List<AdresseEntity> listeadr = adr.getAll();
    		ContactRiche elem = new ContactRiche();
    		elem.setPersonne(personne);
    		elem.setAdresse(listeadr.get(personne.getIdAdr()-1));
    		return Optional.of(elem);
    	}
    }
       

    
    @Override
    public Optional<ContactRiche> getByValue(ContactRiche elem) {
        List<ContactRiche> listtemp = getAll();
        for (ContactRiche pers : listtemp) {
            if (pers.equals(elem)) {
                return Optional.of(pers);
            }
        }
        return Optional.empty();
    }

    
    
    
    
    @Override
    public List<ContactRiche> getAll() {
    	
    	List<ContactEntity> listepers = pers.getAll();
    	List<AdresseEntity> listeadr = adr.getAll();
    	
    	ContactRiche elem;
    	ArrayList<ContactRiche> listecont = new ArrayList<ContactRiche>();
    	for (int i=0;i<listepers.size();i++) {
    		ContactEntity personne = listepers.get(i);
    		AdresseEntity adresse = listeadr.get(personne.getIdAdr()-1);
    		elem  = new ContactRiche();
    		elem.setAdresse(adresse);
    		elem.setPersonne(personne);
    		listecont.add(elem);
    	}
    	return listecont;
    }

    @Override
    public void create(ContactRiche elem) {
    	if (elem.getAdresse() != null)
			adr.create(elem.getAdresse());
			elem.setIdAdr(adr.getByValue(elem.getAdresse()).get().getIdAdr());
		pers.create(elem.getPersonne());
    }
    
    @Override
    public void update(ContactRiche elem) {
    	adr.update(elem.getAdresse());
    	// elem.setIdAdr(adr.getByValue(elem.getAdresse()).get().getIdAdr()); 
    	// ça dépend si on considère que l'id a déjà été créé en amont comme lors de la création par exemple
    	pers.update(elem.getPersonne());
    }
    

    @Override
    public void delete(ContactRiche elem) {
    	pers.delete(elem.getPersonne());
    	List<ContactRiche> listtemp = getAll();
    	for (ContactRiche cont : listtemp) {
            if (cont.getPersonne().getIdAdr() == elem.getAdresse().getIdAdr()) {
                return ;
            }
        }
    	adr.delete(elem.getAdresse());
    }
	
}
