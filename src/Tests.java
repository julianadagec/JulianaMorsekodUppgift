import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    // Testar mot vår hashmap att bokstäver skrivs ut korrekt även vid inmatning av gemener istället för versaler
    @Test
    void testSmallLetterToMorse() {
        Translator translator = new Translator();
        String letter = "a";
        String expected = ".-";
        String result = translator.getMorseFromLetter(letter);
        assertEquals(expected, result);
    }

    // Testar om översättning från text till morsekod fungerar korrekt
    @Test
    void testTextToMorse() {
        Translator textToMorse = new Translator();
        String text = "Hello";
        String expected = "......-...-..---";
        String result = textToMorse.getMorseFromLetter(text);
        assertEquals(expected, result);
    }

    //Testar om översättning från  morsekod till text fungerar korrekt
    @Test
    void testMorseToText() {
        Translator morseToText = new Translator();
        String morse = ".... . .-.. .-.. ---";
        String expected = "HELLO";
        String result = morseToText.getLetterFromMorse(morse);
        assertEquals(expected, result);
    }

    // Testar om felaktig text med icke giltiga tecken fångas upp med felmeddelande
    @Test
    void testInvalidText() {
        Translator textToMorse = new Translator();
        String text = "Hello@";
        String expected = "invalid text has been detected '@' please restart program.";
        String result = textToMorse.getMorseFromLetter(text);
        assertEquals(expected, result);
    }

    // Testar om felaktig morsekod med icke giltiga tecken fångas upp med felmeddelande
    @Test
    void testInvalidMorse() {
        Translator morseToText = new Translator();
        String morse = "...---...";
        String expected = "invalid morse code has been detected: '...---...' please restart program.";
        String result = morseToText.getLetterFromMorse(morse);
        assertEquals(expected, result);
    }
}