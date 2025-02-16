import java.util.HashMap;

public class Translator {

    // Detta är min logikklass där jag har HashMap med bokstäver till morsekod och omvänt morsekod till bokstäver
    // Har valt String, String i HashMapen eftersom det var det lättaste och mer hanterbart och blev det inte rörigt med massa konverteringar i min kod
    // Har satt HashMapsen till private så att de inte går att ändra utifrån
    private HashMap<String, String> letterToMorse;
    private HashMap<String, String> morseToLetter;

    // Min konstruktor för att initiera HashMapsen har jag däremot satt till public så vi kommer åt de i andra klasserna
    public Translator() {
        letterToMorse = new HashMap<>();
        morseToLetter = new HashMap<>();

        // Nedan är de lagrade värdena i HashMapen
        letterToMorse.put("A", ".-");
        letterToMorse.put("B", "-...");
        letterToMorse.put("C", "-.-.");
        letterToMorse.put("D", "..");
        letterToMorse.put("E", ".");
        letterToMorse.put("F", "..-.");
        letterToMorse.put("G", "--.");
        letterToMorse.put("H", "....");
        letterToMorse.put("I", "..");
        letterToMorse.put("J", ".---");
        letterToMorse.put("K", "-.-");
        letterToMorse.put("L", ".-..");
        letterToMorse.put("M", "--");
        letterToMorse.put("N", "-.");
        letterToMorse.put("O", "---");
        letterToMorse.put("P", ".--.");
        letterToMorse.put("Q", "--.-");
        letterToMorse.put("R", ".-.");
        letterToMorse.put("S", "...");
        letterToMorse.put("T", "-");
        letterToMorse.put("U", "..-");
        letterToMorse.put("V", "...-");
        letterToMorse.put("W", ".--");
        letterToMorse.put("X", "-..-");
        letterToMorse.put("Y", "-.--");
        letterToMorse.put("Z", "--..");

        // Som nämnt högre upp har en omvänd hashmap skapats för att vi ska kunna översätta åt båda hållen med våran Translator
        for (String letter : letterToMorse.keySet()) {
            String morse = letterToMorse.get(letter);
            morseToLetter.put(morse, letter);
        }
    }


    // Har skapat metoder nedan för översättning åt båda hållen


    // Översättning av en text till morsekod

    public String getMorseFromLetter(String inputText) {
        inputText = inputText.toUpperCase(); // omvandlar all input text till versaler så det kan hittas i hashmapen
        String morseCode = ""; // lagrar morsekoden

        for (char c : inputText.toCharArray()) { //loopar igenom varje bokstav i texten som skrivs
            String letter = String.valueOf(c); // omvandlaar bokstaven till sträng
            if (letterToMorse.containsKey(letter)) { // kollar här om bokstaven finns i vår hashmap ovan
                morseCode += letterToMorse.get(letter); // hämtar boksavens morsekod
            } else if (!letter.equals(" ")) { // kollar om bokstaven/tecknet inte är ett mellanslag
                return "invalid text has been detected '" + letter + "' please restart program."; // returnera felmeddelande för inmatade ogiltiga tecken
            }
        }
        return morseCode; // returnerar den översatta morsekoden
    }

    // Översättning av en morsekod till en bokstav

    public String getLetterFromMorse(String inputMorse) {
        String[] morseSymbols = inputMorse.split(" ");  // delar upp morsekoden separerade symboler med mellanslag för annars hittas de inte i hashmapen
        String text = ""; // lagrar texten

        for (String morseSymbol : morseSymbols) { //loopar igenom tecknedna morsekoden som skrivits in
            if (morseToLetter.containsKey(morseSymbol)) { // kollar här om morse finns i vår hashmap ovan
                text += morseToLetter.get(morseSymbol); // hämtar morsekodens bokstav
            } else {
                return "invalid morse code has been detected: '" + morseSymbol + "' please restart program."; // returnera felmeddelande för inmatade ogiltiga morse tecken
            }

        }

        return text; // returnerar den översatta morsekoden
    }

}