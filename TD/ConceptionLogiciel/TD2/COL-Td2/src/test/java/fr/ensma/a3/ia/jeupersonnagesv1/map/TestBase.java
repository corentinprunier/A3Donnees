package fr.ensma.a3.ia.jeupersonnagesv1.map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.IElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Test de la classe {@link Base}
 **/
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests Base.java")
public class TestBase {

    private Base baseTest;

    @Mock
    IElementJeu elem1, elem2;
    
    @BeforeEach
    public void initEach() throws ValParamException {
        baseTest = new Base("Base", ECouleur.bleu);
    }

    @AfterEach
    public void freeEach() {
        baseTest = null;
        System.gc();
    }

    @Test
    public void testConstructeur() {
        assertAll(() -> assertEquals("Base", baseTest.getNomBase()),
                () -> assertEquals(ECouleur.bleu, baseTest.getCoulBase()), () -> assertEquals(0, baseTest.getNbElem()));
        assertThrows(ValParamException.class, () -> new Base(null, ECouleur.rouge));
        assertThrows(ValParamException.class, () -> new Base("B", null));
        assertThrows(ValParamException.class, () -> new Base(null, null));
    }

    @Test
    public void testToString() {
        assertEquals("Base " + baseTest.getNomBase() + ": " + baseTest.getCoulBase() + "\n" + "Éléments jeu :\n",
                baseTest.toString());
    }
    
    @Test
    public void test_ToString_Inte() {
    	baseTest.addElementJeu(elem1);
    	baseTest.addElementJeu(elem2);
    	when(elem1.toString()).thenReturn("Elem 1");
    	when(elem2.toString()).thenReturn("Elem 2");
    	assertEquals("Base " + baseTest.getNomBase() + ": " + 
    			baseTest.getCoulBase() + "\n" + "Éléments jeu :\n" +
    			"--> Elem 1\n--> Elem 2\n",
                baseTest.toString());

    }
    
    @Test
    public void test_addElement() {
    	baseTest.addElementJeu(elem1);
    	assertEquals(1,baseTest.getNbElem());
    	baseTest.addElementJeu(elem2);
    	assertEquals(2,baseTest.getNbElem());
    }
}

