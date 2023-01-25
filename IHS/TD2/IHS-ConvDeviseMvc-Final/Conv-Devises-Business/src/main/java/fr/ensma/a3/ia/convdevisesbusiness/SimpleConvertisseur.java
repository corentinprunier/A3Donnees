package fr.ensma.a3.ia.convdevisesbusiness;

public class SimpleConvertisseur implements ISimpleConvertisseur {

	private static ISimpleConvertisseur singleInstance;
	private static double EURO_TO_DOLLAR = 1.04;
	private static double DOLLAR_TO_EURO = 0.96;
	
	
	private SimpleConvertisseur() {} 
	
	public static ISimpleConvertisseur getConvertisseur() {
		if (singleInstance == null) {
			singleInstance = new SimpleConvertisseur();
		}
		return singleInstance;
	}
		
	@Override
	public Double convertEuroToDollar(Double valeuro) {
		return valeuro * EURO_TO_DOLLAR;
	}

	@Override
	public Double convertDollarToEuro(Double valdollar) {
		return valdollar * DOLLAR_TO_EURO;
	}

}
