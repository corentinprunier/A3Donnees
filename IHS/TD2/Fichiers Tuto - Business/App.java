package fr.ensma.a3.ia.convdevisesbusiness;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ISimpleConvertisseur le_conv = SimpleConvertisseur.getConvertisseur();
        
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        System.out.println("Donner une valeur en euro :");
        double val = console.nextDouble();
        System.out.println("Resultat = " + le_conv.convertEuroToDollar(val));
    }
}
