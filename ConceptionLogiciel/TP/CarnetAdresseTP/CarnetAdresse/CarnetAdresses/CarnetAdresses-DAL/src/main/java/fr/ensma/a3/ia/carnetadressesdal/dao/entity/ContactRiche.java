package fr.ensma.a3.ia.carnetadressesdal.dao.entity;

public class ContactRiche {
	
	private ContactEntity personne;
	private AdresseEntity adresse;    
	
	
	
	public ContactRiche() {

	}
	
	public final ContactEntity getPersonne() {
		return personne;
	}
	
	public final AdresseEntity getAdresse() {
		return adresse;
	}
	
	public final void setPersonne(final ContactEntity pers) {
		personne = pers;
	}
	
	public final void setAdresse(final AdresseEntity adr) {
		adresse = adr;
	}
	
	public final String getNom() {
		return personne.getNom();
	}
	
	
	public final String getPrenom() {
		return personne.getPrenom();
	}
	
	public final int getNumRue() {
		return adresse.getNumRue();
	}
	
	public final String getNomRue() {
		return adresse.getNomRue();
	}
	
	public final String getNomVille() {
		return adresse.getNomVille();
	}
	
	public final void setNomVille(final String nom) {
		adresse.setNomVille(nom);
	}
	
	public final int getCodePostal() {
		return adresse.getCodePostal();
	}
	
	public final void setIdAdr(final int id) {
		personne.setIdAdr(id);
	}
	
	@Override
    public String toString() {
        return personne.getNom() + " " + personne.getPrenom() + " : " + adresse.getNumRue() +
        		" " + adresse.getNomRue() + " - " + adresse.getCodePostal() + " " + adresse.getNomVille();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactRiche)) {
            return false;
        } else {
        	ContactRiche cont = (ContactRiche) obj;
            if ((cont.getPersonne().equals(personne)) && (cont.getAdresse().equals(adresse))) {
            	System.out.println("égal");
                return true;
            } else {
            	System.out.println("pas egal");
                return false;
            }
        }
    }
    
    @Override
    public int hashCode() {
    	int hash = 1;
    	hash = hash*31 + (personne == null ? 0 : personne.hashCode());
    	hash = hash*23 + (adresse == null ? 0 : adresse.hashCode());
    	return hash;
    }

}
