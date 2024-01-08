package it.itsrizzoli;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class RubricaUnitTest {
    
    Rubrica rubrica;
    
    @Before
    public void caricaRubrica()  {
        rubrica = new Rubrica();

        Persona p = new Persona("Giorgio", "La Pira");
        Persona p2 = new Persona("Alessandro", "Volta", "+39345628399");

        rubrica.addContatto(p);
        rubrica.addContatto(p2);
    }

    @Test
    public void cercaContattoPerCognomeTest()  {
        Persona personaCercata = rubrica.cercaContattoPerCognome("la pira");

        assertNotNull(personaCercata);
    }

    @Test
    public void cercaContattoPerNomeTest()  {
        Persona personaCercata = rubrica.cercaContattoPerNome("giorgio");

        assertNotNull(personaCercata);
    }

    @Test
    public void cercaContattiPerNomeTest()  {
        Persona[] contattiTrovati = rubrica.cercaContattiPerNome("giorgio");
        
        Persona[] contattiAttesi = new Persona[1];
        contattiAttesi[0] = new Persona("Giorgio", "La Pira");

        assertArrayEquals(contattiAttesi, contattiTrovati);
    }

    @Test
    public void cercaContattiPerInizialeTest()  {
        Persona[] contattiTrovati = rubrica.cercaContattiPerIniziale('G');
        
        Persona[] contattiAttesi = new Persona[1];
        contattiAttesi[0] = new Persona("Giorgio", "La Pira");

        assertArrayEquals(contattiAttesi, contattiTrovati);
    }

    @Test
    public void cercaContattiPerPatternTest()  {
        Persona[] contattiTrovati = rubrica.cercaContattiPerPattern("ior");
        
        Persona[] contattiAttesi = new Persona[1];
        contattiAttesi[0] = new Persona("Giorgio", "La Pira");

        assertArrayEquals(contattiAttesi, contattiTrovati);
    }
}
