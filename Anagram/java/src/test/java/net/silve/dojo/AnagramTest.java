package net.silve.dojo;


import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void shouldValidate() {
        Anagram anagram = new Anagram();
        assertTrue(anagram.validate("Emmanuelle Béart", "belle amante mûre"));
        //Anagram(Seq("RAME", "AMER", "ARME", "MARE")) shouldBe true
        assertTrue(anagram.validate("ANGLETERRE", "L'ÉTRANGÈRE"));
    }

    @Test
    public void shouldNotValidate() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.validate("ab", "bc"));
    }
}
