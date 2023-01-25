package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.objets.Catapulte;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.map.ECouleur;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Test de la classe Ouvrier
 */
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestOuvrier {

    private Ouvrier hodor, ouv1;
    // Normalement pas à faire dans le cadre des tests unitaires
    private Base bse;
    // A la place utilisation d'une doublure
    @Mock
    Base mockBse;
    
    @BeforeEach
    public void initEach() throws ValParamException {
        bse = new Base("B", ECouleur.rouge);
        hodor = new Ouvrier(200f, bse, 500, "Hodor");
    }

    @AfterEach
    public void afterEach() {
        hodor = null;
        bse = null;
        System.gc();
    }

    @Test
    public void t01_testConstructeur() {
        assertAll(() -> assertEquals("Hodor", hodor.getIdentPerso()), () -> assertEquals(200f, hodor.getNivVie()),
                () -> assertEquals(500, hodor.getPuissTravail()), () -> assertEquals(bse, hodor.getLaBase()));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, null, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, 500, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, 500, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, 500, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, 500, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, 500, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, 500, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null, "Hodor"));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, 500, null));
    }

    @Test
    public void t02_testConstructeur() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse, 300);
        assertAll(() -> assertEquals("Ouvrier3", ouv1.getIdentPerso()), () -> assertEquals(200f, ouv1.getNivVie()),
                () -> assertEquals(300, ouv1.getPuissTravail()), () -> assertEquals(bse, ouv1.getLaBase()));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null));
    }

    @Test
    public void t03_testToString() {
        assertEquals("Ouvrier : " + hodor.getIdentPerso() + " - Niv Vie : " + hodor.getNivVie() + " - P Travail : "
                + hodor.getPuissTravail(), hodor.toString());
    }

    @Test
    public void t04_testEstAttaque() {
        int patt = 150;
        Float nvie_avant = hodor.getNivVie();
        hodor.estAttaque(patt);
        assertEquals(nvie_avant - patt / 15, hodor.getNivVie());
    }

    @Test
    public void t05_testEqual() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse, 500, "Hodor");
        assertTrue(hodor.equals(hodor));
        assertTrue(hodor.equals(ouv1));
        assertFalse(hodor.equals(null));
        assertFalse(hodor.equals(Integer.valueOf(0)));
        assertFalse(hodor.equals(new Catapulte(200f, bse, 800)));
        assertFalse(hodor.equals(new Guerrier(200f, bse, 500, "Hodor")));
        // Attention à l'égalité de Base -> Test Intégration
        Base bse2 = new Base("B", ECouleur.rouge);
        ouv1 = new Ouvrier(200f, bse2, 500, "Hodor");
        assertFalse(hodor.equals(ouv1));
        ouv1 = new Ouvrier(250f, bse, 500, "Hodor");
        assertFalse(hodor.equals(ouv1));
        ouv1 = new Ouvrier(200f, bse, 200, "Hodor");
        assertFalse(hodor.equals(ouv1));
        ouv1 = new Ouvrier(200f, bse, 500, "Bob");
        assertFalse(hodor.equals(ouv1));
        bse = new Base("BB", ECouleur.jaune);
        ouv1 = new Ouvrier(200f, bse, 500, "Hodor");
        assertFalse(hodor.equals(ouv1));
    }

    @Test
    public void t06_testHashCode() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse, 500, "Hodor");
        assertEquals(hodor.hashCode(), hodor.hashCode());
        assertEquals(ouv1.hashCode(), hodor.hashCode());
        //Suite Optionnelle car on ne demande pas un hashage parfait
        ouv1 = new Ouvrier(250f, bse, 500, "Hodor");
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        ouv1 = new Ouvrier(200f, bse, 200, "Hodor");
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        ouv1 = new Ouvrier(200f, bse, 500, "Bob");
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        bse = new Base("BB", ECouleur.jaune);
        ouv1 = new Ouvrier(200f, bse, 500, "Hodor");
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
    }
    
    @Test
    public void t07_testConstructeur_Inte() throws ValParamException {
    	ouv1 = new Ouvrier(200f, mockBse, 500, "Hodor");
    	verify(mockBse,times(1)).addElementJeu(ouv1);
    }
    
    
}
