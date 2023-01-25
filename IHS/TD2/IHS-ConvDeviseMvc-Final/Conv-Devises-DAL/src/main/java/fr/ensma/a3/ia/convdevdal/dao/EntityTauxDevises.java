package fr.ensma.a3.ia.convdevdal.dao;

public class EntityTauxDevises {

	private String id;
	private String label;
	private float tauxConversion;
	
	public final String getId() {
		return id;
	}

	public final void setId(final String ident) {
		id = ident;
	}

	public final String getLabel() {
		return label;
	}
	public final void setLabel(final String lab) {
		label = lab;
	}
	
	public final Float getTauxConversion() {
		return tauxConversion;
	}
	public final void setTauxConversion(final float taux) {
		tauxConversion = taux;
	}
	
	@Override
	public String toString() {
		return "[" + id +","+ label + "," + tauxConversion + "]";		
	}
}
