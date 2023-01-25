package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaquableTerre;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Test de la classe Guerrier
 */
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestGuerrier {

    private Guerrier jSnow;

    @Mock
    private Base baseMock;
    @Mock
    private IAttaquableTerre cibleMock;

    @BeforeEach
    public void initEach() throws ValParamException {
        jSnow = new Guerrier(350f, baseMock, 220, "JohnSnow");
    }


    @Test
    @Order(9)
    public void t03_testToString() {
        assertEquals("Guerrier : " + jSnow.getIdentPerso() + " - Niv. Vie : " + jSnow.getNivVie() + " - P Att : "
                + jSnow.getPuissAttaque(), jSnow.toString());
    }

    @Test
    @Order(10)
    public void testALAttaque() {
        jSnow.aLAttaque(cibleMock);
        ArgumentCaptor<Integer> args = ArgumentCaptor.forClass(Integer.class);
        verify(cibleMock,times(1)).estAttaque(args.capture());
        assertEquals(jSnow.getPuissAttaque(), args.getAllValues().get(0));
    }

    @Test
    @Order(11)
    public void testEstAttaque() {
        int patt = 150;
        Float nvie_avant = jSnow.getNivVie();
        jSnow.estAttaque(patt);
        assertEquals(nvie_avant - patt / 20f, jSnow.getNivVie());
    }
}
