package fr.ensma.a3.ia.jeupersonnagesv1.map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.IElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Test de la classe {@link Base}
 **/
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    public void testConstructeur() {
        assertAll(() -> assertEquals("Base", baseTest.getNomBase()),
                () -> assertEquals(ECouleur.bleu, baseTest.getCoulBase()), () -> assertEquals(0, baseTest.getNbElem()));
        assertThrows(ValParamException.class, () -> new Base(null, ECouleur.rouge));
        assertThrows(ValParamException.class, () -> new Base("B", null));
        assertThrows(ValParamException.class, () -> new Base(null, null));
    }

    @Test
    @Order(2)
    public void testToString() {
        assertEquals("Base " + baseTest.getNomBase() + ": " + baseTest.getCoulBase() + "\n" + "Éléments jeu :\n",
                baseTest.toString());
    }

    @Mock
    ArrayList<IElementJeu> mockElem;

    @Test
    @Order(3)
    public void testAddElement_Inte() {
        //Utilisation de la reflexion Java
        Field felem = baseTest.getClass().getDeclaredFields()[2];
        felem.setAccessible(true);
        try {
            felem.set(baseTest, mockElem);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        when(mockElem.size()).thenReturn(1, 2);
        baseTest.addElementJeu(elem1);
        assertEquals(1, baseTest.getNbElem());
        baseTest.addElementJeu(elem2);
        assertEquals(2, baseTest.getNbElem());
        ArgumentCaptor<IElementJeu> args = ArgumentCaptor.forClass(IElementJeu.class);
        verify(mockElem, times(2)).add(args.capture());
        assertTrue(args.getAllValues().get(0) == elem1);
        assertTrue(args.getAllValues().get(1) == elem2);
    }

    @Test
    @Order(4)
    public void testToStringInte() {
        baseTest.addElementJeu(elem1);
        baseTest.addElementJeu(elem2);
        when(elem1.toString()).thenReturn("Elem1");
        when(elem2.toString()).thenReturn("Elem2");
        String res = baseTest.toString();
        // verify(elem1, times(1)).toString();
        // verify(elem2, times(1)).toString();
        assertEquals("Base " + baseTest.getNomBase() + ": " + baseTest.getCoulBase() + "\n" + "Éléments jeu :\n"
                + "--> Elem1\n--> Elem2\n", res);
    }

}
