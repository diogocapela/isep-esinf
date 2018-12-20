package morse;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MorseTreeTest {

   private FileLoader fileLoader;

   @Before
   public void setUp() {
      fileLoader = new FileLoader();
   }

   /* 2. Morse -> Alphabet
   ======================================================================== */

   @Test
   public void testMorseToAlphabet() {
      MorseTree tree = new MorseTree();
      fileLoader.loadMorseTreeFromFile(tree, "./src/main/resources/morse_v3.csv");

      assertEquals("123", tree.decodeMorseCodeToPhrase(".____ ..___ ...__"));
      assertEquals("A23", tree.decodeMorseCodeToPhrase("._ ..___ ...__"));
      assertEquals("AB3", tree.decodeMorseCodeToPhrase("._ _... ...__"));
      assertEquals("ABC", tree.decodeMorseCodeToPhrase("._ _... _._."));
      assertEquals("!2C", tree.decodeMorseCodeToPhrase("_._.__ ..___ _._."));
      assertEquals("!?C", tree.decodeMorseCodeToPhrase("_._.__ ..__.. _._."));
      assertEquals("!?=", tree.decodeMorseCodeToPhrase("_._.__ ..__.. _..._"));
      assertEquals("123 ABC", tree.decodeMorseCodeToPhrase(".____ ..___ ...__/._ _... _._."));
   }

   /* 4. Alphabet -> Morse
   ======================================================================== */

   @Test
   public void testAlphabetToMorse() {
      MorseTree tree = new MorseTree();
      fileLoader.loadMorseTreeFromFile(tree, "./src/main/resources/morse_v3.csv");

      assertEquals(".____ ..___ ...__", tree.decodePhraseToMorseCode("123"));
      assertEquals("._ ..___ ...__", tree.decodePhraseToMorseCode("A23"));
      assertEquals("._ _... ...__", tree.decodePhraseToMorseCode("AB3"));
      assertEquals("._ _... _._.", tree.decodePhraseToMorseCode("ABC"));
      assertEquals("_._.__ ..___ _._.", tree.decodePhraseToMorseCode("!2C"));
      assertEquals("_._.__ ..__.. _._.", tree.decodePhraseToMorseCode("!?C"));
      assertEquals("_._.__ ..__.. _..._", tree.decodePhraseToMorseCode("!?="));
      assertEquals(".____ ..___ ...__/._ _... _._.", tree.decodePhraseToMorseCode("123 ABC"));
   }

   /* 5. Find Initial Common Sequence
   ======================================================================== */

   @Test
   public void testFindInitialCommonSequence() {
      MorseTree tree = new MorseTree();

      assertEquals(".__", tree.findInitialCommonSequence(".__.", ".___"));
      assertEquals("._ _...", tree.findInitialCommonSequence("._ _..._", "._ _......"));
      assertEquals(".____ ..___ ...__/._ _", tree.findInitialCommonSequence(".____ ..___ ...__/._ _", ".____ ..___ ...__/._ _______"));
   }


   /* 6. Sort by Number of Occurrence of Character Type
   ======================================================================== */

   @Test
   public void testSortByNumberOfOccurrenceOfCharacterType() {
      MorseTree tree = new MorseTree();
      fileLoader.loadMorseTreeFromFile(tree, "./src/main/resources/morse_v3.csv");

      List<String> morseCodes = new ArrayList<>();
      morseCodes.add(".____ ..___ ...__");
      morseCodes.add("._ ..___ ...__");
      morseCodes.add("._ _... ...__");
      morseCodes.add("._ _... _._.");
      morseCodes.add("_._.__ ..___ _._.");
      morseCodes.add("_._.__ ..__.. _._.");
      morseCodes.add("_._.__ ..__.. _..._");

      List<String> result = tree.sortByNumberOfOccurrenceOfCharacterType(morseCodes, CharacterType.LETTER);

      List<String> expected = new ArrayList<>();
      expected.add("ABC");
      expected.add("AB3");
      expected.add("!?C");
      expected.add("!2C");
      expected.add("A23");
      expected.add("!?=");
      expected.add("123");

      assertEquals(expected, result);
   }

}
