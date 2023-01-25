package fr.ensma.a3.ia.convdevisesbusinessapi;

import fr.ensma.a3.ia.convdevisesbusiness.ISimpleConvertisseur;
import fr.ensma.a3.ia.convdevisesbusiness.SimpleConvertisseur;

public class FabriqueConvertisseur {

	public IBaseConvertisseur fabriqueBaseConvertisseur() {
		IBaseConvertisseur conv = new BaseConvertisseur();
		return conv;
	}
	
	private class BaseConvertisseur implements IBaseConvertisseur {

		private ISimpleConvertisseur conv;
		
		public BaseConvertisseur() {
			conv = SimpleConvertisseur.getConvertisseur();
		}
		
		@Override
		public Double convertEuroToDollar(Double valeuro) {
			return conv.convertEuroToDollar(valeuro);
		}

		@Override
		public Double convertDollarToEuro(Double valdollar) {
			return conv.convertDollarToEuro(valdollar);
		}
		
	}
}
