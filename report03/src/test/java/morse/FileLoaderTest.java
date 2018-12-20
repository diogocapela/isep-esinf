package morse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileLoaderTest {

   private FileLoader fileLoader;

   @Before
   public void setUp() {
      fileLoader = new FileLoader();
   }

   @Test
   public void testLoadMorseTreeFromFile() {
      MorseTree morseTree = new MorseTree();
      fileLoader.loadMorseTreeFromFile(morseTree, "./src/main/resources/morse_v3.csv");

      // Height
      assertEquals(6, morseTree.height());
   }

   @Test
   public void testLoadLetterTreeFromFile() {
      MorseTree morseTree = new MorseTree();
      fileLoader.loadLetterTreeFromFile(morseTree, "./src/main/resources/morse_v3.csv");

      // Height
      assertEquals(4, morseTree.height());

      for(Character character : morseTree.inOrder()) {
         CharacterType characterType = character.getType();
         if(characterType != CharacterType.ROOT) {
            assertEquals(CharacterType.LETTER, characterType);
         } else {
            assertEquals(CharacterType.ROOT, characterType);
         }
      }
   }

}
